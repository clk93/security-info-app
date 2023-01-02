package com.msag.securityinfo.gateway.videonews.service;

import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.data.SecurityVideoInfoData;

/**
 * Service to fetch general security information
 */
@FunctionalInterface
public interface VideoNewsService {

    /**
     * Get video news
     *
     * @return SecurityVideoInfoData {@link SecurityVideoInfoData} Result containing details of security info videos
     * @throws VideoNewsException {@link VideoNewsException} Exception during fetch video news
     */
    SecurityVideoInfoData getVideoData() throws VideoNewsException;

}
