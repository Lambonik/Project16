import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    private HashMap<String, Player> addPlayer(Player player) {
        players.put(player.name, player);
        return players;
    }

    public void register(Player player) {
        players = addPlayer(player);
    }

    public Player findByName(String playerName) {
        for (String key : players.keySet()) {
            Player value = players.get(key);
            if (value.name == playerName) {
                return players.get(key);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player with name: " + playerName1 + " not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player with name: " + playerName2 + " not registered");
        }
        Player roundPlayer1 = findByName(playerName1);
        Player roundPlayer2 = findByName(playerName2);

        if (roundPlayer1.strength > roundPlayer2.strength) {
            return 1;
        } else if (roundPlayer1.strength < roundPlayer2.strength) {
            return 2;
        } else {
            return 0;
        }
    }
}
