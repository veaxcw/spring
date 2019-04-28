package com.cbim.demo.po;

import com.cbim.demo.common.BaseIDWorkEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "areaBean")
@Table(name = "js_chengw_area")
@Data
public class AreaBean extends BaseIDWorkEntity<AreaBean> {

    private static final long serialVersionUID = 1910053808814531311L;

    @Column(name="area_code")
    private String areaCode;		// 区域代码
    @Column(name="area_name")
    private String areaName;		// 区域名称
   @Column(name = "area_type")
    private String areaType; 		// 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）

    public AreaBean() {
    }

    public AreaBean(Long id) {
        super(id);
    }
}
