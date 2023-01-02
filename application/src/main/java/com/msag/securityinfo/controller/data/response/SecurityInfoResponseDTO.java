package com.msag.securityinfo.controller.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoResponseDTO {
    @Schema(name = "infoNews", description = "security info news")
    private final List<SecurityInfoNewsDTO> infoNews;

    @Schema(name = "videoData", description = "provided video infos")
    private final SecurityVideoDataDTO videoData;

    @Schema(name="message", description = "error message or status of request", example = "Success")
    private String message;
}
