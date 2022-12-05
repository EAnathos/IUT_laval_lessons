import java.util.Comparator;

// A Class made for store information about video games.
public class VideoGame {
    private final String name;
    private final String gender;
    private final String editor;
    private final int year;
    private final int grade;

    static public Comparator<VideoGame> compareName = new Comparator <VideoGame>() {

        public int compare(VideoGame jv1, VideoGame jv2) {

            return jv1.name.compareToIgnoreCase(jv2.name);

        }
    };

    // ++++++++++++++++++++++++++++++++++++++
    // other comparators are created here
    // ++++++++++++++++++++++++++++++++++++++

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
