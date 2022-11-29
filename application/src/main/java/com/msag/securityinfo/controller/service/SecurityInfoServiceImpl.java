package com.msag.securityinfo.controller.service;

import com.msag.securityinfo.common.exception.GeneralNewsException;
import com.msag.securityinfo.common.exception.SecurityInfoException;
import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;
import com.msag.securityinfo.controller.data.internal.SecurityInfoNews;
import com.msag.securityinfo.gateway.generalnews.service.GeneralNewsService;
import com.msag.securityinfo.gateway.videonews.service.VideoNewsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class SecurityInfoServiceImpl implements SecurityInfoService {

    private final GeneralNewsService generalNewsService;

    private final VideoNewsService videoNewsService;
    @Override
    public SecurityInfoData getSecurityInfoNews() throws SecurityInfoException {
        log.debug("[SecurityInfoServiceImpl:getSecurityInfoNews] Start to get security info news");

        final List<SecurityInfoNews> generalNews;
        try {
            generalNews = this.generalNewsService.getGeneralNews();
            Collections.sort(generalNews, Comparator.comparing(SecurityInfoNews::getDate));
        } catch (GeneralNewsException e) {
            throw new SecurityInfoException(e.getMessage(), e);
        }

        log.debug("[SecurityInfoServiceImpl:getSecurityInfoNews] Finished to get security info news");
        return SecurityInfoData.builder()
                .infoNews(generalNews)
                .build();
    }
}
