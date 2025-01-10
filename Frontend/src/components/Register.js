import React from "react";
import { Button, Form, Col, Row } from "react-bootstrap";
import "../register.css";

const Register = () => {
  return (
    <div className="body">
      <div className="col-4 alignment shadow p-4 mb-5 rounded">
        <h3>Register</h3>
        <Form>
          <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridname">
              <Form.Control type="text" placeholder="Enter First Name" />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridlastName">
              <Form.Control type="text" placeholder="Enter Last Name" />
            </Form.Group>
          </Row>
          <Row>
            <Form.Group className="mb-3" controlId="formGriddob">
              <Form.Label>Birthdate</Form.Label>
              <Form.Control type="date" />
            </Form.Group>
          </Row>
          <Row>
            <Form.Group>
              {["Male", "Female"].map((type) => (
                <div key={`default-${type}`} className="mb-3">
                  <Form.Check
                    name="gender"
                    type="radio"
                    id={`${type}`}
                    label={`${type}`}
                  />
                </div>
              ))}
            </Form.Group>
          </Row>
          <Row>
            <Form.Group className="mb-3" controlId="formGridEmail">
              <Form.Control type="email" placeholder="Email Address" />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridPass">
              <Form.Control type="text" placeholder="Enter Password" />
            </Form.Group>
          </Row>
          <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridNumber">
              <Form.Control placeholder="Phone Number" />
            </Form.Group>
          </Row>
          <Button
            className="buttonalign"
            variant="btn btn-secondary"
            type="submit"
          >
            Register
          </Button>
        </Form>
      </div>
    </div>
  );
};
export default Register;
