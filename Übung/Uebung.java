public class Vektoren {
    public static int[] addVektoren(int[] a, int[] b) {
        if (a.length != b.length)
            return null;

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++)
            res[i] = a[i] + b[i];
        return res;
    }

    public static void zeigeVektor(int[] a) {
        if( a == null) {
            System.out.println("Vektor ist leer");
            return;
        }
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6};

        zeigeVektor(a);
        zeigeVektor(b);

        int[] c = addVektoren(a, b);
        zeigeVektor(c);
        System.out.println("================\n");
        int[] d = {1,2,3};
        int[] e = {4,5};

        zeigeVektor(d);
        zeigeVektor(e);

        int[] f = addVektoren(d, e);
        zeigeVektor(f);
        
    }
}