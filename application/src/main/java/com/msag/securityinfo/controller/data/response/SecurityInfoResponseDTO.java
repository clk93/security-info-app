package com.msag.securityinfo.controller.data.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoResponseDTO {
    private final List<SecurityInfoNewsDTO> infoNews;
    private final SecurityVideoDataDTO videoData;
    private String message;
}
