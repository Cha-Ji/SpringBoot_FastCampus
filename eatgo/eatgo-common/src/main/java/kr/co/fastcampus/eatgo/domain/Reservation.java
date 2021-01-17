package kr.co.fastcampus.eatgo.domain;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    private Long userId;

    @Setter
    private String name;

    @NotEmpty
    private String date;

    @NotEmpty
    @Setter
    private String time;

    @NotNull
    @Setter
    @Min(1)
    private Integer partySize;
}
