package com.tastycai.multidatasource.wms.service.impl;

import com.tastycai.multidatasource.wms.dao.StockMapper;
import com.tastycai.multidatasource.wms.model.Stock;
import com.tastycai.multidatasource.wms.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public void saveStock() {

        Stock stock = new Stock();

        stock.setProductId(1);
        stock.setProductCode("C001");
        stock.setStockNumber(100);
        stock.setWarehouseCode("sz");

        stockMapper.insertSelective(stock);
    }
}
