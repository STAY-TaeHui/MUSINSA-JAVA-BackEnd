import React, { useState } from "react";
import { Box, Button, Typography } from "@mui/material";
import { styled } from "@mui/material/styles";
import Layout from "../components/Layout";
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import FormDialog from "../components/FormDialog";
import BrandForm from "../components/BrandForm";
import ProductForm from "../components/ProductForm";

const brands = [
  { id: 1, name: "A" },
  { id: 2, name: "B" },
  { id: 3, name: "C" },
];

const products = [
  {
    id: 1,
    price: "10000",
    brand: { brandName: "A", id: 1 },
    category: {
      categoryName: "상의",
      id: 2,
    },
  },
];

const StyledListItem = styled(ListItemButton)(() => ({
  border: "1px solid #efefef",
}));

const AdminPage = () => {
  // const { data: brands } = useSWR("/api/brands", fetcher);
  // const { data: products } = useSWR("/api/products", fetcher);
  const [brandDialogOpen, setBrandDialogOpen] = useState(false);
  const [productDialogOpen, setProductDialogOpen] = useState(false);

  const handleAddBrandClick = () => {
    setBrandDialogOpen(true);
  };

  const handleCloseBrandDialog = () => {
    setBrandDialogOpen(false);
  };

  const handleAddProductClick = () => {
    setProductDialogOpen(true);
  };

  const handleCloseProductDialog = () => {
    setBrandDialogOpen(false);
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
        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Typography fontWeight="bold">브랜드 목록</Typography>
          <Button onClick={handleAddBrandClick}>추가</Button>
        </Box>
        <List>
          {brands.map((brand) => (
            <StyledListItem>{brand.name}</StyledListItem>
          ))}
        </List>
        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Typography fontWeight="bold">상품 목록</Typography>
          <Button onClick={handleAddProductClick}>추가</Button>
        </Box>
        <List>
          {products.map((product) => (
            <StyledListItem>{product.id}</StyledListItem>
          ))}
        </List>
        <FormDialog
          open={brandDialogOpen}
          title="브랜드 추가/수정"
          onClose={handleCloseBrandDialog}
        >
          <BrandForm />
        </FormDialog>
        <FormDialog
          open={productDialogOpen}
          title="상품 추가/수정"
          onClose={handleCloseProductDialog}
        >
          <ProductForm />
        </FormDialog>
      </Box>
    </Layout>
  );
};

export default AdminPage;
