package com.sennu;

import com.opencsv.bean.*;

public class CsvPOJO {

    @CsvBindByPosition(position = 0)
    private String orgLevel1;
    @CsvBindByPosition(position = 1)
    private String orgLevel2;
    @CsvBindByPosition(position = 2)
    private String orgLevel3;
    @CsvBindByPosition(position = 3)
    private String summary1;
    @CsvBindByPosition(position = 4)
    private String summary2;
    @CsvBindByPosition(position = 5)
    private String summary3;
    @CsvBindByPosition(position = 6)
    private String item1;
    @CsvBindByPosition(position = 7)
    private String item2;

    public OrgLevels getOrgLevelGroup(){
        return new OrgLevels(orgLevel1, orgLevel2, orgLevel3) ;
    }

    public OrgSummary getSummaryGroup(){
        return new OrgSummary(summary1, summary2, summary3) ;
    }

    public OrgItem getItemsObject(){
        return new OrgItem(item1, item2);
    }

}
