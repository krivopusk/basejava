package com.resumebase.webapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> items;

    public ListSection() {
    }

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "list items must not be null");
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }
}
