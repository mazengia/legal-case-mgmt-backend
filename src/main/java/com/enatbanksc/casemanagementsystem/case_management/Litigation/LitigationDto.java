package com.enatbanksc.casemanagementsystem.case_management.Litigation;


import com.enatbanksc.casemanagementsystem.case_management.Intervene.Intervene;
import com.enatbanksc.casemanagementsystem.case_management.JudicialAppointments.JudicialAppointment;
import com.enatbanksc.casemanagementsystem.case_management._EmbeddedClasses.CaseOwnerBranchDto;
import com.enatbanksc.casemanagementsystem.case_management._config.utils.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class LitigationDto extends Auditable {
    private Long litigationId;
    private String fileNumber;
    private String courtAdjudicating;
    private String disputedAmount;
    private Boolean isBankPlaintiff;
    private String caseStage;
    private CaseOwnerBranchDto branch;
    private String attorneyHandlingTheCase;
    private String status;
    private Intervene intervene;
    private String content;
    private String caseType;

}
