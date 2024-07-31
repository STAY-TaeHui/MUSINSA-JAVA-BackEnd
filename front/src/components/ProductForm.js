import React from "react";
import {Box, FormControl, InputLabel, MenuItem, Paper, Select, Typography} from "@mui/material";
import TextField from "@mui/material/TextField";

const ProductForm = ({product, brands, categories, onChange}) => {
    const handleChange = (e) => {
        const { name, value } = e.target;
        onChange(name, value);
    };

  return (
    <Box display="flex" flexDirection="column" p={1} gap={2}>
      <TextField name="price" value={product.price} label="제품가격" variant="outlined" onChange={handleChange}/>
      {brands &&
        <FormControl>
          <InputLabel>브랜드</InputLabel>
          <Select name="brandId" value={product?.brand?.id} label="브랜드" onChange={handleChange}>
            {brands?.map((brand) => <MenuItem key={brand.id} value={brand.id}>{brand.name}</MenuItem>)}
          </Select>
        </FormControl>
      }
      {categories &&
        <FormControl>
          <InputLabel >카테고리</InputLabel>
          <Select name="categoryId" value={product?.category?.id} label="카테고리" onChange={handleChange}>
            {categories?.map((category) => <MenuItem key={category.id} value={category.id}>{category.name}</MenuItem>)}
          </Select>
        </FormControl>
      }
    </Box>
  );
};

export default ProductForm;
