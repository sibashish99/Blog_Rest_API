package com.blog.proj.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CatagoryDto {
	 private Integer categoryId;
	 private String categoryTitle;
	 private String categoryDescription;
}
