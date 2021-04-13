package com.sennu;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class OrgItem {
    private String item1;
    private String item2;

    public OrgItem(String item1, String item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return "OrgItem{" +
                "item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgItem)) return false;
        OrgItem orgItem = (OrgItem) o;
        return Objects.equals(getItem1(), orgItem.getItem1()) && Objects.equals(getItem2(), orgItem.getItem2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem1(), getItem2());
    }
}
