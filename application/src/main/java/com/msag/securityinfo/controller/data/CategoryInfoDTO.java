package com.msag.securityinfo.controller.data;

import com.msag.securityinfo.generalnews.data.CategoryEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryInfoDTO {
    private final CategoryEnum category;
    private final String iconUrl;
}
