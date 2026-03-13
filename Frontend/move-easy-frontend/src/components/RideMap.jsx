import {
  GoogleMap,
  DirectionsRenderer,
  Autocomplete,
  useJsApiLoader
} from "@react-google-maps/api";
import { useRef, useState, useEffect } from "react";

const containerStyle = {
  width: "100%",
  height: "450px"
};

const centerDefault = { lat: 19.076, lng: 72.8777 };
const libraries = ["places"];

export default function RideMap({ onLocationsSelected }) {

  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: import.meta.env.VITE_GOOGLE_MAPS_API_KEY,
    libraries
  });

  const mapRef = useRef(null);
  const pickupAutoRef = useRef(null);
  const dropAutoRef = useRef(null);

  const [pickup, setPickup] = useState(null);
  const [pickupAddress, setPickupAddress] = useState("");
  const [drop, setDrop] = useState(null);
  const [directions, setDirections] = useState(null);
  const [center, setCenter] = useState(centerDefault);

  // Detect user location
  useEffect(() => {
    navigator.geolocation.getCurrentPosition((pos) => {
      const loc = {
        lat: pos.coords.latitude,
        lng: pos.coords.longitude
      };
      setCenter(loc);
      setPickup(loc);
    });
  }, []);

  const onMapLoad = (map) => {
    mapRef.current = map;
  };

  // When user drags map
  const handleMapIdle = () => {
    if (!mapRef.current) return;

    const c = mapRef.current.getCenter();
    const location = { lat: c.lat(), lng: c.lng() };

    setPickup(location);

    // Reverse geocode for address
    const geocoder = new window.google.maps.Geocoder();
    geocoder.geocode({ location }, (results, status) => {
      if (status === "OK" && results[0]) {
        setPickupAddress(results[0].formatted_address);
      }
    });
  };

  // Drop selected from search
  const handleDropChanged = () => {
    const place = dropAutoRef.current.getPlace();
    if (!place.geometry) return;

    const location = {
      lat: place.geometry.location.lat(),
      lng: place.geometry.location.lng()
    };

    setDrop(location);
    calculateRoute(location);
  };

  const calculateRoute = (dropLocation) => {
    if (!pickup || !dropLocation) return;

    const directionsService = new window.google.maps.DirectionsService();

    directionsService.route(
      {
        origin: pickup,
        destination: dropLocation,
        travelMode: window.google.maps.TravelMode.DRIVING
      },
      (result, status) => {
        if (status === "OK") {
          setDirections(result);

          const leg = result.routes[0].legs[0];

          onLocationsSelected({
            pickup,
            drop: dropLocation,
            distance: leg.distance.text,
            duration: leg.duration.text
          });
        }
      }
    );
  };

  if (!isLoaded) return <p>Loading Map...</p>;

  return (
    <div className="relative">

      {/* Search Panel */}
      <div className="absolute top-4 left-4 right-4 bg-white p-4 rounded-lg shadow-lg z-10 flex flex-col gap-2">

        <input
          value={pickupAddress}
          readOnly
          placeholder="Pickup location"
          className="p-3 rounded border text-black"
        />

        <Autocomplete onLoad={(ref) => (dropAutoRef.current = ref)} onPlaceChanged={handleDropChanged}>
          <input
            placeholder="Where to?"
            className="p-3 rounded border text-black"
          />
        </Autocomplete>

      </div>

      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={14}
        onLoad={onMapLoad}
        onIdle={handleMapIdle}
        options={{
          fullscreenControl: false,
          streetViewControl: false,
          mapTypeControl: false
        }}
      >
        {directions && <DirectionsRenderer directions={directions} />}
      </GoogleMap>

      {/* Fixed center pin */}
      <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-full text-red-500 text-3xl">
        📍
      </div>

    </div>
  );
}