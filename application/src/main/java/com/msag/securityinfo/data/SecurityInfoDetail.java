package com.msag.securityinfo.data;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SecurityInfoDetail {
    private final String text;
    private final List<String> imageUrls;
}
