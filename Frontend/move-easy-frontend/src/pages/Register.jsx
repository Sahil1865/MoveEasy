import { useState } from "react";
import api from "../api/axiosConfig";
import { Link } from "react-router-dom";

const Register = () => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
    role: "USER",   // Default rider role
  });

  const handleGoogleRegister = () => {
  window.location.href =
    "http://localhost:8080/oauth2/authorization/google?role=USER";
};

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post("/auth/register", form);
      alert("Registration successful");
    } catch (err) {
      alert("Error registering user");
    }
  };

  return (
    <div className="flex justify-center items-center h-screen bg-gray-800">
      <form onSubmit={handleSubmit} className="bg-gray-900 p-8 rounded-lg w-96 shadow-lg">
        <h2 className="text-white text-2xl mb-6 text-center">Register</h2>

        <input
          type="text"
          name="name"
          placeholder="Full Name"
          className="w-full p-2 mb-4 bg-gray-700 text-white rounded"
          onChange={handleChange}
        />

        <input
          type="email"
          name="email"
          placeholder="Email"
          className="w-full p-2 mb-4 bg-gray-700 text-white rounded"
          onChange={handleChange}
        />

        <input
          type="password"
          name="password"
          placeholder="Password"
          className="w-full p-2 mb-4 bg-gray-700 text-white rounded"
          onChange={handleChange}
        />

        <button className="w-full bg-yellow-500 hover:bg-yellow-600 p-2 rounded font-semibold">
          Register
        </button>

        <p className="text-gray-400 text-sm text-center mt-4">
          Want to drive?{" "}
          <Link
            to="/register-driver"
            className="text-yellow-400 hover:underline"
          >
            Register as a Driver
          </Link>

          <button
            type="button"
            onClick={handleGoogleRegister}
            className="w-full bg-white text-black p-2 rounded font-semibold mt-4"
          >
            Register with Google
          </button>
        </p>
      </form>
    </div>
  );
};

export default Register;