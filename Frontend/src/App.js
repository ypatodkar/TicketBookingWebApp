import Home from "./components/Home";
import { Routes, Route } from "react-router-dom";
import ShowMovieDetails from "./components/ShowMovieDetails";
import LoginForm from "./components/LoginForm";
import Register from "./components/Register";
import BookTicket from "./components/BookTicket";
import AddTheatre from "./components/AdminComponents/AddTheatre";
import AdminHomePage from "./components/AdminComponents/AdminHomePage";
import "./register.css";
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route
          path="/showMovie/movie/:name/:id"
          element={<ShowMovieDetails />}
        />
        <Route path="/SignIn" element={<LoginForm />} />
        <Route path="/Register" element={<Register />} />
        <Route path="/Admin/AddTheatre" element={<AddTheatre />} />
        <Route path="/Admin/HomePage" element={<AdminHomePage />} />
        /Admin/HomePage
        <Route path="/BookTicket" element={<BookTicket />} />
      </Routes>
    </div>
  );
}

export default App;
