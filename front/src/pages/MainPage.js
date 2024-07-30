import React from "react";
import { useNavigate } from "react-router-dom";
import { styled } from "@mui/material/styles";
import { Button, Box } from "@mui/material";
import Layout from "../components/Layout";

const StyledButton = styled(Button)(() => ({
  width: 200,
  height: 50,
  border: "1px solid #000",
  backgroundColor: "#fff",
  fontWeight: 600,
  color: "#000",
  "&:hover": {
    color: "#fff",
    backgroundColor: "#000",
    border: "1px solid #000",
  },
}));

const MainPage = () => {
  const navigate = useNavigate();

  const handleCategoryLowestClick = () => {
    navigate("/category/lowest");
  };

  const handleBrandLowestClick = () => {
    navigate("/brand/lowest");
  };

  const handleCategoryHighLowClick = () => {
    navigate("/category");
  };

  const handleAdminClick = () => {
    navigate("/admin");
  };

  return (
    <Layout>
      <img
        src={`${process.env.PUBLIC_URL}/main.jpg`}
        alt="Example"
        style={{ width: "100%", height: "500px" }}
      />
      <Box
        display="flex"
        alignItems="center"
        justifyContent="center"
        flexDirection="column"
        gap={4}
        p={5}
      >
        <StyledButton variant="outlined" onClick={handleCategoryLowestClick}>
          카테고리 특가
        </StyledButton>
        <StyledButton variant="outlined" onClick={handleBrandLowestClick}>
          최저가로 구매하기
        </StyledButton>
        <StyledButton variant="outlined" onClick={handleCategoryHighLowClick}>
          가성비 & 가심비
        </StyledButton>
        <StyledButton variant="outlined" onClick={handleAdminClick}>
          어드민
        </StyledButton>
      </Box>
    </Layout>
  );
};

export default MainPage;
