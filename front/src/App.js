import './App.css';
import MainPage from './pages/MainPage';
import CategoryPage from './pages/CategoryPage';
import CheapestProductPage from './pages/CheapestProductPage';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import {createTheme, ThemeProvider} from '@mui/material/styles';

const theme = createTheme({
  typography: {
    fontFamily: [
      'Noto Sans KR',
      'Roboto',
      '"Helvetica Neue"',
      'Arial',
      'sans-serif'
    ].join(','),
  }
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={<MainPage />} />
          <Route path="/category" element={<CategoryPage />} />
          <Route path="/cheapest" element={<CheapestProductPage />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
