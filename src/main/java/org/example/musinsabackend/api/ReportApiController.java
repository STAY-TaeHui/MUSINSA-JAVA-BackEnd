package org.example.musinsabackend.api;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.LowestBrandInfoDto;
import org.example.musinsabackend.api.response.ApiResponse;
import org.example.musinsabackend.api.response.CategoryBrandPriceResponse;
import org.example.musinsabackend.api.response.ProductInfoWithBrandApiResponse;
import org.example.musinsabackend.service.ReportApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportApiController
{
    private final ReportApiService reportApiService;

    /*
    * 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
    * */
    @GetMapping("/categories/lowest-price")
    public ResponseEntity<ApiResponse> lowestPriceProductByCategory()
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            CategoryBrandPriceResponse response = reportApiService.lowestPriceProductByCategory();
            apiResponse.setData(response);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
        catch (Exception e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.internalServerError().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }

    /*
    * 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
    * */
    @GetMapping("/brands/lowest-price")
    public ResponseEntity<ApiResponse> getLowestBrandProductInfoDto()
    {
        ApiResponse apiResponse = new ApiResponse();

        try
        {
            LowestBrandInfoDto response = reportApiService.getLowestPriceBrand();
            apiResponse.setData(response);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
        catch (Exception e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.internalServerError().body(apiResponse);

        }

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/categories/lowest-and-highest-price")
    public ResponseEntity<ApiResponse> getLowestAndHighestPriceProductByCategoryName(@RequestParam(name = "category-name") final String categoryName)
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            ProductInfoWithBrandApiResponse response = reportApiService.LowestAndHighestPriceProductByCategoryName(categoryName);
            apiResponse.setData(response);
            apiResponse.setMessage("Success");
        }
        catch (IllegalArgumentException e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
        catch (Exception e)
        {
            apiResponse.setMessage("Error : " + e.getMessage());
            return ResponseEntity.internalServerError().body(apiResponse);
        }

        return ResponseEntity.ok(apiResponse);
    }
}
