import Footer from "./Footer";
import ImageSlider from "./ImageSlider";
import NowShowing from "./NowShowing";
import Grid from "@mui/material/Grid";
import { Box } from "@mui/system";
import { Typography } from "@mui/material";
import Header from "./Header";

const Home = () => {
  return (
    <div>
      <Header />
      <ImageSlider />
      <Box>
        <Grid sx={{ pl: 17, pt: 10, pb: 5 }} container spacing={1}>
          <div>
            <Typography variant="h4" component="h2">
              NOW SHOWING
              <hr className="horizontal"></hr>
            </Typography>
            <NowShowing />
          </div>
          {/* <Grid item xs>
            
          </Grid> */}
        </Grid>
      </Box>
      <Footer />
    </div>
  );
};

export default Home;
