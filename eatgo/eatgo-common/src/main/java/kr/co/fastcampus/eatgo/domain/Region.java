package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue
    private String name;

}
