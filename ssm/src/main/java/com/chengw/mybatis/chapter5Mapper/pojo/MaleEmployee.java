package com.chengw.mybatis.chapter5Mapper.pojo;

import com.chengw.mybatis.chapter5Mapper.pojo.Employee;

public class MaleEmployee extends Employee {
    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }
}
