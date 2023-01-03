package com.msag.securityinfo.controller.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class SecurityInfoNewsDTO {
    @Schema(name = "title", description = "title of security info", example = "Security gaps in WhatsApp still open")
    private final String title;

    @Schema(name = "date", description = "date of info", example = "2018-10-18T22:00:00Z")
    private final Instant date;

    @Schema(name = "shortDescription", description = "short description of security indo", example = "Hackers can use a video call to capture the entire smartphone. Google is dragging its feet.")
    private final String shortDescription;

    @Schema(name = "category", description = "category of security info")
    private final CategoryInfoDTO category;

    @Schema(name = "imageUrl", description = "url of image for security info", example = "https://www.is-fox.de/SecurityInfo/Content/UserFiles/hvs/Images/18-10%20WA/WA.jpg")
    private final String imageUrl;

    @Schema(name = "detailInfo", description = "detailed information of security info")
    private final SecurityInfoDetailDTO detailInfo;
}
