import React from 'react';
import { useLocation } from "react-router-dom";


const UserDashboard = ({userInfo, setLogg}) => {
  
 

  return (
    <> 
    
      <div className="dashboard-container">
      <h2>Welcome, {userInfo.firstname} {userInfo.lastname}</h2>
      <p><strong>Username:</strong> {userInfo.username}</p>
     
     
      {/* Add more details if necessary */}
      <button className="logout-button" onClick={() => setLogg(false)}>Logout</button>
    </div>
    
    </>

  );
};
export default UserDashboard;
