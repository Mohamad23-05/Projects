public class HaustierHaushalt {
    public static void main(String[] args) {
        Haustierhalter heinz = new Haustierhalter();      
        Hund rambo = new Hund("Rambo", 3);
        Hund fifi = new Hund("fifi", 2);
        Katze lolo = new Katze("lolo", 3);
        heinz.neuesHaustier(rambo);
        System.out.println("Haustier von Heinz: " + heinz.getHaustierBezeichnung());
        heinz.neuesHaustier(fifi);
        System.out.println("Haustier von Heinz: " + heinz.getHaustierBezeichnung());
         heinz.neuesHaustier(lolo);
        System.out.println("Haustier von Heinz: " + heinz.getHaustierBezeichnung());
        heinz.abgabeHaustier(rambo);
        System.out.println("Haustier von Heinz: " + heinz.getHaustierBezeichnung());

    }
}
