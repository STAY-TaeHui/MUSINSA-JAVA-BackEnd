import React, { useState } from "react";
import { Box, Typography, Button} from "@mui/material";
import Layout from "../components/Layout";
import ProductItem from "../components/ProductItem";
import {styled} from "@mui/material/styles";
import useSWR from "swr";
import fetcher from "../utils/fetcher";
import axios from "axios";

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
  const { data: categories } = useSWR("/api/categories", fetcher);
  const [selectedCategory, setSelectedCategory] = useState("");
  const [lowestProduct, setLowestProduct] = useState({brandName: '', price: 0});
  const [highestProduct, setHighestProduct] = useState({brandName: '', price: 0});

  const handleClick = (categoryName) => {
    setSelectedCategory(categoryName);

    axios
      .get(
        `api/reports/categories/lowest-and-highest-price?category-name=${categoryName}`,
        {
          withCredentials: true,
        }
      )
      .then((result) => {
        setLowestProduct(result.data.data.lowestPrice[0]);
        setHighestProduct(result.data.data.highestPrice[0]);
      })
      .catch((err) => {
        console.log(err);
      });
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
        <Typography>카테고리별 가성비와 가심비💖</Typography>
        {categories &&
          <Box display="flex" gap={1} flexWrap={"wrap"}>
            {categories.map((category) => {
              return (
                <StyledButton
                    key={category.id}
                  variant="outlined"
                  size="small"
                  style={{
                    backgroundColor:
                    category.name === selectedCategory ? "#000" : "transparent",
                    color: category.name === selectedCategory ? "#fff" : "inherit",
                  }}
                  onClick={() => handleClick(category.name)}
                >
                  {category.name}
                </StyledButton>
              );
            })}
          </Box>
        }
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
              categoryName={selectedCategory.name}
              price={lowestProduct.price}
            />
            <ProductItem
              brandName={highestProduct.brandName}
              categoryName={selectedCategory.name}
              price={highestProduct.price}
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
