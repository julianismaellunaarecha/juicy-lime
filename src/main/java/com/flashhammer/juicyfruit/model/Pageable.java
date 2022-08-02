package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pageable {
    Sort sort;
    int pageNumber;
    int pageSize;
    int offset;
    boolean unpaged;
    boolean paged;

    @JsonProperty("sort")
    public Sort getSort() {
        return this.sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @JsonProperty("pageNumber")
    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("pageSize")
    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("offset")
    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @JsonProperty("unpaged")
    public boolean getUnpaged() {
        return this.unpaged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }

    @JsonProperty("paged")
    public boolean getPaged() {
        return this.paged;
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }
}
