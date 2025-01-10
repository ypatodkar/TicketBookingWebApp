import Checkbox from "@mui/material/Checkbox";
import SquareOutlinedIcon from "@mui/icons-material/SquareOutlined";
import SquareIcon from "@mui/icons-material/Square";

const Seats = (props) => {
  const seats = [];
  let seatRow = 65;
  const alphabets = [];

  for (let i = 0; i < props.rows; i++) {
    alphabets.push(String.fromCharCode(seatRow + i));
  }

  for (let i = 0; i < props.cols; i++) {
    seats.push(
      <Checkbox
        className="svg_icons mx-2"
        icon={<SquareOutlinedIcon />}
        checkedIcon={<SquareIcon />}
      />
    );
  }

  return (
    <table className="seat-table">
      <tbody>
        {alphabets.map((alpha) => {
          return (
            <tr>
              <td>{alpha}</td>
              <td></td>
              <td style={{ textAlign: "center" }}>
                {seats.map((seat) => seat)}
              </td>
              <td></td>
              <td style={{ textAlign: "center" }}>
                {seats.map((seat) => seat)}
              </td>
            </tr>
          );
        })}
      </tbody>
    </table>
  );
};

export default Seats;
