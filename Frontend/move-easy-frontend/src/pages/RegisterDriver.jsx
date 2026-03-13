import { useState } from "react";
import api from "../api/axiosConfig";
import { Link } from "react-router-dom";

const RegisterDriver = () => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
    role: "DRIVER",   // Automatically set
  });

  const handleGoogleRegister = () => {
    window.location.href =
     "http://localhost:8080/oauth2/authorization/google?role=DRIVER";
    };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post("/auth/register", form);
      alert("Driver registration successful");
    } catch (err) {
      alert("Error registering driver");
    }
  };

  return (
    <div className="flex justify-center items-center h-screen bg-gray-800">
      <form onSubmit={handleSubmit} className="bg-gray-900 p-8 rounded-lg w-96 shadow-lg">
        <h2 className="text-white text-2xl mb-6 text-center">Driver Register</h2>

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
          className="w-full p-2 mb-6 bg-gray-700 text-white rounded"
          onChange={handleChange}
        />

        <button className="w-full bg-yellow-500 hover:bg-yellow-600 p-2 rounded font-semibold">
          Register as Driver
        </button>

        <p className="text-gray-400 text-sm text-center mt-4">
          Just need a ride?{" "}
          <Link to="/register" className="text-yellow-400 hover:underline">
            Register as Rider
          </Link>

        <button
            type="button"
            onClick={handleGoogleRegister}
            className="w-full bg-white text-black p-2 rounded font-semibold mt-4"
            >
            Register as Driver with Google
        </button>
        </p>
      </form>
    </div>
  );
};

export default RegisterDriver;