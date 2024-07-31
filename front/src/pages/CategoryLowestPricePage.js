import React from "react";
import { Box, Typography, Button} from "@mui/material";
import Layout from "../components/Layout";
import ProductList from "../components/ProductList";
import {styled} from "@mui/material/styles";
import useSWR from "swr";
import fetcher from "../utils/fetcher";

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

const CategoryLowestPricePage = () => {
  const { data: categories } = useSWR("/api/categories", fetcher);
  const { data, isLoading } = useSWR("/api/reports/categories/lowest-price", fetcher);

  return (
    <Layout>
      <Box
        display="flex"
        justifyContent="center"
        flexDirection="column"
        gap={2}
        p={2}
      >
        <Typography>카테고리 특가🛍️</Typography>
        {categories &&
          <Box display="flex" gap={1} flexWrap={"wrap"}>
            {categories.map((category) => {
              return (
                <StyledButton key={category.id} variant="outlined" size="small">
                  {category.name}
                </StyledButton>
              );
            })}
          </Box>
        }
        <ProductList dataList={isLoading ? [] : data.productInfos} fixedWidth={true} />
      </Box>
    </Layout>
  );
};

export default CategoryLowestPricePage;
