package com.resumebase.webapp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganisationSection extends Section implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Organisation> Organisations;

    public OrganisationSection() {}

    public OrganisationSection(Organisation... Organisations) {
        this(Arrays.asList(Organisations));
    }

    public OrganisationSection(List<Organisation> Organisations) {
        Objects.requireNonNull(Organisations, "Organisations must not be null");
        this.Organisations = Organisations;
    }

    public List<Organisation> getOrganisations() {
        return Organisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return Organisations.equals(that.Organisations);

    }

    @Override
    public int hashCode() {
        return Organisations.hashCode();
    }

    @Override
    public String toString() {
        return Organisations.toString();
    }
}
