package com.enatbanksc.casemanagementsystem.case_management.Litigation;

import com.enatbanksc.casemanagementsystem.case_management.JudiciaryReport.JudicialAppointments.JudicialAppointmentDto;
import com.enatbanksc.casemanagementsystem.case_management._config.Common.CaseStage;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.enatbanksc.casemanagementsystem.case_management._config.Common.CaseStage.POST_TRIAL;

public interface LitigationApi {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    LitigationDto createLitigation(@RequestBody @Valid LitigationDto litigationDto, JwtAuthenticationToken token) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LitigationDto getLitigation(@PathVariable("id") long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LitigationDto updateLitigation(@PathVariable("id") long id, @RequestBody @Valid LitigationDto litigationDto, JwtAuthenticationToken token) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<LitigationDto>> getLitigations(@Parameter(description = "pagination object",
            schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                       PagedResourcesAssembler assembler,
                                                       UriComponentsBuilder uriBuilder,
                                                       final HttpServletResponse response);

    @GetMapping("/case-stage/{caseStage}")
    ResponseEntity<PagedModel<LitigationDto>> getLitigationByCaseStage(@Parameter(
            description = "pagination object",
            schema = @Schema(implementation = Pageable.class)) @Valid Pageable pageable,
                                                                                        @PathVariable("caseStage") CaseStage caseStage,
                                                                                        PagedResourcesAssembler assembler,
                                                                                        JwtAuthenticationToken token,
                                                                                        UriComponentsBuilder uriBuilder,
                                                                                        HttpServletResponse response);


}
