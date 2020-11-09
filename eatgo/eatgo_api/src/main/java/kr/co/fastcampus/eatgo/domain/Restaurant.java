package kr.co.fastcampus.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue //아이디에 어떤 값이 들어가야 하는가
    @Setter
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

//    private String regionName;
//    private String categoryName;
//    private String tagNames;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public String getInformation() {
        return name + " in " + address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

