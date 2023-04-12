import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    private ArrayList<Player> addPlayer(Player player) {
        players.add(player);
        return players;
    }

    public void register(Player player) {
        players = addPlayer(player);
    }

    public Player findByName(String playerName) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name == playerName) {
                return players.get(i);
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
