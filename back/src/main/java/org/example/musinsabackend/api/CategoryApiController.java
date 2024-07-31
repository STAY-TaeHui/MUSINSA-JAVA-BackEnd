package org.example.musinsabackend.api;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.response.ApiResponse;
import org.example.musinsabackend.domain.dto.CategoryDto;
import org.example.musinsabackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryApiController
{
    @Autowired
    private final CategoryService categoryService;

    /*
    * 모든 카테고리를 조회하는 API
    * */
    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategories()
    {
        ApiResponse apiResponse = new ApiResponse();
        try
        {
            List<CategoryDto> categories = categoryService.findAll();
            apiResponse.setData(categories);
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
