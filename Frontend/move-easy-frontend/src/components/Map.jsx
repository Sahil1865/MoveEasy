import { GoogleMap, LoadScript, Marker } from "@react-google-maps/api";

const containerStyle = {
  width: "100%",
  height: "400px",
};

const center = {
  lat: 19.076,
  lng: 72.8777,
};

function MapPicker({ onLocationSelect }) {

  const handleClick = (event) => {
    const lat = event.latLng.lat();
    const lng = event.latLng.lng();

    onLocationSelect({ latitude: lat, longitude: lng });
  };

  return (
    <LoadScript googleMapsApiKey="AIzaSyBdHwlO9ihvelYsOs7TJgMRsPsMudbqupg">
      <GoogleMap
        mapContainerStyle={containerStyle}
        center={center}
        zoom={12}
        onClick={handleClick}
      >
      </GoogleMap>
    </LoadScript>
  );
}

export default MapPicker;