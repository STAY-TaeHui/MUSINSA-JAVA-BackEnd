import React from "react";
import { Box, Paper, Typography } from "@mui/material";
import TextField from "@mui/material/TextField";

const BrandForm = ({brand, onChange}) => {
    const handleChange = (e) => {
        const { name, value } = e.target;
        onChange(name, value);
    };

  return (
    <Box p={1}>
      <TextField name="name" value={brand.name} label="브랜드명" variant="outlined" onChange={handleChange}/>
    </Box>
  );
};

export default BrandForm;
