package com.msag.securityinfo.controller.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryInfoDTO {
    @Schema(name = "category", description = "name of category", example = "Video")
    private final String category;
    @Schema(name="iconUrl", description = "url of category icon", example = "https://staging-probeapi.mobile-software.ag/aufgabe-backend/assets/Video.png")
    private final String iconUrl;
}
