import React from "react";

function Navbar() {
    return (
        <>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">School Management System</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Admin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/teachers">Teachers</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/classes">Classes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/schedule">Schedule</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/reports">Reports</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/settings">Settings</a>
                        </li>
                    </ul>
                </div>
            </nav>


        </>
    )
}
export default Navbar;
