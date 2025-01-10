import React from "react";
import SliderMovieData from "./SliderMovieData";
import Carousel from "react-bootstrap/Carousel";

const ImageSlider = () => {
  return (
    <Carousel pause="hover">
      {SliderMovieData.map((movie) => {
        return (
          <Carousel.Item>
            <img
              className="d-block w-100 image"
              style={{ height: "650px" }}
              src={movie.image}
              alt="movie"
            />
          </Carousel.Item>
        );
      })}
    </Carousel>
  );
};

export default ImageSlider;
