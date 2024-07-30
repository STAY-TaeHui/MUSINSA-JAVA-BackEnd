import React from "react";
import { styled } from "@mui/material/styles";
import { Box, Paper, Typography } from "@mui/material";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import { formatPriceToKRW } from "../utils/priceUtils";

const StyledBox = styled(Box)(() => ({
  width: "100%",
  height: "100px",
  backgroundColor: "#efefef",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const ProductItem = ({ brandName, categoryName, price, fixedWidth }) => {
  return (
    <Paper
      elevation={0}
      sx={fixedWidth ? { width: 160 } : { minWidth: 160, flexGrow: 1 }}
    >
      <StyledBox>
        <AddShoppingCartIcon color="disabled" fontSize="large" />
      </StyledBox>
      <Box p={1}>
        <Typography fontSize="13px" fontWeight="bold">
          brand {brandName}
        </Typography>
        <Typography fontSize="13px">{categoryName}</Typography>
        <Typography fontSize="13px" fontWeight="bold">
          {formatPriceToKRW(price)}원
        </Typography>
      </Box>
    </Paper>
  );
};

export default ProductItem;
