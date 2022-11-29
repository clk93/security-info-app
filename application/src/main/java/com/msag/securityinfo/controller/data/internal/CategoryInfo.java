package com.msag.securityinfo.controller.data.internal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryInfo {
    private final String name;
    private String iconUrl;
}
