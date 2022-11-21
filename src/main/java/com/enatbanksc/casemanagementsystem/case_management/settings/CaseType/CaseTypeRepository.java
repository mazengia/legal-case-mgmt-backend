package com.enatbanksc.casemanagementsystem.case_management.settings.CaseType;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface CaseTypeRepository extends PagingAndSortingRepository<CaseType, Long>, JpaSpecificationExecutor<CaseType> {
}
