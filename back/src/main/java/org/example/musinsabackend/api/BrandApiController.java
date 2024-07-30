package org.example.musinsabackend.api;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.response.ApiResponse;
import org.example.musinsabackend.domain.dto.CreateBrandDto;
import org.example.musinsabackend.domain.dto.UpdateBrandDto;
import org.example.musinsabackend.service.BrandDto;
import org.example.musinsabackend.service.BrandService;
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
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandApiController
{
    private final BrandService brandService;

    /*
    * 전체 브랜드 조회 API
    * */
    @GetMapping
    public ResponseEntity<ApiResponse> getAllBrands()
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            List<BrandDto> brands = brandService.getAllBrands();
            apiResponse.setData(brands);
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
    * 특정 브랜드 조회 API
    * */
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBrand(@PathVariable Long id)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            BrandDto brand = brandService.findOne(id);
            apiResponse.setData(brand);
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
    * 브랜드 추가 API
    * */
    @PostMapping
    public ResponseEntity<ApiResponse> createBrand(@RequestBody CreateBrandDto dto)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            Long createdBrandId = brandService.createBrand(dto);

            apiResponse.setData(createdBrandId);
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
    * 브랜드 삭제 API
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBrand(@PathVariable Long id)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            brandService.deleteBrand(id);

            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + "삭제할 수 없는 브랜드 입니다.");
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }

    /*
    * 브랜드 수정 API
    */
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateBrand(@PathVariable Long id, @RequestBody UpdateBrandDto dto)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            Long updatedBrandId = brandService.updateBrand(id, dto);
            apiResponse.setMessage(updatedBrandId+" Brand Updated Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }
}
