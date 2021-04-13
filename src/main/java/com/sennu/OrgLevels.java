package com.sennu;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class OrgLevels {
    List<OrgSummary> orgSummaryList;
    private String orgLevel1;
    private String orgLevel2;
    private String orgLevel3;

    public OrgLevels(String orgLevel1, String orgLevel2, String orgLevel3) {
        this.orgLevel1 = orgLevel1;
        this.orgLevel2 = orgLevel2;
        this.orgLevel3 = orgLevel3;
    }

    @Override
    public String toString() {
        return "OrgLevels{" +
                "orgLevel1='" + orgLevel1 + '\'' +
                ", orgLevel2='" + orgLevel2 + '\'' +
                ", orgLevel3='" + orgLevel3 + '\'' +
                ", orgSummaryList=" + orgSummaryList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrgLevels)) return false;
        OrgLevels orgLevels = (OrgLevels) o;
        return Objects.equals(getOrgSummaryList(), orgLevels.getOrgSummaryList()) && getOrgLevel1().equals(orgLevels.getOrgLevel1()) && getOrgLevel2().equals(orgLevels.getOrgLevel2()) && getOrgLevel3().equals(orgLevels.getOrgLevel3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrgSummaryList(), getOrgLevel1(), getOrgLevel2(), getOrgLevel3());
    }
}
