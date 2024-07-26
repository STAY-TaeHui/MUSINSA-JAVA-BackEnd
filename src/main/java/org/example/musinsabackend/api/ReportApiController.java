package org.example.musinsabackend.api;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.service.ReportApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        //TODO
        //카테고리 별로 최저가격의 상품을 조회한 다음 해당 상품의 브랜드와 상품 가격, 마지막으로 총 가격을 조회하는 기능.
        int i = reportApiService.lowestPriceProductByCategory();

        return null;
    }
}
