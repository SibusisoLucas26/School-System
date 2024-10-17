// src/components/MessagesList.js
import React, { useEffect, useState } from "react";
import { ListGroup, Card } from "react-bootstrap";

const MessagesList = () => {
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("/data/messages.json")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setMessages(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching messages:", error);
        setError("Failed to load messages.");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading messages...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

  return (
    <Card className="mb-4 shadow-sm">
      <Card.Body>
        <Card.Title>Messages</Card.Title>
        <ListGroup variant="flush">
          {messages.length > 0 ? (
            messages.map((message) => (
              <ListGroup.Item key={message.id}>
                <a
                  href={`/teachers/messages/${message.id}`}
                  className="text-primary font-weight-bold"
                >
                  {message.subject}
                </a>
              </ListGroup.Item>
            ))
          ) : (
            <ListGroup.Item className="text-center">
              No messages available.
            </ListGroup.Item>
          )}
        </ListGroup>
      </Card.Body>
    </Card>
  );
};

export default MessagesList;
