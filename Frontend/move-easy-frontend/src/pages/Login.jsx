import { useState } from "react";
import api from "../api/axiosConfig";

const Login = () => {
  const [form, setForm] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await api.post("/auth/login", form);
      localStorage.setItem("token", res.data.token);
      alert("Login successful");
    } catch (err) {
      alert("Invalid credentials");
    }
  };

  const handleGoogleLogin = () => {
    window.location.href =
      "http://localhost:8080/oauth2/authorization/google";
  };

  return (
    <div className="flex justify-center items-center h-screen bg-gray-800">
      <div className="bg-gray-900 p-8 rounded-lg w-96 shadow-lg">

        <h2 className="text-white text-2xl mb-6 text-center">Login</h2>

        <form onSubmit={handleSubmit}>
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
            Login
          </button>
        </form>

        {/* Divider */}
        <div className="flex items-center my-6">
          <div className="flex-1 h-px bg-gray-600"></div>
          <span className="px-3 text-gray-400 text-sm">OR</span>
          <div className="flex-1 h-px bg-gray-600"></div>
        </div>

        {/* Google Login */}
        <button
          onClick={handleGoogleLogin}
          className="w-full bg-white text-black p-2 rounded font-semibold hover:bg-gray-200"
        >
          Continue with Google
        </button>

      </div>
    </div>
  );
};

export default Login;