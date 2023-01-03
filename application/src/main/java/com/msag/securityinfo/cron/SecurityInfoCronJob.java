package com.msag.securityinfo.cron;

import com.msag.securityinfo.app.data.SecurityInfoNews;
import com.msag.securityinfo.app.data.SecurityVideoInfoData;
import com.msag.securityinfo.common.exception.GeneralNewsException;
import com.msag.securityinfo.common.exception.ImportException;
import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.gateway.generalnews.service.GeneralNewsService;
import com.msag.securityinfo.gateway.videonews.service.VideoNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class SecurityInfoCronJob {
    private GeneralNewsService generalNewsService;
    private VideoNewsService videoNewsService;

    // CronExpression: second, minute, hour, day of the month, month, day of the week
    // https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions
    @Scheduled(cron = "${com.msag.securityInfo.importCron}")
    public void startImport() throws ImportException {
        this.handleInfoNews();
        this.handleVideoData();
    }

    private void handleInfoNews() throws ImportException {
        final List<SecurityInfoNews> generalNews;
        try {
            log.debug("[SecurityInfoCronJob:handleInfoNews] Start import of security info data");
            generalNews = this.generalNewsService.getGeneralNews();
            log.debug("[SecurityInfoCronJob:handleInfoNews] Finished import of security info data {}", generalNews);
        } catch (GeneralNewsException e) {
            final String errorMessage = MessageFormat.format("Error during download security info news: {0}", e.getMessage());
            log.error("[SecurityInfoCronJob:handleInfoNews] Error: {}", errorMessage, e);
            throw new ImportException(errorMessage, e);
        }
        //ToDo persist security info in DB
    }

    private void handleVideoData() throws ImportException {
        final SecurityVideoInfoData videoData;
        try {
            log.debug("[SecurityInfoCronJob:handleVideoData] Start import of security video data");
            videoData = this.videoNewsService.getVideoData();
            log.debug("[SecurityInfoCronJob:handleVideoData] Finished import of security video data {}", videoData);
        } catch (VideoNewsException e) {
            final String errorMessage = MessageFormat.format("Error during download security info videos: {0}", e.getMessage());
            log.error("[SecurityInfoCronJob:handleVideoData] Error: {}", errorMessage, e);
            throw new ImportException(errorMessage, e);
        }
        //ToDo persist security videos in DB
    }
}
