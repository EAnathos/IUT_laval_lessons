import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Ludotheque {
    public static void main(String[] args) {
        List<VideoGame> gameList = new LinkedList<>();
        gameList.add(new VideoGame("Pacman", "Action/reflexion", "Atari Corporation", 1982, 18));
        gameList.add(new VideoGame("Tetris", "Puzzle", "Nintendo", 1984, 20));
        gameList.add(new VideoGame("2048", "Puzzle", "SoleBon LLC", 2014, 15));

        gameList.sort(VideoGame.compareName);

        gameList.forEach(System.out::println);

        try {
            FileOutputStream fileOut = new FileOutputStream("test.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameList);
            out.close();
            fileOut.close();
            System.out.println("\nsuccess...\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
