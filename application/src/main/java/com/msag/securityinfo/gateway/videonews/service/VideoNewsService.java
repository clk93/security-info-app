package com.msag.securityinfo.gateway.videonews.service;

import com.msag.securityinfo.common.exception.VideoNewsException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;

/**
 * Service to fetch general security informations
 */
@FunctionalInterface
public interface VideoNewsService {

    /**
     * Get video news
     *
     * @return SecurityInfoData {@link SecurityInfoData} Result containing details of security info
     * @throws VideoNewsException {@link VideoNewsException} Exception during fetch video news
     */
    SecurityInfoData getVideoNews() throws VideoNewsException;

}
