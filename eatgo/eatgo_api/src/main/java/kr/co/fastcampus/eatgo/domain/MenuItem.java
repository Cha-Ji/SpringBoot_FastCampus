package kr.co.fastcampus.eatgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //MenuItem에 대한 repository를 구현하지 않고도 사용할 수 있다.
public class MenuItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    private final String name;

    public MenuItem(String name){
        this.name = name;
    }



    public String getName(){
        return name;
    }
}
