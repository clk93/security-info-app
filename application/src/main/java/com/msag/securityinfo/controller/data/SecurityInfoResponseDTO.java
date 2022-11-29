package com.msag.securityinfo.controller.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoResponseDTO {
    private final SecurityInfoDetailDTO detailInfo;
    private final List<SecurityInfoNewsDTO> infoNews;
    private String message;
}
