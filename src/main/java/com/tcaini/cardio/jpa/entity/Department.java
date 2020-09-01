package com.tcaini.cardio.jpa.entity;

import com.tcaini.cardio.jpa.entity.base.AbstractAuditModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orm_department")
public class Department extends AbstractAuditModel {

    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;

    @ManyToOne(cascade = {CascadeType.REFRESH}, optional = true)
    @JoinColumn(name = "superior", referencedColumnName = "id")
    private Department superior;

    @Column(name = "levels", columnDefinition = "int not null default 0")
    private Integer levels;

    @Column(name = "order_no", columnDefinition = "int not null default 0")
    private Integer orderNo;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "superior")
    private Collection<Department> children;

    @ManyToMany(mappedBy = "departmentList")
    private Collection<User> userList;
}
