import java.util.Comparator;

// classe pour stocker les informations sur un jeu vid�o
public class JeuVideo {
    private String nom;
    private String genre;
    private String editeur;
    private int annee;
    private int note;

    static public Comparator<JeuVideo> compareNom = new Comparator <JeuVideo>() {

        public int compare(JeuVideo jv1, JeuVideo jv2) {

            return jv1.nom.compareToIgnoreCase(jv2.nom);

        }
    };

    // ++++++++++++++++++++++++++++++++++++++
    // d'autres comparateurs seront cr��s ici
    // ++++++++++++++++++++++++++++++++++++++

    // un constructeur pour donner une valeur � chaque attribut de la classe
    JeuVideo(String s, String g, String e, int a, int n)
    {
        nom=s;
        genre=g;
        editeur=e;
        annee=a;
        note=n;

    }

    // fonction utile pour l'affichage
    public String toString()
    {
        return ("Jeu : "+nom+" ; Genre : "+genre+" ("+editeur+", "+annee+")"+" : "+note);
    }


}
