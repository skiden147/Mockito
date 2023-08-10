package ru.netology.javaqa.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void noMoviesAdded() {
        MovieManager manager = new MovieManager();

        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneMovieAdded() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Film1");

        String[] actual = manager.findAll();
        String[] expected = {"Film1"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void threeMoviesAdded() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");

        String[] actual = manager.findAll();
        String[] expected = {"Film1", "Film2", "Film3"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnLastFiveMovies() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");

        manager.findLast();

        String[] actual = manager.findLast();
        String[] expected = {"Film7", "Film6", "Film5", "Film4", "Film3"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnLastSevenMovies() {
        MovieManager manager = new MovieManager(7);

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");
        manager.addMovie("Film8");
        manager.addMovie("Film9");
        manager.findLast();

        String[] actual = manager.findLast();
        String[] expected = {"Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnLastThreeMovies() {
        MovieManager manager = new MovieManager(3);

        manager.addMovie("Film1");
        manager.addMovie("Film2");


        manager.findLast();

        String[] actual = manager.findLast();
        String[] expected = {"Film2", "Film1"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void returnNoLastMovies() {
        MovieManager manager = new MovieManager(15);

        manager.findLast();

        String[] actual = manager.findLast();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
