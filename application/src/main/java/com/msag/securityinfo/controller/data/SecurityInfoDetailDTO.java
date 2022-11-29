package com.msag.securityinfo.controller.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class SecurityInfoDetailDTO {
    private final String title;
    private final Instant date;
    private final String shortDescription;
    private final String text;
}
