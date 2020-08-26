package ru.makarovie.jarSoftDemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String reqName;
    private boolean deleted;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Banner> listOfBanner;

    public Category(String name, String reqName) {
        this.name = name;
        this.reqName = reqName;
        this.deleted = false;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


}
