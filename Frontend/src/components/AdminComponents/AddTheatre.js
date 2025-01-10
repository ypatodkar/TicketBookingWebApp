import React from 'react';
import Header from './Header';
import { Button, Form, Col, Row } from "react-bootstrap";
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import Footer from '../Footer';

const AddTheatre = () =>{
return (
    <div>
<Header></Header>
<div className="body">
      <div className="col-4 alignment shadow p-4 mb-5  rounded">
        <h3 style={{color: "white"}}>Add Theatre</h3>
        <Form>
          <Row className="mb-3">
            <Form.Group as={Col} controlId="noOfScreens">
              <Form.Control type="text" placeholder="Number of Screens" />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="theatreName">
              <Form.Control type="text" placeholder="Theatre Name" />
            </Form.Group>
          </Row>
          
          <Row className="mb-3">
            <Form.Group as={Col} controlId="theatreCity">
              <Form.Control type="text" placeholder="Theatre City" />
            </Form.Group>
          </Row>
         <Row>
            <Form.Group className="mb-3" controlId="theatreState">
              <Form.Control type="text" placeholder="Theatre State" />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="pincode">
              <Form.Control type="text" placeholder="Enter PinCode" />
            </Form.Group>
          </Row>
          <Row className="mb-3">
            <Form.Group as={Col} controlId="number">
              <Form.Control placeholder="Manager Contact Number" />
            </Form.Group>
          </Row>
          <Button
            className="buttonalign"
            variant="btn btn-secondary"
            type="submit"
          >
            Add Theatre
          </Button>
        </Form>
      </div>
    </div>
    <Footer></Footer>
</div>
);
}
export default AddTheatre;