package com.msag.securityinfo.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityVideoInfoData {
    private final String icon;
    private final List<VideoData> videoData;
}
