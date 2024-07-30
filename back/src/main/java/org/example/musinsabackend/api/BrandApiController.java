package org.example.musinsabackend.api;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.response.ApiResponse;
import org.example.musinsabackend.domain.dto.CreateBrandDto;
import org.example.musinsabackend.domain.dto.UpdateBrandDto;
import org.example.musinsabackend.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
