package com.tastycai.multidatasource.sms.service.impl;

import com.tastycai.multidatasource.sms.dao.ProductMapper;
import com.tastycai.multidatasource.sms.model.Product;
import com.tastycai.multidatasource.sms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void saveProduct() {

        Product product = new Product();

        product.setProductCode("C001");
        product.setProductName("C001");

        productMapper.insertSelective(product);
    }
}
