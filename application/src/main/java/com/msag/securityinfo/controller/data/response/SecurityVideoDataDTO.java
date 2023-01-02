package com.msag.securityinfo.controller.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityVideoDataDTO {
    @Schema(name="icon", description = "icon of video data", example = "https://www.is-fox.de/SecurityInfo/Content/Userfiles/hvs/Thumbnails/Mobile-Geraete.png")
    private final String icon;

    @Schema(name="data", description = "video data")
    private final List<VideoDataDTO> data;

}
