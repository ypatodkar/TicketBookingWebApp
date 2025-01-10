import React from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import "../App.css";
import { useNavigate } from "react-router-dom";

const Header = () => {
  let navigate = useNavigate();
  return (
    <div>
      <nav className="navbar-style navbar">
        <Navbar collapseOnSelect expand="lg" variant="dark">
          <Container fluid>
            <Navbar.Brand className="header-font-logo mx-3" href="#home">
              Book It!
            </Navbar.Brand>
            &emsp;&emsp;&emsp;
            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link  onClick={() => navigate("/Admin/AddTheatre")} className="header-font-size" href="#movies">
                  Movies
                </Nav.Link>
                <Nav.Link onClick={() => navigate("/Admin/HomePage")} className="header-font-size" href="#movies">
                  Events
                </Nav.Link>
                <Nav.Link className="header-font-size" href="#movies">
                  Activities
                </Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <Navbar collapseOnSelect expand="lg" variant="dark">
          <Nav className="float-right mx-4">
            <Nav.Link
              className="header-font-size"
              onClick={() => navigate("/SignIn")}
            >
              Login
            </Nav.Link>
            &emsp;
            <Nav.Link
              className="header-font-size"
              onClick={() => navigate("/Register")}
            >
              Sign up
            </Nav.Link>
          </Nav>
          &emsp;
        </Navbar>
      </nav>
    </div>
  );
};

export default Header;
