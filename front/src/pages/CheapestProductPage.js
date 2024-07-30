import React from 'react';
import {Box} from '@mui/material';
import Layout from '../components/Layout';

const CheapestProductPage = () => {

  return (
    <Layout>
      <Box
        display="flex"
        alignItems="center"
        justifyContent="center"
        flexDirection="column"
        gap={4}
        p={5}
      >
        최저가로 코디를 완성할 수 있는 브랜드
      </Box>
    </Layout>
  );
};

export default CheapestProductPage;