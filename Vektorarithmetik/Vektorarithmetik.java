public class Vektorarithmetik {
    public static boolean[][] falsiereSahllowCopy(boolean[][] l) {
        boolean[][] kopie = l.clone();
        for(boolean[] d1 : kopie)
            for (int j=0; j<d1.length; j++)  
                    d1[i] = false;
                return kopie;
    }
    public static boolean[][] falsiereDeepCopy(boolean[][] l) {
        boolean[][] kopie = l.clone();
        for(int i = 0; i < kopie.length; i++)
            kopie[i] = l[i].clone();
                for (int j=0; j<d1.length; j++)  
                    d1[i][j] = false;
                return kopie;
    }
    public static void voruebungen(){
        boolean[][] a = {{true},{true,false},{false,false}};
        boolean[][] b = falsiere(a);
        boolean c = a == b;
         b[2][1] = true;
           b[1] = a[0];
        boolean d = a[0][0] == b[0][0];
        boolean e = a[2][1] != b[2][1];
           a[0][0] = true;
        boolean f = b[1][0] != b[2][0];
        // System.out.printf("%b\n",a);
        // System.out.printf("%b\n",b);
        System.out.printf("%b\n",c);
        System.out.printf("%b\n",d);
        System.out.printf("%b\n",d);
        System.out.printf("%b\n",e);
        System.out.printf("%b\n",f);
    }
    
    public static void main(String[] args) {
        // voruebungen();

    }
}
