package com.cbim.demo.common;

import com.cbim.common.util.IdWorkerUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.Date;

@Slf4j
@Data
@MappedSuperclass
public class BaseIDWorkEntity<T> implements Serializable {


    private static final long serialVersionUID = -5088547566060157230L;

    @Id
    public Long id;

    @Column(name = "create_by")
    public Long createBy;

    @Column(name= "create_date")
    public Date createDate;

    @Column(name="update_by")
    public Long updateBy;

    @Column(name="update_Date")
    public Date updateDate;

    public BaseIDWorkEntity() {
    }

    public BaseIDWorkEntity(Long id) {
        this();
        this.id = id;
    }

    @PrePersist
    public void prePersist(){
        if(this.id == null){
            IdWorkerUtil idWorkerUtil = IdWorkerUtil.getInstance();
            setId(idWorkerUtil.nextId());
        }

    }
}
