package com.tastycai.multidatasource.wms.dao;

import com.tastycai.multidatasource.wms.model.Stock;
import com.tastycai.multidatasource.wms.model.StockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    long countByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int deleteByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int deleteByPrimaryKey(Integer stockId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int insert(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int insertSelective(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    List<Stock> selectByExample(StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    Stock selectByPrimaryKey(Integer stockId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int updateByPrimaryKeySelective(Stock record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wms_stock
     *
     * @mbg.generated Sun Aug 04 15:27:56 CST 2019
     */
    int updateByPrimaryKey(Stock record);
}