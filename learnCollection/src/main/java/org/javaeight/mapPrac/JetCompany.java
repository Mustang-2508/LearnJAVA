package org.javaeight.mapPrac;

import java.util.Objects;

public class JetCompany {
    private int id;
    private String name;

    public JetCompany(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(getClass() != obj.getClass())
            return false;

        if(obj == null)
            return false;

        JetCompany jetCompany = (JetCompany) obj;
        return id == jetCompany.getId() && Objects.equals(name, jetCompany.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
