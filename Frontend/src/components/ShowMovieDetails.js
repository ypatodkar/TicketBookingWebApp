import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Header from "./Header";
import MediaCard from "./MediaCard";
import axios from "axios";
import { Grid } from "@material-ui/core";
import MovieData from "./MovieData";
import Loader from "./Loader";
import ShowDates from "./ShowDates";

const ShowMovieDetails = () => {
  let { name, id } = useParams();
  const [loading, setLoading] = useState(true);
  const [detail, setDetail] = useState([]);

  const getMovieDetails = () => {
    axios
      .get(`http://www.omdbapi.com?apikey=62d2fd02&i=${id}`)
      .then((response) => {
        setDetail(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    getMovieDetails();
  }, []);

  if (loading) {
    return <Loader />;
  }
  console.log(detail);
  const background = {
    backgroundImage:
      "linear-gradient(to bottom, rgba(0,0,0,0.8) 10%,rgba(0,0,0,0.6) 100%),url('" +
      detail.Poster +
      "')",
    backgroundPosition: "50% 15%",
  };
  //movie details page where a singular movie details are visible. This page would contain all the movie details and a button
  //to book tickets
  return (
    <>
      <Header />
      <div style={background} className="movie-poster-details">
        <Grid container spacing={2} columns={16}>
          <Grid item xs={2}>
            <MediaCard imageUrl={detail.Poster} name={name} />
          </Grid>
          <Grid item xs={4}>
            <MovieData
              rating={detail.Ratings}
              title={detail.Title}
              about={detail.Plot}
              actors={detail.Actors}
              director={detail.Director}
              language={detail.Language}
              rated={detail.Rated}
              plot={detail.Plot}
            />
          </Grid>
        </Grid>
      </div>
      <div className="date-show my-4 ">
        <ShowDates />
      </div>
    </>
  );
};

export default ShowMovieDetails;
