package com.yak.index.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yak_website")
public class Website {
    @Id
    @GeneratedValue
    private int id;
    private int categoryId;
    private int sort;
    private String name;
    private String url;
    private String icon;
    private String description;
    private String shade;

    public int getId() {
        return id;
    }

    public Website setId( int id ) {
        this.id = id;
        return this;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Website setCategoryId() {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Website setName( String name ) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Website setUrl( String url ) {
        this.url = url;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Website setIcon( String icon ) {
        this.icon = icon;
        return this;
    }

    public int getSort() {
        return sort;
    }

    public Website setSort( int age ) {
        this.sort = sort;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Website setDescription( String description ) {
        this.description = description;
        return this;
    }

    public String getShade() {
        return shade;
    }

    public Website setShade( String shade ) {
        this.shade = shade;
        return this;
    }
}
