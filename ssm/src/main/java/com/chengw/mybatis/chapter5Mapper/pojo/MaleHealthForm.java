package com.chengw.mybatis.chapter5Mapper.pojo;

import com.chengw.mybatis.chapter5Mapper.pojo.HealthForm;

public class MaleHealthForm extends HealthForm {
    private  String prostate;

    public String getProstate() {
        return prostate;
    }

    public void setProstate(String prostate) {
        this.prostate = prostate;
    }
}
