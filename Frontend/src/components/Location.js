import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import { useState } from "react";

const cities = ["Pune", "Mumbai", "Bangalore", "Chennai", "Kolkata"];

const Location = () => {
  const [location, setLocation] = useState("");

  const handleChange = (event) => {
    setLocation(event.target.value);
  };
  return (
    <Box sx={{ width: 20 }}>
      <FormControl style={{ width: 150 }} size="medium">
        <InputLabel id="demo-simple-select-label">Location</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={location}
          label="Location"
          onChange={handleChange}
        >
          {cities.map((city) => (
            <MenuItem value={city}>{city}</MenuItem>
          ))}
        </Select>
      </FormControl>
    </Box>
  );
};
export default Location;
