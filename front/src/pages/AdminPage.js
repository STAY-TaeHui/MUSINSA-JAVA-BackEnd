import React, { useState } from "react";
import {Box, Button, IconButton, ListItem, ListItemText, Typography} from "@mui/material";
import { styled } from "@mui/material/styles";
import Layout from "../components/Layout";
import List from "@mui/material/List";
import FormDialog from "../components/FormDialog";
import BrandForm from "../components/BrandForm";
import ProductForm from "../components/ProductForm";
import useSWR from "swr";
import fetcher from "../utils/fetcher";
import axios from "axios";
import DeleteIcon from '@mui/icons-material/Delete';

const StyledListItem = styled(ListItem)(() => ({
  border: "1px solid #efefef",
  '& .MuiListItemText-root': {
    width: 30,
  },
  '&:hover': {
    backgroundColor: '#efefef',
    cursor: 'pointer'
  }
}));

const AdminPage = () => {
  const { data: brands, mutate: mutateBrand } = useSWR("/api/brands", fetcher);
  const { data: products, mutate: mutateProduct  } = useSWR("/api/products", fetcher);
  const { data: categories } = useSWR("/api/categories", fetcher);
  const [brandDialogOpen, setBrandDialogOpen] = useState(false);
  const [productDialogOpen, setProductDialogOpen] = useState(false);
  const [brand, setBrand] = useState({id: 0, name: ''});
  const [product, setProduct] = useState({id: 0, price: 0});

  const handleAddBrandClick = () => {
    setBrandDialogOpen(true);
  };

  const handleCloseBrandDialog = () => {
    setBrandDialogOpen(false);
    setBrand({id: 0, name: ''});
  };

  const handleAddProductClick = () => {
    setProductDialogOpen(true);
  };

  const handleCloseProductDialog = () => {
    setProductDialogOpen(false);
    setProduct({id: 0, price: 0});
  };

  const handleBrandConfirmClick = () => {
    if(brand.name.length === 0)
    {
      return;
    }

    if(brand.id !== 0)
    {
      axios.put(`/api/brands/${brand.id}`,{brandName: brand.name}, {
        withCredentials: true,
      })
      .then((result) => {
        setBrandDialogOpen(false);
        mutateBrand();
      })
      .catch((err) => {
        console.log(err);
      });
    } else {
      axios.post('/api/brands', {brandName: brand.name}, {
        withCredentials: true,
      })
      .then((result) => {
        setBrandDialogOpen(false);
        mutateBrand();
      })
      .catch((err) => {
        console.log(err);
      });
    }
  };

  const handleProductConfirmClick = () => {
    if(product.price === 0)
    {
      return;
    }

    if(product.id !== 0)
    {
      axios.put(`/api/products/${product.id}`,{brandId: product.brand.id, categoryId: product.category.id, price: product.price}, {
        withCredentials: true,
      })
      .then((result) => {
        setProductDialogOpen(false);
        mutateProduct();
      })
      .catch((err) => {
        console.log(err);
      });
    } else {
      axios.post('/api/products', {brandId: product.brand.id, categoryId: product.category.id, price: product.price}, {
        withCredentials: true,
      })
      .then((result) => {
        setProductDialogOpen(false);
        mutateProduct();
      })
      .catch((err) => {
        console.log(err);
      });
    }
  };

  const handleDeleteBrandClick = (id) => {
    axios.delete(`/api/brands/${id}`, {
      withCredentials: true,
    })
    .then((result) => {
      mutateBrand();
    })
    .catch((err) => {
      console.log(err);
    });
  };

  const handleDeleteProductClick = (id) => {
    axios.delete(`/api/products/${id}`, {
      withCredentials: true,
    })
    .then((result) => {
      mutateProduct();
    })
    .catch((err) => {
      console.log(err);
    });
  };

  const handleBrandClick = (brand) => {
    setBrandDialogOpen(true);
    setBrand(brand);
  };

  const handleProductClick = (product) => {
    setProductDialogOpen(true);
    setProduct(product);
  };

  const handleBrandChange = (name, value) => {
    setBrand({ ...brand, [name]: value });
  };

  const handleProductChange = (name, value) => {
    if(name === 'brandId') {
      setProduct({ ...product, brand: { id: value }});
    }
    else if(name === 'categoryId') {
      setProduct({ ...product, category: { id: value }});
    }
    else {
      setProduct({ ...product, [name]: value });
    }
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
        <Typography>어드민 ⚙️</Typography>
        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Typography fontWeight="bold">브랜드 목록</Typography>
          <Button onClick={handleAddBrandClick}>추가</Button>
        </Box>
        <List>
          {brands?.map((brand) => (
            <StyledListItem
              key={brand.id}
              secondaryAction={
                <IconButton edge="end" aria-label="delete" onClick={(e) => {
                  e.stopPropagation();
                  handleDeleteBrandClick(brand.id)
                }}>
                  <DeleteIcon />
                </IconButton>
              }
              onClick={() => handleBrandClick(brand)}
            >
              {brand.name}
            </StyledListItem>
          ))}
        </List>
        <Box display="flex" alignItems="center" justifyContent="space-between">
          <Typography fontWeight="bold">상품 목록</Typography>
          <Button onClick={handleAddProductClick}>추가</Button>
        </Box>
        <List>
          <StyledListItem>
            <ListItemText>ID</ListItemText>
            <ListItemText>브랜드</ListItemText>
            <ListItemText>카테고리</ListItemText>
            <ListItemText>가격</ListItemText>
          </StyledListItem>
          {products?.map((product) => (
            <StyledListItem
              key={product.id}
              secondaryAction={
                <IconButton edge="end" aria-label="delete" onClick={(e) => {
                  e.stopPropagation();
                  handleDeleteProductClick(product.id)
                }}>
                  <DeleteIcon />
                </IconButton>
              }
              onClick={() => handleProductClick(product)}
            >
              <ListItemText>{product.id}</ListItemText>
              <ListItemText>{product.brand.name}</ListItemText>
              <ListItemText>{product.category.name}</ListItemText>
              <ListItemText>{product.price}</ListItemText>
            </StyledListItem>
          ))}
        </List>
        <FormDialog
          open={brandDialogOpen}
          title="브랜드 추가/수정"
          onConfirmClick={handleBrandConfirmClick}
          onClose={handleCloseBrandDialog}
        >
          <BrandForm brand={brand} onChange={handleBrandChange}/>
        </FormDialog>
        <FormDialog
          open={productDialogOpen}
          title="상품 추가/수정"
          onConfirmClick={handleProductConfirmClick}
          onClose={handleCloseProductDialog}
        >
          <ProductForm product={product} brands={brands} categories={categories} onChange={handleProductChange}/>
        </FormDialog>
      </Box>
    </Layout>
  );
};

export default AdminPage;
