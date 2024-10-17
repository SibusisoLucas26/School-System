// src/components/ClassesTable.js
import React, { useEffect, useState } from "react";
import { Table, Card, Spinner, Alert } from "react-bootstrap";

const ClassesTable = () => {
  const [classes, setClasses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("/data/classes.json") // Ensure this path is correct
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch classes data.");
        }
        return response.json();
      })
      .then((data) => {
        setClasses(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching classes:", error);
        setError("Failed to load classes.");
        setLoading(false);
      });
  }, []);

  if (loading)
    return (
      <Card className="mb-4 shadow-sm">
        <Card.Body className="text-center">
          <Spinner animation="border" variant="primary" />
          <p className="mt-2">Loading Classes...</p>
        </Card.Body>
      </Card>
    );

  if (error)
    return (
      <Card className="mb-4 shadow-sm">
        <Card.Body>
          <Alert variant="danger">{error}</Alert>
        </Card.Body>
      </Card>
    );

  return (
    <Card className="mb-4 shadow-sm">
      <Card.Body>
        <Card.Title>Your Classes</Card.Title>
        <Table striped bordered hover responsive>
          <thead className="thead-dark">
            <tr>
              <th>Class Name</th>
              <th>Grade Level</th>
              <th>Number of Students</th>
            </tr>
          </thead>
          <tbody>
            {classes.length > 0 ? (
              classes.map((cls) => (
                <tr key={cls.id}>
                  <td>{cls.name}</td>
                  <td>{cls.gradeLevel}</td>
                  <td>{cls.studentCount}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="3" className="text-center">
                  No classes available.
                </td>
              </tr>
            )}
          </tbody>
        </Table>
      </Card.Body>
    </Card>
  );
};

export default ClassesTable;
