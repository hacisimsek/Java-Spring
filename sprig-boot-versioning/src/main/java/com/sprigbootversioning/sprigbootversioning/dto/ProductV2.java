package com.sprigbootversioning.sprigbootversioning.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductV2 {
    private String name;
    private BigDecimal price;
}
