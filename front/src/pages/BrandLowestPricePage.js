import React from "react";
import { Box, Typography } from "@mui/material";
import Layout from "../components/Layout";
import ProductList from "../components/ProductList";
import useSWR from "swr";
import fetcher from "../utils/fetcher";
import { formatPriceToKRW } from "../utils/priceUtils";

const BrandLowestPricePage = () => {
  const { data, isLoading } = useSWR("/api/reports/brands/lowest-price", fetcher);

  return (
    <Layout>
      {!isLoading &&
        <Box display="flex" flexDirection="column" gap={2} p={2}>
          <Typography display="flex">
            <Typography fontWeight="bold">{data.brandName}</Typography>로
            최저가 코디 완성하기✨
          </Typography>
          <Typography>총액 {formatPriceToKRW(data.totalPrice)}원</Typography>
          <ProductList dataList={data.productInfos} fixedWidth={true} />
        </Box>
      }
    </Layout>
  );
};

export default BrandLowestPricePage;
