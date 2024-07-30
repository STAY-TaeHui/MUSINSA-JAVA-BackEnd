import React from 'react';
import {styled} from '@mui/material/styles';
import {Box, Paper, Typography} from '@mui/material';

const StyledBox = styled(Box)(() => ({
  width: '100%',
  height: '100px',
  backgroundColor: '#efefef'
}));

const ProductList = ({dataList}) => {

  return (
      <Box
        display="flex"
        alignItems="center"
        justifyContent="center"
        flexDirection="row"
        width="100%"
        gap={4}
      >
        {dataList.map((data) => {
            return (
              <Paper sx={{flexGrow: 1}}>
                <StyledBox></StyledBox>
                <Typography>{data.brand}</Typography>
                <Typography>{data.price}</Typography>
              </Paper>
            )
        })}
      </Box>
  );
};

export default ProductList;