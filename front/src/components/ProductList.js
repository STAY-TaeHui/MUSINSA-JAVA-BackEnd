import React from "react";
import { styled } from "@mui/material/styles";
import { Box } from "@mui/material";
import ProductItem from "./ProductItem";

const StyledBox = styled(Box)(() => ({
  width: "100%",
  height: "100px",
  backgroundColor: "#efefef",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const ProductList = ({ dataList, fixedWidth }) => {
  return (
    <Box
      display="flex"
      alignItems="center"
      flexDirection="row"
      flexWrap="wrap"
      width="100%"
      gap={2}
    >
      {dataList?.map((data, index) => {
        return (
          <ProductItem
            key={`product_${index}`}
            brandName={data.brandName}
            categoryName={data.categoryName}
            price={data.price}
            fixedWidth={fixedWidth}
          />
        );
      })}
    </Box>
  );
};

export default ProductList;
