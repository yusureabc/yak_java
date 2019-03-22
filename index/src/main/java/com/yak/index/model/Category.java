package com.yak.index.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yak_category")
public class Category {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private int sort;

    public int getId() {
        return id;
    }

    public Category setId( int id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName( String name ) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Category setIcon( String icon ) {
        this.icon = icon;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public Category setSort( int age ) {
        this.sort = sort;
        return this;
    }
}
