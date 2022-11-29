package com.msag.securityinfo.controller.data.internal;

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
    private final String imageUrl;
    private final SecurityInfoDetail infoDetail;

}
