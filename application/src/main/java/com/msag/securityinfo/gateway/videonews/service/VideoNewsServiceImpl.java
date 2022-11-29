package com.msag.securityinfo.gateway.videonews.service;

import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class VideoNewsServiceImpl implements VideoNewsService {

    @Value("${com.msag.securityInfo.gateway.videoNews.url}")
    private String videoNewsUrl;

    private final RestTemplate restTemplate;

    @Override
    public SecurityInfoData getVideoNews() throws VideoNewsException {
        log.debug("[VideoNewsServiceImpl:getVideoNews] Start to fetch general news");
        return null;
    }
}
