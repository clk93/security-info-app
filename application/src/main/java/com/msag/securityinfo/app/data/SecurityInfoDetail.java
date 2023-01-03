package com.msag.securityinfo.app.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SecurityInfoDetail {
    private final String text;
    private final List<String> imageUrls;
}
