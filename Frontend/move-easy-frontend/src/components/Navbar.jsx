import { Link, useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();
  const token = localStorage.getItem("token");

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  return (
    <nav className="bg-gray-900 text-white p-4 flex justify-between items-center shadow-md">
      <Link to="/" className="text-xl font-bold text-yellow-400">
        MoveEasy
      </Link>

      <div className="space-x-4 flex items-center">
        {token ? (
          <>
            <Link
              to="/dashboard"
              className="hover:text-yellow-400 transition"
            >
              Dashboard
            </Link>

            <button
              onClick={handleLogout}
              className="bg-red-500 px-4 py-1 rounded hover:bg-red-600 transition"
            >
              Logout
            </button>
          </>
        ) : (
          <>
            <Link
              to="/login"
              className="hover:text-yellow-400 transition"
            >
              Login
            </Link>

            <Link
              to="/register"
              className="hover:text-yellow-400 transition"
            >
              Register
            </Link>
          </>
        )}
      </div>
    </nav>
  );
};

export default Navbar;