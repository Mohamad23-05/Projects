public class JavaGotchi {
    static enum State{Happy, Hungry, Eating, Starved};
    static State currentState;
    static int hungerLevel;

    static boolean wahrscheinlichkeitInProzent(double prozent){
        return (Math.random() <(prozent/100));
    }
    static void behaviourHangry(){
        System.out.println(":/ .... hungry");
            if(wahrscheinlichkeitInProzent(25))
                currentState = State.Eating;
  
    }
    static void behaviourStarved(){
        System.out.println("x(");
    }

    static void behaviourEating(){
        System.out.println(":# .... eating");
            hungerLevel = 0;
            currentState = State.Happy;

    }
    static void behaviourHappy(){
        System.out.println(":)");
    }
    static void update(){
  
        if(currentState != State.Eating){
            hungerLevel += (int)(Math.random()*5);
            if(hungerLevel >15) currentState = State.Hungry;
            if (hungerLevel >30) currentState = State.Starved;
        }

    }
    static void wait(int ms){
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        } 
    }
    static void startGame(){
        currentState = State.Happy;
        hungerLevel =0;
        boolean isGameRunning = true;
        while(isGameRunning){
            switch(currentState) {
                case Hungry:
                    behaviourHangry();
                    break;
                case Starved:
                    behaviourStarved();
                    isGameRunning = false;
                    break;
                case Eating:
                    behaviourEating();
                    break;
                case Happy:
                    behaviourHappy();
                    break;
            }
            update(); wait(400);

        }
        
    }

    public static void main(String[] args) { startGame();}
    
    
}
