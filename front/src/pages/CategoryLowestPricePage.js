import React, {useEffect, useState} from "react";
import { Box, Typography } from "@mui/material";
import Layout from "../components/Layout";
import ProductList from "../components/ProductList";
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
      // {
      //   categoryName: "바지",
      //   brandName: "D",
      //   price: 3000,
      // },
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

const CategoryLowestPricePage = () => {
  // const { data } = useSWR("/api/reports/categories/lowest-price", fetcher);
  //
  // console.log(data);

  // const categories = data ? data.productInfos.map((item) => item.categoryName) : [];
  const [ dataList, setDataList ] = useState([]);
  const categories = [];

  useEffect(() => {
    axios.get("/api/reports/categories/lowest-price").then((response) => {
      console.log(response);
    });
  }, []);

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
        <Box display="flex" gap={1}>
          {categories.map((categoryName) => {
            return (
              <StyledButton variant="outlined" size="small">
                {categoryName}
              </StyledButton>
            );
          })}
        </Box>
        <ProductList dataList={dataList || []} />
      </Box>
    </Layout>
  );
};

export default CategoryLowestPricePage;
