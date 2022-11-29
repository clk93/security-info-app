package com.msag.securityinfo.controller.data.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoDetailDTO {
    private final String text;
    private final List<String> imageUrls;
}
