
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Alert, Card, Spinner, Table } from "react-bootstrap";

const AssignmentsTable = () => {
  const [assignments, setAssignments] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchAssignments = async () => {
      try {
        const response = await axios.get("/api/teachers/assignments", {
          withCredentials: true, // Include credentials if your API requires authentication
        });
        setAssignments(response.data);
        setLoading(false);
      } catch (err) {
        console.error("Error fetching assignments:", err);
        setError("Failed to load assignments.");
        setLoading(false);
      }
    };

    fetchAssignments();
  }, []);

  if (loading)
    return (
      <Card className="shadow-sm">
        <Card.Body className="text-center">
          <Spinner animation="border" variant="primary" />
          <p className="mt-2">Loading Assignments...</p>
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
        <Card.Title>Assignments</Card.Title>
        <Table bordered responsive>
          <thead className="thead-dark">
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Due Date</th>
            </tr>
          </thead>
          <tbody>
            {assignments.length > 0 ? (
              assignments.map((assignment) => (
                <tr key={assignment.id}>
                  <td>{assignment.title}</td>
                  <td>{assignment.description}</td>
                  <td>
                    {new Date(assignment.dueDate).toLocaleDateString()}
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="3" className="text-center">
                  No assignments available.
                </td>
              </tr>
            )}
          </tbody>
        </Table>
      </Card.Body>
    </Card>
  );
};

export default AssignmentsTable;


