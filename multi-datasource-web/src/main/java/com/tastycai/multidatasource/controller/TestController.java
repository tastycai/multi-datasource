package com.tastycai.multidatasource.controller;

import com.tastycai.multidatasource.jswms.service.StockOccupyService;
import com.tastycai.multidatasource.sms.service.ProductService;
import com.tastycai.multidatasource.wms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockOccupyService stockOccupyService;

    @Autowired
    private ProductService productService;

    @GetMapping("/save/stock")
    public void saveStock(){

        stockService.saveStock();
    }

    @GetMapping("/save/stock-occupy")
    public void saveStockOccupy(){

        stockOccupyService.saveStockOccupy();
    }

    @GetMapping("/save/product")
    public void saveProduct(){

        productService.saveProduct();
    }
}
