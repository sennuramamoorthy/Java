package com.sennu;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicOperations {

    public static void main(String[] args) {
        try {
            List<CsvPOJO> pojos = new CsvToBeanBuilder<CsvPOJO>(new FileReader("src/main/resources/JsonSchema.csv"))
                    .withType(CsvPOJO.class).withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build().parse();

            Map<OrgLevels, List<CsvPOJO>> groupedPojos =  pojos.stream().collect(Collectors.groupingBy(csvPOJO -> csvPOJO.getOrgLevelGroup(), Collectors.toList()));

            //groupedPojos.entrySet().stream().forEach(System.out::println);

            List<OrgLevels> organizedOrgLevels =  groupedPojos.entrySet().stream().map(orgLevelsListEntry -> {


                OrgLevels orgLevels = orgLevelsListEntry.getKey();
                List<CsvPOJO> summaryPojosList = orgLevelsListEntry.getValue();
                Map<OrgSummary, List<CsvPOJO>> groupedSummaryMap= summaryPojosList.stream().collect(Collectors.groupingBy(csvPOJO -> csvPOJO.getSummaryGroup(), Collectors.toList()));

                List<OrgSummary> summaryList = groupedSummaryMap.entrySet().stream().map(orgSummaryListEntry -> {
                    OrgSummary summary = orgSummaryListEntry.getKey();
                    List<OrgItem> itemsList = orgSummaryListEntry.getValue().stream().map(csvPOJO -> csvPOJO.getItemsObject()).collect(Collectors.toList());
                    summary.setOrgItemList(itemsList);
                    return summary;
                }).collect(Collectors.toList());

                orgLevels.setOrgSummaryList(summaryList);
                return orgLevels;
            }).collect(Collectors.toList());

            organizedOrgLevels.stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
