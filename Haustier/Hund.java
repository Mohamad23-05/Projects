public class Hund implements Haustier {
    private String name;
    private int alter;
    
    public Hund(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
    public String getName() {
        return name;
    }
    public int getAlter() {
        return alter;
    }
    public String getBezeichnung(){
        return "Hund";
    }
    public String getTierstimme(){
        return "wuff";
    }
}
