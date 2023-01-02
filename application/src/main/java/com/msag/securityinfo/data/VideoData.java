package com.msag.securityinfo.data;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VideoData {
    private final int id;
    private final String title;
    private final String subTitle;
    private final String videoURL;
    private final Instant releaseDate;
    private final String description;
    private final CategoryInfo category;
}
