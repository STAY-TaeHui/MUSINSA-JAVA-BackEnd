import React from 'react';
import {Box, Button, Typography} from '@mui/material';
import Layout from '../components/Layout';
import ProductList from '../components/ProductList';
import {styled} from '@mui/material/styles';

const mock =  {
  data: [
    {
      category: '상의',
      brand: 'C',
      price: 10000
    },
    {
      category: '아우터',
      brand: 'E',
      price: 5000
    },
    {
      category: '바지',
      brand: 'D',
      price: 3000
    },
  ],
  total: 34100
};

const StyledButton = styled(Button)(() => ({
  border: '1px solid #000',
  fontWeight: 600,
  color: '#000',
  '&:hover': {
    color: '#fff',
    backgroundColor: '#000',
    border: '1px solid #000',
  },
}));

const CategoryPage = () => {

  const categories = mock.data.map(item => item.category);

  return (
    <Layout>
      <Box
        display="flex"
        justifyContent="center"
        flexDirection="column"
        gap={2}
        p={2}
      >
        <Typography>카테고리별로 최저상품 표시</Typography>
        <Box
          display="flex"
          gap={1}
        >
        {categories.map((category) => {
          return (
            <StyledButton variant="outlined" size="small">{category}</StyledButton>
          )
        })}
        </Box>
        <ProductList dataList={mock.data} />
      </Box>
    </Layout>
  );
};

export default CategoryPage;