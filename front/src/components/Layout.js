import React from 'react';
import {styled} from '@mui/material/styles';
import {AppBar, Box, Container, Typography} from '@mui/material';

const StyledAppBar = styled(AppBar)(() => ({
  height: 50,
  backgroundColor: '#000'
}));

const Layout = ({children}) => {
  return (
    <Container maxWidth="sm">
      <Box sx={{border: '1px solid rgb(243, 243, 243)'}}>
        <StyledAppBar position="static">
          <Box
            display="flex"
            alignItems="center"
            textAlign="center"
            height="100%"
          >
            <Typography variant="h6" sx={{ flexGrow: 1 }}>
              TAESINSA
            </Typography>
          </Box>
        </StyledAppBar>
        {children}
      </Box>
    </Container>
  );
};

export default Layout;