import { Navigate, BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Login from "./pages/Login";
import Register from "./pages/Register";
import RegisterDriver from "./pages/RegisterDriver";
import OAuthSuccess from "./pages/OAuthSuccess";
import RiderDashboard from "./pages/RiderDashboard";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/register-driver" element={<RegisterDriver />} />
        <Route path="/oauth-success" element={<OAuthSuccess />} />
        <Route path="/dashboard" element={<RiderDashboard />} />
        <Route path="/dashboard" element={<RiderDashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;