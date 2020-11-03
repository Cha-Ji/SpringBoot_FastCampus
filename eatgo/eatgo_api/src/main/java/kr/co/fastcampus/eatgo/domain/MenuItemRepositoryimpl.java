package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryimpl implements MenuItemRepository{
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepositoryimpl(){
        menuItems.add(new MenuItem("Kimchi"));
    }
    @Override
    public List<MenuItem> findAllByRestaurantId(Long restaurantId){
        return menuItems;
    }
}
