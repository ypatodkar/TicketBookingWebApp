import Container from "@mui/material/Container";
import { Typography } from "@material-ui/core";
import Seats from "./Seats";
import SquareIcon from "@mui/icons-material/Square";
import SquareOutlinedIcon from "@mui/icons-material/SquareOutlined";

const HallLayout = () => {
  return (
    <div>
      <div></div>
      <Container className="hall-layout" sx={{ mt: 2, p: 6 }}>
        <Typography className="seat-type" variant="h5" align="center">
          Diamond ₹500
        </Typography>
        <hr></hr>
        <div style={{ alignItems: "center" }}>
          <Seats rows={2} cols={7} />
        </div>
        <br></br>
        <br></br>
        <Typography className="seat-type" variant="h5" align="center">
          Gold ₹300
        </Typography>
        <hr></hr>
        <div style={{ alignItems: "center" }}>
          <Seats rows={5} cols={8} />
        </div>
        <br></br>
        <br></br>
        <Typography className="seat-type" variant="h5" align="center">
          Silver ₹150
        </Typography>
        <hr></hr>
        <div style={{ alignItems: "center" }}>
          <Seats rows={7} cols={8} />
        </div>
        <div className="screen my-5">Screen This Way</div>
        <div style={{ textAlign: "center" }}>
          <SquareOutlinedIcon /> Available &emsp;
          <SquareIcon sx={{ color: "#7C99AC" }} /> Taken
        </div>
      </Container>
    </div>
  );
};

export default HallLayout;
