package com.enatbanksc.casemanagementsystem.case_management.settings.Expense.ExpenseDetails;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseDetailMapper {
    ExpenseDetail toExpenseDetail(ExpenseDetailDto expenseDetailDto);
    ExpenseDetailDto toExpenseDetailDto(ExpenseDetail expenseDetail);
}
