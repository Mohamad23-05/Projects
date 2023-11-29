/* 
 * Teilaufgaben:
 * - Grobarchitektur des Programms festlegen: Interaktion der Funktionen, Austausch der Daten und Programmschleife.
 * 
 *  - Datentyp für die zwei dimensionale Weltmatrix definieren, dabei Lösungen für die Randproblematik finden. 
 * VariableProgrammparameterfestlegen: Weltmatrix größe, Verteilung der lebendigen und toten Zellen in der Startkonfiguration.
 * 
 * - Funktion initWelt implementieren, die eine Welt erzeugt und entsprechend der vorgegebenen Verteilung füllt und zurückgibt.
 * 
 * - Funktion zeigeWelt implementieren, die die aktuelle Welt auf der Konsole ausgibt.
 *
 *  - Funktion wendeRegelnAn implementieren, die eine erhaltene Generationsstufe der Welt nach den Spielregeln in die nächste Generationsstufe über führt und das Resultat zurückgibt
*/

 public class GameOfLife{
    final static int DIM1 = 10;
    final static int DIM2 = 10;

    public static boolean[][] initWelt(){
        boolean[][] welt = new boolean[DIM1][DIM2];
        
        for (int y=1; y<DIM2-1;y++)
            for(int x=1; x<DIM1-1; x++)
                welt[x][y] = Math.random() > 0.4;
        
        return welt;
    }

    public static void zeigeWelt(boolean[][] welt) {
        for (int y = 1; y < DIM2 - 1; y++) {
            for (int x = 1; x < DIM1 - 1; x++) {
                if (welt[x][y])
                    System.out.print("X");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }


public static int anzNachbar(boolean[][] welt, int x, int y) {
    int ret = 0;
    for (int i = x - 1; i <= x + 1; ++i) {
        for (int j = y - 1; j <= y + 1; ++j) {
            if (welt[i][j]) {
                ret += 1;
            }
        }
    }
    if (welt[x][y]) {
        ret -= 1;
    }
    return ret;
}

    public static boolean[][] wendeRegelnAn(boolean[][] welt){
        boolean[][] welt_neu = new boolean[DIM1][DIM2];
        int nachbarn;

        for(int y=1; y<DIM2-1;y++)
            for(int x=1; x<DIM1-1;x++){
                nachbarn = anzNachbar(welt, x, y);
                // this : 
                // welt_neu[x][y] = (welt[x][y] && (nachbarn == 2)) || (nachbarn == 3);
                // or this:
                if(welt[x][y]){
                    if((nachbarn <2) || (nachbarn >3))
                        welt_neu[x][y] = false;
                    if((nachbarn == 2) || (nachbarn ==3))
                        welt_neu[x][y]=true;
                }else{
                    if(nachbarn == 3)
                        welt_neu[x][y] = true;
                }
            }
        return welt_neu;
    }

    public static void main(String[] args){
        boolean[][] welt = initWelt();

        System.out.println("Startkonstellation");
        zeigeWelt(welt);

        for (int i = 0; i <=10; i++){
            welt = wendeRegelnAn(welt);
            System.out.println("Genration" + i);
            zeigeWelt(welt);
        }
    }
 }