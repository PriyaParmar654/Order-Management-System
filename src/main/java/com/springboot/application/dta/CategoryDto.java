package com.springboot.application.dta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    String name;
    String details;
    public String getName() {
        return name;
    }




}
