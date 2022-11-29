package com.msag.securityinfo.controller.service;

import com.msag.securityinfo.controller.data.SecurityInfoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Security-Info API")
@RequestMapping("/api/v1/securityInfo")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityInfoController {

    @GetMapping("generalInfo")
    @Operation(summary = "Can be used to fetch general security info data")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The request of security info data was completely", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecurityInfoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "There are one or more validation errors within the request"),
            @ApiResponse(responseCode = "500", description = "An unexpected error has occurred.")
    })
    public ResponseEntity<SecurityInfoResponseDTO> getGeneralNews(){

        return ResponseEntity.status(HttpStatus.OK).body(SecurityInfoResponseDTO.builder().build());

    }

}
