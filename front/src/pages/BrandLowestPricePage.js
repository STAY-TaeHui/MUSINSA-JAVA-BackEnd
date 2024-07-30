import React from "react";
import { Box, Typography } from "@mui/material";
import Layout from "../components/Layout";
import ProductList from "../components/ProductList";
import useSWR from "swr";
import fetcher from "../utils/fetcher";
import { formatPriceToKRW } from "../utils/priceUtils";

const mock = {
  data: {
    brandName: "D",
    totalPrice: 36100,
    productInfos: [
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "하의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "아우터",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "바지",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
      {
        brandName: "C",
        price: 10000,
        categoryName: "상의",
      },
    ],
  },
};

const BrandLowestPricePage = () => {
  // const { data } = useSWR("/api/reports/brands/lowest-price", fetcher);

  return (
    <Layout>
      <Box display="flex" flexDirection="column" gap={2} p={2}>
        <Typography display="flex">
          <Typography fontWeight="bold">{mock.data.brandName}</Typography>로
          최저가 코디 완성하기✨
        </Typography>
        <Typography>{formatPriceToKRW(mock.data.totalPrice)}원</Typography>
        <ProductList dataList={mock.data.productInfos} fixedWidth={true} />
      </Box>
    </Layout>
  );
};

export default BrandLowestPricePage;
