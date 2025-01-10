import React from 'react';
import Footer from '../Footer';
import Header from './Header';
import Container from 'react-bootstrap/Container';
import {Col, Row } from "react-bootstrap";
import './homepage.css';
import MediaCard from '../MediaCard';
const AdminHomePage = () => {

    return (
        <div>
            <Header></Header>
            <Container className="mt-5 mb-5">
             <Row>
                 <h2 style={{textAlign:"left", color:"grey"}}>Hello Admin</h2>
                {/* <img
                 src='https://i.pinimg.com/564x/de/db/cc/dedbcca26d3974da11cf57edc8d0118b.jpg'
                 height={"50px"}
                 width={"500px"}
                 >
                </img> */}
            </Row> 
            <Row className="top mt-5 mb-5">
            <Col>
            <MediaCard imageUrl="https://i.pinimg.com/564x/f3/d4/9c/f3d49c8ebb83fd35e7cf24d62ccecc9c.jpg"></MediaCard>
            </Col>
            <Col><MediaCard imageUrl="https://i.pinimg.com/564x/6b/2d/fa/6b2dfa6d4e63137acfb76eeeacfdea0c.jpg"></MediaCard>
           </Col>
            <Col><MediaCard imageUrl="https://i.pinimg.com/564x/4c/63/fe/4c63fefd009c4dc25842148f35b8f9aa.jpg"></MediaCard></Col>
            </Row>
            </Container>
            <Footer></Footer>
        </div>
    );
}
export default AdminHomePage;