import { Container, Grid, Box, Link } from "@material-ui/core";
import "../App.css";

const Footer = () => {
  return (
    <footer style={{ postition: "absolute", left: 0, right: 0, bottom: 0 }}>
      <Box
        px={{ xs: 2, sm: 8 }}
        py={{ sx: 2, sm: 8 }}
        style={{ backgroundColor: "#0f0f0f" }}
        color="white"
      >
        <Container maxWidth="lg">
          <Grid container spacing={5}>
            <Grid item xs={12} sm={4}>
              <Box borderBottom={1}>Our Company</Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Our Story
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Our Brand
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  FAQs
                </Link>
              </Box>
            </Grid>
            <Grid item xs={12} sm={4}>
              <Box borderBottom={1}>Our Services</Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Special Screenings
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Ticket Vouchers
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Advertise With Us
                </Link>
              </Box>
            </Grid>
            <Grid item xs={12} sm={4}>
              <Box borderBottom={1}>Help</Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Contact
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Support
                </Link>
              </Box>
              <Box>
                <Link
                  underline="none"
                  className="footer-col"
                  href="/"
                  color="inherit"
                >
                  Privacy
                </Link>
              </Box>
            </Grid>
          </Grid>
          <Box textAlign="center" pt={{ xs: 5, sm: 10 }} pb={{ xs: 5, sm: 0 }}>
            Book It! &reg; {new Date().getFullYear()}
          </Box>
        </Container>
      </Box>
    </footer>
  );
};

export default Footer;
