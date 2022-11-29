package com.msag.securityinfo.controller.data.internal;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoData {
    private final List<SecurityInfoNews> infoNews;
}
