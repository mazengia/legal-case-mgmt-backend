package com.enatbanksc.casemanagementsystem.case_management.Executions;


import com.enatbanksc.casemanagementsystem.case_management.JudiciaryReport.JudicialAppointments.JudicialAppointment;
import com.enatbanksc.casemanagementsystem.case_management._EmbeddedClasses.CaseOwnerBranchDto;
import com.enatbanksc.casemanagementsystem.case_management._config.utils.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ExecutionsDto extends Auditable {
    private Long executionsId;
    private String fileNumber;
    private String courtAdjudicating;
    private String caseStage;
    private String attorneyHandlingTheCase;
    private  String  caseType;
    private CaseOwnerBranchDto branch;
//    private List<JudicialAppointment> judicialAppointment;

}