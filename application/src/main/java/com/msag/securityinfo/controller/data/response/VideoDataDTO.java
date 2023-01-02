package com.msag.securityinfo.controller.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VideoDataDTO {
    @Schema(name = "title", description = "title of video", example = "Video: Creating secure passwords")
    private final String title;

    @Schema(name = "subtitle", description = "sbtitle", example = "\"Secret\" or \"123456\" is far away from being a strong password. We show you how to create secure passwords.")
    private final String subtitle;

    @Schema(name = "url", description = "url of video", example = "https://www.is-fox.de/SecurityInfo/Content/UserFiles/hvs/Videos/304-secure-passwords-en.mp4")
    private final String url;

    @Schema(name = "date", description = "release date of video", example = "2016-02-07T00:00:00Z")
    private final Instant date;

    @Schema(name = "description", description = "description of the video", example = "<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum...</p>")
    private final String description;

    @Schema(name = "category", description = "category of security info")
    private final CategoryInfoDTO category;
}
