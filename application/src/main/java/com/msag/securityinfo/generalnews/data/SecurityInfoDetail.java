package com.msag.securityinfo.generalnews.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SecurityInfoDetail {
    private final String title;
    private final Instant date;
    private final String shortDescription;
    private final String text;
}
