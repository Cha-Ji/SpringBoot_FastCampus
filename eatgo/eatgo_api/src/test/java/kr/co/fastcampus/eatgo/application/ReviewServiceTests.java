package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Review;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewServiceTests {

    private ReviewServiceTests reviewService;

    @Before
    public void setUp(){
        reviewService

    }




    @Test
    public void addReview(){

        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da");

        reviewService.addReview(review);
    }

}