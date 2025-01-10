import { useState } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import React from "react";
import "../LoginForm.css";
import LoginIcon from "@mui/icons-material/Login";
import GoogleIcon from "@mui/icons-material/Google";
import FacebookIcon from "@mui/icons-material/Facebook";

const LoginForm = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const submitHandler = (event) => {
    event.preventDefault();
    const loginData = {
      email: email,
      password: password,
    };
    console.log(loginData);
    setEmail("");
    setPassword("");
  };
  function emailHandler(event) {
    setEmail(event.target.value);
  }
  function passwordHandler(event) {
    setPassword(event.target.value);
  }

  return (
    <div className="container-fluid body">
      <div className="row">
        <div className="mx-auto center col-md-4">
          <h2 className="signin-header"> Welcome to Book It</h2>
        </div>
        <div className="row">
          <div className="col-md-4 design h-100 ">
            <Form>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                {/* <Form.Label>Email address</Form.Label> */}
                <Form.Control type="email" placeholder="Enter email" />
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                {/* <Form.Label>Password</Form.Label> */}
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
              <Form.Group className="mb-3" controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Remember me" />
              </Form.Group>
              <Form.Group>
                <div>
                  <LoginIcon fontSize="large"></LoginIcon>&nbsp;&nbsp;&nbsp;
                  <Button
                    className="btn btn-secondary"
                    variant="outline-dark"
                    type="submit"
                  >
                    Sign In
                  </Button>
                </div>
              </Form.Group>
              <Form.Group className="mt-2">
                <div>
                  <GoogleIcon color="success" fontSize="large"></GoogleIcon>
                  &nbsp;&nbsp;&nbsp;
                  <Button
                    className="btn btn-secondary"
                    variant="outline-dark"
                    type="submit"
                  >
                    Sign In Using Google
                  </Button>
                </div>
              </Form.Group>
              <Form.Group className="mt-2">
                <div>
                  <FacebookIcon color="warning" fontSize="large"></FacebookIcon>
                  &nbsp;&nbsp;&nbsp;
                  <Button
                    className="btn btn-secondary"
                    variant="outline-dark"
                    type="submit"
                  >
                    Sign In Using Facebook
                  </Button>
                </div>
              </Form.Group>
            </Form>
          </div>
        </div>
      </div>
    </div>
  );
};
export default LoginForm;
