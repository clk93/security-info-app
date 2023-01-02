package com.msag.securityinfo.controller.data.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VideoDataDTO {
    private final String title;
    private final String subtitle;
    private final String url;
    private final Instant date;
    private final String description;
    private final CategoryInfoDTO category;
}
