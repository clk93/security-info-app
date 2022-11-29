package com.msag.securityinfo.generalnews.service;

import com.msag.securityinfo.generalnews.data.SecurityInfoData;
import com.msag.securityinfo.generalnews.exception.SecurityInfoException;
import org.springframework.stereotype.Service;

@Service
public class GeneralNewServiceImpl implements GeneralNewsService{

    @Override
    public SecurityInfoData getSecurityInfoNews() throws SecurityInfoException {
        return null;
    }
}
