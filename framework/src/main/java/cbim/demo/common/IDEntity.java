package com.cbim.demo.common;

import lombok.Data;

@Data
public class IDEntity {

    private String id = "";

    public IDEntity() {
    }

    public IDEntity(String id) {
        this.id = id;
    }
}
