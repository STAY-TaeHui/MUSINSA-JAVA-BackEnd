import "./App.css";
import MainPage from "./pages/MainPage";
import CategoryLowestPricePage from "./pages/CategoryLowestPricePage";
import BrandLowestPricePage from "./pages/BrandLowestPricePage";
import CategoryHighLowPricePage from "./pages/CategoryHighLowPricePage";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import AdminPage from "./pages/AdminPage";

const theme = createTheme({
  typography: {
    fontFamily: [
      "Noto Sans KR",
      "Roboto",
      '"Helvetica Neue"',
      "Arial",
      "sans-serif",
    ].join(","),
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<MainPage />} />
          <Route
            path="/category/lowest"
            element={<CategoryLowestPricePage />}
          />
          <Route path="/brand/lowest" element={<BrandLowestPricePage />} />
          <Route path="/category" element={<CategoryHighLowPricePage />} />
          <Route path="/admin" element={<AdminPage />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
