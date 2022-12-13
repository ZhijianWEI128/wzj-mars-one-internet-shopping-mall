package com.gec.pojo;

public class Shopcar {
    private Integer id;

    private Integer articleid;

    private Integer buynum;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Shopcar{" +
                "id=" + id +
                ", articleid=" + articleid +
                ", buynum=" + buynum +
                ", userid=" + userid +
                '}';
    }
}