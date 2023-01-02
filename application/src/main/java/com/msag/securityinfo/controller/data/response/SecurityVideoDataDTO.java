package com.msag.securityinfo.controller.data.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityVideoDataDTO {
    private final String icon;
    private final List<VideoDataDTO> data;

}
