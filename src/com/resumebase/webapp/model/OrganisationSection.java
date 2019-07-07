package com.resumebase.webapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends Section implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Organisation> organisations;

    public OrganisationSection() {
    }

    public OrganisationSection(List<Organisation> organisations) {
        Objects.requireNonNull(organisations, "organisations must not be null");
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public String toString() {
        return organisations.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return organisations.equals(that.organisations);
    }

    @Override
    public int hashCode() {
        return organisations.hashCode();
    }
}
