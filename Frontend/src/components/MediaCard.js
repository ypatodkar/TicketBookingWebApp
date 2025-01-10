import * as React from "react";
import Card from "@mui/material/Card";
import CardMedia from "@mui/material/CardMedia";

const MediaCard = (props) => {
  const shadow = {
    borderShadow: "50px 50px 50px 50px black",
  };

  return (
    <Card className="now-showing-card" raised="true" style={shadow} sx={{ maxWidth: 250 }}>
      <CardMedia
        component="img"
        style={{ width: "100%", height: "50%" }}
        image={props.imageUrl}
        alt="movie"
      />
    </Card>
  );
};

export default MediaCard;
