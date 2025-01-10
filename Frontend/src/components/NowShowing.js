import SliderMovieData from "./SliderMovieData";
import { Typography } from "@mui/material";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardMedia from "@mui/material/CardMedia";
import Grid from "@mui/material/Grid";
import React from "react";
import { useNavigate } from "react-router-dom";

const NowShowing = () => {
  const navigate = useNavigate();

  return (
    <div>
      <Grid sx={{ ml: 0 }} container>
        {SliderMovieData.map((movie) => {
          return (
            <Grid item sx={{ pr: 10, pt: 2 }} xs={6} md={3}>
              <Card
                onClick={() =>
                  navigate(`/showMovie/movie/${movie.name}/${movie.imdbId}`)
                }
                raised="true"
                sx={{ maxWidth: 400 }}
              >
                <CardMedia
                  component="img"
                  height="240"
                  image={movie.image}
                  alt="movie"
                />
                <CardActions>
                  <Typography variant="string">{movie.name}</Typography>
                </CardActions>
              </Card>
            </Grid>
          );
        })}
      </Grid>
    </div>
  );
};

export default NowShowing;
