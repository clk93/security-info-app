package com.msag.securityinfo.controller.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoDetailDTO {
    @Schema(name = "text", description = "text of security info", example = "<p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr,..</p>")
    private final String text;
    @Schema(name="imageUrls", description = "gallery of images for security info", example = "fox.de/SecurityInfo/Content/UserFiles/mobile-software/Images/Bild4.png")
    private final List<String> imageUrls;
}
