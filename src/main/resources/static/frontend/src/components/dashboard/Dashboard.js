// src/components/Dashboard.js

import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import NavigationBar from "./Navbar"; // Ensure the exported component name matches
import ClassesTable from "./ClassesTable";
import AssignmentsTable from "./AssignmentsTable";
import MessagesList from "./MessagesList";
import ScheduleTable from "./ ScheduleTable";

const Dashboard = () => {
  return (
    <>
      <NavigationBar />
      <Container className="mt-5">
        <h1 className="mb-4 text-primary">Teacher Dashboard</h1>
        <Row>
          <Col md={6}>
            <ClassesTable />
          </Col>
          <Col md={6}>
            <AssignmentsTable />
          </Col>
        </Row>
        <Row className="mt-5">
          <Col md={6}>
            <MessagesList />
          </Col>
          <Col md={6}>
            <ScheduleTable />
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default Dashboard;

