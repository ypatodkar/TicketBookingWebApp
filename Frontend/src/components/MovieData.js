import { Typography } from "@material-ui/core";
import FavoriteIcon from "@mui/icons-material/Favorite";
import { red } from "@mui/material/colors";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

const MovieData = (props) => {
  const navigate = useNavigate();
  return (
    <div>
      <Typography className="movie-data-font" variant="h4">
        {props.title}
      </Typography>
      <Typography className="movie-data-font">
        {props.language} | {props.rated}
      </Typography>
      <br></br>
      <Typography className="movie-data-font" variant="h6">
        <FavoriteIcon fontSize="large" sx={{ color: red[500] }} />
        &emsp;
        {props.rating.length !== 0 ? "IMDB " + props.rating[0].Value : ""}
      </Typography>
      <br></br>
      <Typography className="movie-data-font">
        Actors: {props.actors}
      </Typography>
      <Typography className="movie-data-font">
        Director: {props.director}
      </Typography>
      <br></br>
      <Typography variant="h6" className="movie-data-font">
        Plot
      </Typography>
      <Typography variant="inherit" className="movie-data-font">
        {props.plot}
      </Typography>
      <br></br>
      <Button
        sx={{ mt: 5 }}
        onClick={() => navigate(`/BookTicket`)}
        variant="contained"
      >
        Contained
      </Button>
    </div>
  );
};

export default MovieData;
