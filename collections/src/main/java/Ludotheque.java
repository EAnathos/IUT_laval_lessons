import java.util.LinkedList;
import java.util.List;

public class Ludotheque {
    public static void main(String[] args) {
        List<VideoGame> gameList = new LinkedList<VideoGame>();
        gameList.add(new VideoGame("Pacman", "Action/reflexion", "Atari Corporation", 1982, 18));
        gameList.add(new VideoGame("Tetris", "Puzzle", "Nintendo", 1984, 20));
        gameList.add(new VideoGame("2048", "Puzzle", "SoleBon LLC", 2014, 15));

        gameList.sort(VideoGame.compareName);
        System.out.println(gameList);
    }
}
