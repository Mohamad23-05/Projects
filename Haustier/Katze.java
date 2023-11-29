public class Katze implements Haustier{
        private String name;
        private int alter;
        
        public Katze(String name, int alter) {
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
            return "Katze";
        }
        public String getTierstimme(){
            return "meow";
        }
    }

