package com.tastycai.multidatasource.sms.model;

public class Product {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_product.product_id
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_product.product_code
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    private String productCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sms_product.product_name
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    private String productName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_product.product_id
     *
     * @return the value of sms_product.product_id
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_product.product_id
     *
     * @param productId the value for sms_product.product_id
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_product.product_code
     *
     * @return the value of sms_product.product_code
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_product.product_code
     *
     * @param productCode the value for sms_product.product_code
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sms_product.product_name
     *
     * @return the value of sms_product.product_name
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sms_product.product_name
     *
     * @param productName the value for sms_product.product_name
     *
     * @mbg.generated Sun Aug 04 15:32:16 CST 2019
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }
}