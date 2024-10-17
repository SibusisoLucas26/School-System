// src/components/ScheduleTable.js
import React, { useEffect, useState } from "react";
import { Table, Card, Spinner, Alert } from "react-bootstrap";

const ScheduleTable = () => {
  const [schedule, setSchedule] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("/data/schedule.json")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch schedule data.");
        }
        return response.json();
      })
      .then((data) => {
        setSchedule(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching schedule:", error);
        setError("Failed to load schedule.");
        setLoading(false);
      });
  }, []);

  if (loading)
    return (
      <Card className="shadow-sm">
        <Card.Body className="text-center">
          <Spinner animation="border" variant="primary" />
          <p className="mt-2">Loading Schedule...</p>
        </Card.Body>
      </Card>
    );

  if (error)
    return (
      <Card className="shadow-sm">
        <Card.Body>
          <Alert variant="danger">{error}</Alert>
        </Card.Body>
      </Card>
    );

  return (
    <Card className="shadow-sm">
      <Card.Body>
        <Card.Title>Schedule</Card.Title>
        <Table bordered responsive>
          <thead className="thead-dark">
            <tr>
              <th>Day</th>
              <th>Time</th>
              <th>Class</th>
            </tr>
          </thead>
          <tbody>
            {schedule.length > 0 ? (
              schedule.map((session, index) => (
                <tr key={index}>
                  <td>{session.day}</td>
                  <td>{session.time}</td>
                  <td>{session.className}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="3" className="text-center">
                  No schedule available.
                </td>
              </tr>
            )}
          </tbody>
        </Table>
      </Card.Body>
    </Card>
  );
};

export default ScheduleTable;
