package com.wannistudio.spingmvcpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Integer id;
    @NotBlank
    private String name;
    @Min(value = 0)
    private Integer limit;
}
