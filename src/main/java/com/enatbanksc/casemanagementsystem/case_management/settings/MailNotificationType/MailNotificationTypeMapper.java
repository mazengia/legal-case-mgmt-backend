package com.enatbanksc.casemanagementsystem.case_management.settings.MailNotificationType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailNotificationTypeMapper {
    MailNotificationType toMailNotificationType(MailNotificationTypeDto mailNotificationTypeDto);
    MailNotificationTypeDto toMailNotificationTypeDto(MailNotificationType mailNotificationType);
}
