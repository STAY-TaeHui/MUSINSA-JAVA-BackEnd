import React from 'react';
import {Box} from '@mui/material';
import Layout from '../components/Layout';

const AdminPage = () => {

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
        브랜드 및 상품을 추가 / 업데이트 / 삭제
      </Box>
    </Layout>
  );
};

export default AdminPage;