package com.enatbanksc.casemanagementsystem.case_management.settings.Expense;

import com.enatbanksc.casemanagementsystem.case_management.EmbeddedClasses.Employee;
import com.enatbanksc.casemanagementsystem.case_management.JudiciaryReport.JudiciaryReport;
import com.enatbanksc.casemanagementsystem.case_management.JudiciaryReport.JudiciaryReportDto;
import com.enatbanksc.casemanagementsystem.case_management.Litigation.Litigation;
import com.enatbanksc.casemanagementsystem.case_management.settings.Expense.ExpenseDetails.ExpenseDetail;
import com.enatbanksc.casemanagementsystem.case_management.utils.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "expenses")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE expenses SET deleted = 1 WHERE id=? and version=?")
public class Expense extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
    @NotEmpty(message = "Expense Name may not be empty")
    private String expenseName;
    private String expenseTypeColor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "employeeId", column = @Column(name = "maintainer_employee_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maintainer_employee_fullName")),
            @AttributeOverride(name = "branch.code", column = @Column(name = "maintainer_branch_code")),
            @AttributeOverride(name = "branch.name", column = @Column(name = "maintainer_branch_name"))
    })
    private Employee maintained_by;

}
