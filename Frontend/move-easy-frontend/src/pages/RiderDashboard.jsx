import { useNavigate } from "react-router-dom";
import RideMap from "../components/RideMap";

const RiderDashboard = () => {
  const navigate = useNavigate();

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  // Receive pickup + drop + distance info from map
  const handleLocations = (data) => {
    console.log("Ride info:", data);
  };

  return (
    <div className="min-h-screen bg-gray-800 text-white">

      <div className="p-8">

        <h2 className="text-3xl font-semibold mb-6">
          Rider Dashboard
        </h2>

        {/* Book Ride Card */}
        <div className="bg-gray-900 p-6 rounded-lg mb-6 shadow-lg">

          <h3 className="text-xl mb-3">Book a Ride</h3>

          <p className="text-gray-400 mb-4">
            Select pickup and destination from the map.
          </p>

          {/* Map */}
          <RideMap onLocationsSelected={handleLocations} />

          <button className="bg-yellow-500 px-6 py-2 rounded hover:bg-yellow-600 font-semibold mt-4">
            Book Ride
          </button>

        </div>

        {/* Ride History */}
        <div className="bg-gray-900 p-6 rounded-lg shadow-lg">
          <h3 className="text-xl mb-4">Ride History</h3>

          <p className="text-gray-400">
            No rides yet.
          </p>
        </div>

      </div>
    </div>
  );
};

export default RiderDashboard;