package com.msag.securityinfo.controller.service;

import com.msag.securityinfo.common.exception.SecurityInfoException;
import com.msag.securityinfo.controller.data.internal.SecurityInfoData;

/**
 * Service to get all relevant information for securityInfo
 */
@FunctionalInterface
public interface SecurityInfoService {

    /**
     * Get all data for security info
     *
     * @return {@link SecurityInfoData} Data containing security info
     * @throws SecurityInfoException Exception during get security info data {@link SecurityInfoException}
     */
    SecurityInfoData getSecurityInfoNews() throws SecurityInfoException;
}
