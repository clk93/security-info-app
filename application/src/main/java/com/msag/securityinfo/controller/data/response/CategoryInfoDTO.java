package com.msag.securityinfo.controller.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryInfoDTO {
    private final String category;
    private final String iconUrl;
}
