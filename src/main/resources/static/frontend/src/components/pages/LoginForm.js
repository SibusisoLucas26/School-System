import axios from "axios";
import React, { useState } from "react";

const LoginForm = ({setLogg, setUserIn}) => {
    const [showLoginForm, setShowLoginForm] = useState(false);
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [error, setError] = useState("");
    const [loginData] = useState({ username: '', password: '' });
    const [registerData, setRegisterData] = useState({ username: '', firstname: '', lastname: '', password: '' });
    const [userDetails, setUserDetails] = useState(null);
   // const history = useHistory();

     const toggleLoginForm = () => {
        setShowLoginForm(!showLoginForm);
     //  setShowRegisterForm(false);
       // setMessage('');
    };

    //////// AUTH FYNCTION ////////////
     const handleRegister = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/register', registerData);
           // setMessage('Registration successful!');
            console.log(response.data);
        } catch (error) {
           // setMessage('Registration failed. Please try again.');
            console.error(error);
        }
    };

    const handleLogin = async (e) => {
        e.preventDefault();

      
        try {
            const response = await axios.post("http://localhost:8080/auth/login", loginData, {
                withCredentials: true, // Add this line to allow credentials (cookies)
                
            });
            console.log("Login successful", response.data);
    
            setLogg(true);
            setUserIn(response.data); 
        
            
        } catch (error) {
            console.error("Login failed", error);
            setError("Invalid credentials, please try again.");
        }
    };
//////////////////////////////////////////////////////////////////////////// 
    return (
        <>
        
        
    <ul className="buttons">
      <div className="login">
        <button className="button" onClick={toggleLoginForm}>
          {showLoginForm ? "Show Register Form" : "Show Login Form"}
        </button>
      </div>

      {showLoginForm ? (
        <div className="form-container">
          <form onSubmit={handleLogin}>
            <h2>Login</h2>
            <div>
              <label htmlFor="username">Username:</label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
              />
            </div>
            <div>
              <label htmlFor="password">Password:</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            {error && <p className="error">{error}</p>}
            <button className="button" type="submit">Login</button>
          </form>
        </div>
      ) : (
        <div className="form-container">
          <form onSubmit={handleRegister}>
            <h2>Register</h2>
            <div>
              <label htmlFor="username">Username:</label>
              <input
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
              />
            </div>

            <div>
              <label htmlFor="firstname">Firstname:</label>
              <input
                type="text"
                id="firstname"
                value={firstname}
                onChange={(e) => setFirstname(e.target.value)}
                required
              />
            </div>

            <div>
              <label htmlFor="lastname">Lastname:</label>
              <input
                type="text"
                id="lastname"
                value={lastname}
                onChange={(e) => setLastname(e.target.value)}
                required
              />
            </div>

            <div>
              <label htmlFor="password">Password:</label>
              <input
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            {error && <p className="error">{error}</p>}
            <button className="button" type="submit">Register</button>
          </form>
        </div>
      )}
    </ul>
        
        
        </>
        
    );




};

export default LoginForm;
