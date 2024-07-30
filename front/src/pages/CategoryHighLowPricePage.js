import React, { useState } from "react";
import { Box, Typography } from "@mui/material";
import Layout from "../components/Layout";
import ProductItem from "../components/ProductItem";
import { styled } from "@mui/material/styles";
import { Button } from "@mui/material";
import useSWR from "swr";
import fetcher from "../utils/fetcher";
import axios from "axios";

const mock = {
  data: {
    productInfos: [
      {
        categoryName: "상의",
        brandName: "C",
        price: 10000,
      },
      {
        categoryName: "아우터",
        brandName: "E",
        price: 5000,
      },
    ],
    totalPrice: 34100,
  },
};

const StyledButton = styled(Button)(() => ({
  border: "1px solid #000",
  fontWeight: 600,
  color: "#000",
  "&:hover": {
    color: "#fff",
    backgroundColor: "#000",
    border: "1px solid #000",
  },
}));

const CategoryHighLowPricePage = () => {
  // const { data: categories } = useSWR("/api/reports/categories", fetcher);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [lowestProduct, setLowestProduct] = useState({});
  const [hightestProduct, setHighestProduct] = useState({});

  const categories = mock.data.productInfos.map((item) => item.categoryName);

  const handleClick = (categoryName) => {
    setSelectedCategory(categoryName);

    try {
      axios
        .get(
          `api/reports/categories/lowest-and-highest-price?category-name=${categoryName}`,
          {
            withCredentials: true,
          }
        )
        .then((result) => {
          setLowestProduct(result.data.lowestPrice);
          setHighestProduct(result.data.highestPrice);
        })
        .catch((err) => {
          console.log(err);
        });
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <Layout>
      <Box
        display="flex"
        justifyContent="center"
        flexDirection="column"
        gap={2}
        p={2}
      >
        <Typography>카테고리별 가성비와 가심비</Typography>
        <Box display="flex" gap={1}>
          {categories.map((categoryName) => {
            return (
              <StyledButton
                variant={"outlined"}
                size="small"
                style={{
                  backgroundColor:
                    categoryName === selectedCategory ? "#000" : "transparent",
                  color: categoryName === selectedCategory ? "#fff" : "inherit",
                }}
                onClick={() => handleClick(categoryName)}
              >
                {categoryName}
              </StyledButton>
            );
          })}
        </Box>
        {selectedCategory ? (
          <Box
            display="flex"
            alignItems="center"
            flexDirection="row"
            flexWrap="wrap"
            width="100%"
            gap={2}
          >
            <ProductItem
              brandName={lowestProduct.brandName}
              categoryName={lowestProduct.categoryName}
              price={lowestProduct.price}
            />
            <ProductItem
              brandName={hightestProduct.brandName}
              categoryName={hightestProduct.categoryName}
              price={hightestProduct.price}
            />
          </Box>
        ) : (
          <Box
            display="flex"
            alignItems="center"
            justifyContent="center"
            width="100%"
          >
            <Typography>카테고리를 선택해주세요.</Typography>
          </Box>
        )}
      </Box>
    </Layout>
  );
};

export default CategoryHighLowPricePage;
