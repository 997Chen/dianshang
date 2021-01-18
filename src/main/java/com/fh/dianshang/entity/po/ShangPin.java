package com.fh.dianshang.entity.po;

import java.util.Date;

/**
 * @author cyl
 * @create 2021-01-18 18:40
 */
public class ShangPin {
private Integer    id; //主键
    private String    name ; // 名称
    private String   title ; // 标题
    private Integer   pzId ; // 品牌id
    private String  productdecs ; // 商品介绍
    private Double    price ; //  价格
    private Integer   stocks ; // 库存
    private Integer   sortNum ; // 排许
    private Date createDate;
    private Date   updateDate;
    private String  author;
    private Integer  isDel;  //是否删除

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPzId() {
        return pzId;
    }

    public void setPzId(Integer pzId) {
        this.pzId = pzId;
    }

    public String getProductdecs() {
        return productdecs;
    }

    public void setProductdecs(String productdecs) {
        this.productdecs = productdecs;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
