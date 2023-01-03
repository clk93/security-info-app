package com.msag.securityinfo.app.data;

import com.msag.securityinfo.app.utils.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryInfo {
    private final Category name;
    private final String iconUrl;
}
