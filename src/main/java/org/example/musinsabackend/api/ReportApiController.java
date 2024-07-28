package org.example.musinsabackend.api;

import lombok.RequiredArgsConstructor;
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

    @GetMapping("/categories/lowest-price")
    public ResponseEntity<Integer> lowestPriceProductByCategory()
    {
        int i = reportApiService.lowestPriceProductByCategory();

        return null;
    }

    @GetMapping("/brands/lowest-price")
    public ResponseEntity<Integer> getLowestBrandProductInfoDto()
    {
        reportApiService.getLowestPriceBrand();

        return null;
    }

    @GetMapping("/categories/lowest-and-highest-price")
    public ResponseEntity<Integer> getLowestAndHighestPriceProductByCategoryName(@RequestParam(name = "category-name") final String categoryName)
    {
        reportApiService.LowestAndHighestPriceProductByCategoryName(categoryName);

        return null;
    }
}
