package com.enatbanksc.casemanagementsystem.case_management.MortgageDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface MortgageDetailRepository extends PagingAndSortingRepository<MortgageDetail, Long>, JpaSpecificationExecutor<MortgageDetail> {
    Page<MortgageDetail> findAllByDeletedIsFalseOrderByMortgageDetailIdDesc(Pageable pageable);
    Page<MortgageDetail> findMortgageDetailByBranchIdAndDeletedIsFalseOrderByMortgageDetailIdDesc(Pageable pageable, Long branchId);
    @Query(value = "select * from mortgage_details l where  l.id  !=:branchId" , nativeQuery = true)
    Page<MortgageDetail> findAllByBranchIdAndDeletedIsFalseOrderByMortgageDetailIdDesc(Pageable pageable, @Param("branchId") Long branchId);

//    Page<MortgageDetail> findAllByBranchIdIsNotContainingOrderByCreatedAtDesc(Pageable pageable, Long branchId);
    Page<MortgageDetail> findMortgageDetailByStatusAndDeletedIsFalseOrderByMortgageDetailIdDesc(Pageable pageable, String Status);
    Page<MortgageDetail> findMortgageDetailByAttorneyHandlingTheCaseAndDeletedIsFalseOrderByMortgageDetailIdDesc(Pageable pageable, String attorney);

}
