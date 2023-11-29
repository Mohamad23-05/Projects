import java.util.List;
import java.util.ArrayList;

public class Haustierhalter {
    public List<Haustier> meinHaustier;

    public Haustierhalter() {
        meinHaustier = new ArrayList<Haustier>();
    }
    public void neuesHaustier(Haustier haustier) {
        meinHaustier.add(haustier);
    }
    public void abgabeHaustier(Haustier haustier) {
        meinHaustier.remove(haustier);
    }
    public String getHaustierBezeichnung(){
        StringBuilder sb = new StringBuilder();
        for(Haustier haustier : meinHaustier){
            sb.append(haustier.getBezeichnung()).append(" ,");
        }
        return sb.toString();
    }
    
}
