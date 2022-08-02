package com.flashhammer.juicyfruit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sort {
    boolean unsorted;
    boolean sorted;

    @JsonProperty("unsorted")
    public boolean getUnsorted() {
        return this.unsorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    @JsonProperty("sorted")
    public boolean getSorted() {
        return this.sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
}
