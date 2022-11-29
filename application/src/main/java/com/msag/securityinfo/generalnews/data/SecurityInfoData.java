package com.msag.securityinfo.generalnews.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SecurityInfoData {
    private final List<SecurityInfoNews> infoNews;
    private final SecurityInfoDetail infoDetail;

}
