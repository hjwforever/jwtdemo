package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author hjwforever
 * @date 12/03/2021 6:53 PM
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class BaseEntity {
    /*    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        protected Integer id;*/
    /*
    创建时间
    */
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long createTime;

    /* 最后修改时间 */
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long updateTime;


    /*
     * 创建人
     */
    @Column(name = "create_by")
    @CreatedBy
    private Long createBy;

    /*
     * 修改人
     */
    @Column(name = "lastmodified_by")
    @LastModifiedBy
    private String lastmodifiedBy;
}