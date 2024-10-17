import './App.css';
import React, { useState } from "react";
import Home from './components/pages/Home';
import LoginForm from './components/pages/LoginForm'; 
import Dashboard from './components/dashboard/Dashboard';
import Navbar from './components/pages/Navbar'; 

const App = () => {
  const [isLogged, setIsLogged] = useState(false);
  const [userInfo, setUserInfo] = useState(null);

  return (
    <>
    <Navbar></Navbar>
    <div>
      {!isLogged ? (
        <LoginForm setLogg={setIsLogged} setUserIn={setUserInfo} />
      ) : (
        <Dashboard userInfo={userInfo} setLogg={setIsLogged} />
      )}
    </div>
    </>
    
  );
};
export default App;
