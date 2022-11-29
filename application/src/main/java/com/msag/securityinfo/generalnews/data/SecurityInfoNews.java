package com.msag.securityinfo.generalnews.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class SecurityInfoNews {
    private final String title;
    private final Instant date;
    private final String shortDescription;
    private final CategoryInfo category;

}