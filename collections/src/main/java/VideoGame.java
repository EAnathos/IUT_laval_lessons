import java.io.Serializable;
import java.util.Comparator;

// A Class made for store information about video games.
public class VideoGame implements Serializable {
    private final String name;
    private final String gender;
    private final String editor;
    private final int year;
    private final int grade;

    static public Comparator<VideoGame> compareName = (jv1, jv2) -> jv1.name.compareToIgnoreCase(jv2.name);
    static public Comparator<VideoGame> compareGender = (jv1, jv2) -> jv1.gender.compareToIgnoreCase(jv2.gender);
    static public Comparator<VideoGame> compareEditor = (jv1, jv2) -> jv1.editor.compareToIgnoreCase(jv2.editor);

    // A constructor to give an init value at the creation.
    VideoGame(String s, String g, String e, int a, int n)
    {
        this.name=s;
        this.gender=g;
        this.editor=e;
        this.year=a;
        this.grade=n;

    }

    // Usefully function to show information about the game.
    public String toString()
    {
        return ("Game : "+name+" ; Gender : "+gender+" ("+editor+", "+year+")"+" : "+grade);
    }

}
