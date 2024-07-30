package org.example.musinsabackend.api;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.response.ApiResponse;
import org.example.musinsabackend.domain.dto.CreateProductDto;
import org.example.musinsabackend.domain.dto.ProductDto;
import org.example.musinsabackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductApiController
{
    private final ProductService productService;

    /*
    * 전체 상품 조회 API
    * */
    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts()
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            List<ProductDto> products = productService.findAll();
            apiResponse.setData(products);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }

    /*
    * 특정 상품  조회 API
    * */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getProduct(@PathVariable Long id)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            ProductDto product = productService.findOne(id);
            apiResponse.setData(product);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody CreateProductDto dto)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            Long createdProductId = productService.createProduct(dto);

            apiResponse.setData(createdProductId);
            apiResponse.setMessage("Success");

        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);

        }

        return ResponseEntity.ok(apiResponse);
    }

    /*
    * Product 삭제 API
    * */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            Long deletedProductId = productService.deleteProduct(id);

            apiResponse.setMessage(deletedProductId + " Product Deleted Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }

    /*
    * Product 수정 API
    * */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestBody CreateProductDto dto)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            Long updatedProductId = productService.updateProduct(id, dto);

            apiResponse.setData(updatedProductId);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }
}
