package com.wannistudio.spingmvcpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private Integer id;
    @NotBlank
    private String name;
    @Min(value = 0)
    private Integer limit;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate startDate;
}
