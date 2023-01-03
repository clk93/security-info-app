package com.msag.securityinfo.app.utils;

import com.msag.securityinfo.common.exception.UnknownCategoryException;

import java.util.Arrays;

public enum Category {
    VIDEO ("Video"),
    GENERAL("Allgemein"),
    PHISHING("Phishing"),
    PASSWORDS("Passwörter"),
    CLOUD("Cloud"),
    RANSOMWARE("Ransomware"),
    PRESIDENT_SCAM("President Scam"),
    PRIVATE_IT("Private IT"),
    EMERGENCY("Notfall"),
    MOBILE_DEVICES ("Mobile Geräte");

    public final String label;

    Category(final String label) {
        this.label = label;
    }

    public static Category getCategory(final String label) throws UnknownCategoryException{
        return Arrays.stream(Category.values())
                .filter(currentCategory -> currentCategory.label.equals(label))
                .findAny()
                .orElseThrow(() -> new UnknownCategoryException("Category by name is not known " + label));
    }

}
