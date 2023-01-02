package com.msag.securityinfo.data;

import com.msag.securityinfo.utils.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryInfo {
    private final Category name;
    private final String iconUrl;
}
