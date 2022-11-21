package com.enatbanksc.casemanagementsystem.case_management.settings.MailNotificationType;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface MailNotificationTypeRepository extends PagingAndSortingRepository<MailNotificationType, Long>, JpaSpecificationExecutor<MailNotificationType> {
    boolean existsByMailTypeName(String mailTypeName);
}
