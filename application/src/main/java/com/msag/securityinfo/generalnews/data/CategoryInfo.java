package com.msag.securityinfo.generalnews.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryInfo {
    private final CategoryEnum category;
    private final String iconUrl;
}
