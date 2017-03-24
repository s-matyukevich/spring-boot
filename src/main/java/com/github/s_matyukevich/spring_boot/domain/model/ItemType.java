package com.github.s_matyukevich.spring_boot.domain.model;

public enum ItemType {

    UNKNOWN(1L),
    ELECTRONICS(2L),
    CD(3L);

    Long id;

    ItemType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
