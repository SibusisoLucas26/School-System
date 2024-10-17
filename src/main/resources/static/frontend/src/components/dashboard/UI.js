// src/components/Dashboard/Profile.js

import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Profile = () => {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    // Fetch user profile from backend
    axios.get('http://localhost:8080/auth/profile', { withCredentials: true })
      .then(response => setProfile(response.data))
      .catch(error => console.error(error));
  }, []);



  return (
    <>
      <div class="container mt-5 p-4">
        <h1 class="mb-4">Teacher Dashboard</h1>
        <div class="row">
          <div class="col-md-6">
            <h2>Your Classes</h2>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>Class Name</th>
                  <th>Grade Level</th>
                  <th>Number of Students</th>
                </tr>
              </thead>
              <tbody>
                <tr >
                  <td >Class Name</td>
                  <td >Grade Level</td>
                  <td >Number of Students</td>
                </tr>

                <tr>
                  <td>Math 101</td>
                  <td>Grade 9</td>
                  <td>30</td>
                </tr>
                <tr>
                  <td>Science 202</td>
                  <td>Grade 10</td>
                  <td>25</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="col-md-6">
            <h2>Assignments</h2>
            <a href="@{/assignments/new}" class="btn btn-primary mb-3">Create Assignment</a>
            <table class="table">
              <thead>
                <tr>
                  <th>Title</th>
                  <th>Description</th>
                  <th>Due Date</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr >
                  <td >Title</td>
                  <td >Description</td>
                  <td >Due Date</td>
                  <td>
                    <a href="@{/assignments/edit/{id}(id=${assignment.id})}"
                      class="btn btn-primary">Edit</a>
                    <a href="@{/assignments/delete/{id}(id=${assignment.id})}"
                      class="btn btn-danger">Delete</a>
                  </td>
                </tr>

              </tbody>
            </table>
          </div>
        </div>
        <div class="row mt-5">
          <div class="col-md-6">
            <h2>Messages</h2>
            <ul class="list-group">
              <li class="list-group-item">
                <a href="@{/teachers/messages/{id}(id=${message.id})}" text="${message.subject}">Message
                  Subject</a>
              </li>

              <li class="list-group-item">
                <a href="#">Parent Meeting</a>
              </li>
              <li class="list-group-item">
                <a href="#">Staff Meeting Reminder</a>
              </li>
            </ul>
          </div>
          <div class="col-md-6">
            <h2>Schedule</h2>
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>Day</th>
                  <th>Time</th>
                  <th>Class</th>
                </tr>
              </thead>
              <tbody>

                <tr>
                  <td>Monday</td>
                  <td>10:00 AM - 11:00 AM</td>
                  <td>Math 101</td>
                </tr>
                <tr>
                  <td>Tuesday</td>
                  <td>11:00 AM - 12:00 PM</td>
                  <td>Science 202</td>
                </tr>
                <tr>
                  <td>Wednesday</td>
                  <td>09:00 AM - 10:00 AM</td>
                  <td>Math 101</td>
                </tr>
                <tr>
                  <td>Thursday</td>
                  <td>10:00 AM - 11:00 AM</td>
                  <td>Science 202</td>
                </tr>
                <tr>
                  <td>Friday</td>
                  <td>11:00 AM - 12:00 PM</td>
                  <td>Math 101</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

      </div>
    </>
  );
};

export default Profile;
