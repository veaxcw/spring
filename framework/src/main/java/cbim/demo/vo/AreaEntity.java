package com.cbim.demo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
public class AreaEntity implements Serializable {

    private static final long serialVersionUID = 8061237766163851267L;

    @ApiModelProperty(value = "id",name = "id")
    private Long id;

    @ApiModelProperty(value = "邮政编码",name = "areaCode")
    private String areaCode;

    @ApiModelProperty(value = "名称",name = "areaName")
    private String areaName;

    @ApiModelProperty(value = "类型",name = "areaType")
    private String areaType;

    @ApiModelProperty(value = "创建人",name = "createBy")
    public Long createBy;

    @ApiModelProperty(value = "创建时间",name="createDate")
    public Date createDate;

    @ApiModelProperty(value = "更新人",name = "updateBy")
    public Long updateBy;

    @ApiModelProperty(value = "更新时间",name = "updateDate")
    public Date updateDate;



}
