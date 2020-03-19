package br.com.mxel.snakegame;

import org.junit.Before;
import org.junit.Test;

import br.com.mxel.snakegame.model.Snake;

import static org.junit.Assert.assertEquals;

public class SnakeTest {

    Snake snake;

    @Before
    public void setup() {
        snake = new Snake(10, 10, Snake.Direction.RIGHT);
    }

    @Test
    public void changeDirectionTest() {

        // should keep previews direction because left is opposite from right
        snake.setCurrentDirection(Snake.Direction.LEFT);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.RIGHT);

        // should change direction
        snake.setCurrentDirection(Snake.Direction.DOWN);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.DOWN);

        // shouldn't change direction
        snake.setCurrentDirection(Snake.Direction.UP);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.DOWN);

        // should change direction
        snake.setCurrentDirection(Snake.Direction.LEFT);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.LEFT);

        // shouldn't change direction
        snake.setCurrentDirection(Snake.Direction.RIGHT);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.LEFT);

        // should change direction
        snake.setCurrentDirection(Snake.Direction.UP);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.UP);

        // shouldn't change direction
        snake.setCurrentDirection(Snake.Direction.DOWN);
        assertEquals(snake.getCurrentDirection(), Snake.Direction.UP);
    }

    @Test
    public void directionTest() {

        snake.increaseSize();

        snake.moveSnake();
        assertEquals(snake.getHeadX(), 11);
        assertEquals(snake.getHeadY(), 10);

        snake.setCurrentDirection(Snake.Direction.DOWN);
        snake.moveSnake();
        assertEquals(snake.getHeadX(), 11);
        assertEquals(snake.getHeadY(), 11);

        snake.setCurrentDirection(Snake.Direction.LEFT);
        snake.moveSnake();
        assertEquals(snake.getHeadX(), 10);
        assertEquals(snake.getHeadY(), 11);

        snake.setCurrentDirection(Snake.Direction.UP);
        snake.moveSnake();
        assertEquals(snake.getHeadX(), 10);
        assertEquals(snake.getHeadY(), 10);
    }
}
