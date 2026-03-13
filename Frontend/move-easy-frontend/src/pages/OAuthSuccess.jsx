import { useEffect } from "react";
import { useSearchParams, useNavigate } from "react-router-dom";

const OAuthSuccess = () => {

  const [params] = useSearchParams();
  const navigate = useNavigate();

  useEffect(() => {

    const token = params.get("token");

    if(token){
      localStorage.setItem("token", token);
      navigate("/dashboard");
    }

  },[]);

  return <div>Logging you in...</div>;
};

export default OAuthSuccess;