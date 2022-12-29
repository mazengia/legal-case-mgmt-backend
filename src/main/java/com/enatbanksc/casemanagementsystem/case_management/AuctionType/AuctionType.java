package com.enatbanksc.casemanagementsystem.case_management.AuctionType;

import com.enatbanksc.casemanagementsystem.case_management.MortgageType.MortgageDetail.MortgageDetail;
import com.enatbanksc.casemanagementsystem.case_management._EmbeddedClasses.Employee;
import com.enatbanksc.casemanagementsystem.case_management._config.utils.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name="AuctionType")
@Table(name="auction_types")
@Data
@Where(clause = "deleted=0")
@SQLDelete(sql = "UPDATE auction_types SET deleted = 1 WHERE id=? and version=?")
public class AuctionType extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionTypeId;
    @NotEmpty(message = "Auction Type Name can not be empty!")
    private String auctionTypeName;
    private String auctionTypeColor;
    @Schema(hidden = true)
    @Column(name = "dateAuctionAnnounced", nullable = false, updatable = false)
    private String dateAuctionAnnounced;
    private String dateAuctionWillBeConducted;
    private String dateAuctionConducted;
    @ManyToOne(fetch = FetchType.EAGER, optional = false )
    @JoinColumn(name = "mortgageDetailId",nullable = false)
    @JsonIgnoreProperties(value={"auctionType"} )
    private MortgageDetail mortgageDetail;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "employeeId", column = @Column(name = "maintainer_employee_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maintainer_employee_fullName")),
            @AttributeOverride(name = "branch.code", column = @Column(name = "maintainer_branch_code")),
            @AttributeOverride(name = "branch.name", column = @Column(name = "maintainer_branch_name"))
    })
    private Employee maintained_by;

}
