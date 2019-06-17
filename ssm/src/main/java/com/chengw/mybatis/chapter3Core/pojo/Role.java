package com.chengw.mybatis.chapter3Core.pojo;

public class Role {
    private int id;
    private String roleName;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString(){
        return "id :" + getId() + "\n" +
                "roleName:" + getRoleName() + "\n" +
                "notes:" + getNote();
    }
}