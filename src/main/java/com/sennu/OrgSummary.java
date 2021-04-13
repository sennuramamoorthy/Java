package com.sennu;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class OrgSummary {
    private List<OrgItem> orgItemList;
    private String summary1;
    private String summary2;
    private String summary3;


    public OrgSummary(String summary1, String summary2, String summary3) {
        this.summary1 = summary1;
        this.summary2 = summary2;
        this.summary3 = summary3;
    }

    @Override
    public String toString() {
        return "OrgSummary{" +
                "summary1='" + summary1 + '\'' +
                ", summary2='" + summary2 + '\'' +
                ", summary3='" + summary3 + '\'' +
                ", orgItemList=" + orgItemList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgSummary)) return false;
        OrgSummary summary = (OrgSummary) o;
        return Objects.equals(getOrgItemList(), summary.getOrgItemList()) && Objects.equals(getSummary1(), summary.getSummary1()) && Objects.equals(getSummary2(), summary.getSummary2()) && Objects.equals(getSummary3(), summary.getSummary3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrgItemList(), getSummary1(), getSummary2(), getSummary3());
    }
}
