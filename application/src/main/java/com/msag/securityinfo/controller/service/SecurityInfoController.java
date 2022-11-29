package com.msag.securityinfo.controller.service;

import com.msag.securityinfo.controller.data.response.SecurityInfoResponseDTO;
import com.msag.securityinfo.controller.utils.SecurityInfoMapper;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;
import com.msag.securityinfo.common.exception.SecurityInfoException;
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

import java.util.Objects;

@Tag(name = "Security-Info API")
@RequestMapping("/api/v1/securityInfo")
@RestController
@RequiredArgsConstructor
@Slf4j
public class SecurityInfoController {
    private final SecurityInfoService securityInfoService;

    @GetMapping()
    @Operation(summary = "Can be used to fetch general security info data")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The request of security info data was completely", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SecurityInfoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "There are one or more validation errors within the request"),
            @ApiResponse(responseCode = "500", description = "An unexpected error has occurred.")
    })
    public ResponseEntity<SecurityInfoResponseDTO> getSecurityInfos(){
        try {
            log.debug("[SecurityInfoController:getSecurityInfos] Start to fetch security infos");
            final SecurityInfoData securityInfoData = this.securityInfoService.getSecurityInfoNews();
            log.debug("[SecurityInfoController:getSecurityInfos] Finished to fetch security infos: {}", securityInfoData);

            if(Objects.isNull(securityInfoData)){
                log.error("[SecurityInfoController:getSecurityInfos] No Data could be fetched");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SecurityInfoResponseDTO.builder().message("No Data available, please contact your administrator").build());
            }

            final SecurityInfoResponseDTO result = SecurityInfoMapper.mapDTO(securityInfoData);
            result.setMessage("success");
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (SecurityInfoException e) {
            log.error("[SecurityInfoController:getSecurityInfos] Error during request security infos: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SecurityInfoResponseDTO.builder().message("An error occurred, please contact your administrator").build());
        } catch (Exception e){
            log.error("[SecurityInfoController:getSecurityInfos] Error during fetch security infos: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SecurityInfoResponseDTO.builder().message("An error occurred, please contact your administrator").build());
        }
    }

}
