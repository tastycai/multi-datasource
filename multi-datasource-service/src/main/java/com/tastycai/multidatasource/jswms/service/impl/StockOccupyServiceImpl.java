package com.tastycai.multidatasource.jswms.service.impl;

import com.tastycai.multidatasource.jswms.dao.StockOccupyMapper;
import com.tastycai.multidatasource.jswms.model.StockOccupy;
import com.tastycai.multidatasource.jswms.service.StockOccupyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockOccupyServiceImpl implements StockOccupyService {

    @Autowired
    private StockOccupyMapper stockOccupyMapper;

    @Override
    public void saveStockOccupy() {

        StockOccupy stockOccupy = new StockOccupy();

        stockOccupy.setProductId(1);
        stockOccupy.setOccupyNumber(20);
        stockOccupy.setProductCode("C001");

        stockOccupyMapper.insertSelective(stockOccupy);
    }
}
