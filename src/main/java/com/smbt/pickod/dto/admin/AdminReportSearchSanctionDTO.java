package com.smbt.pickod.dto.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class AdminReportSearchSanctionDTO {
    private String inqCondition;
    private String inqKeyword;
}
