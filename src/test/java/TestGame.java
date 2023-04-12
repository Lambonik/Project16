import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestGame {
    Player player1 = new Player(1, "Петя", 3);
    Player player2 = new Player(2, "Вася", 2);
    Player player3 = new Player(3, "Коля", 2);
    Player player4 = new Player(4, "Андрей", 2);
    Player player5 = new Player(5, "Олег", 2);

    @Test
    public void roundIfPlayerName1Stronger() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Петя", "Вася");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfPlayerName2Stronger() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfDraw() {
        Game game = new Game();

        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Вася", "Коля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getExceptionIfPlayerName1NotRegistered() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Вася");
        });
    }

    @Test
    public void getExceptionIfPlayerName2NotRegistered() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Саша");
        });
    }
}
