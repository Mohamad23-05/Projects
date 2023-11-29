// Transformation der Prädikate und Beispiele aus der Vorlesung Haore-Kalkül
// aus Programmierung III in Java-Assertions
// November 2021, Dustin Heyer, Marco Block-Berlitz


import java.util.Arrays;

public class HoareKalkuel {
   // Beispiel 1 aus der Vorlesung, Ermittlung des Restes der Ganzzahldivision
   public static int rest(int x, int y) {       
      assert (x>=0 && y>0);                     // {P}
      assert (x==0*y+x && x>=0);
      int q = 0;
      assert (x==q*y+x && x>=0);  
      int r = x;
      assert (x==q*y+r && r>=0);                // {I}
      while (r >= y) {
         assert (x==q*y+r && r>=0 && r>=y);     // {I && B}
         assert (x==(q+1)*y+r-y && r-y>=0);
         r = r - y;
         assert (x==(q+1)*y+r && r>=0);
         q = q + 1;
         assert (x==q*y+r && r>=0);             // {I}
      }
      assert (x==q*y+r && r>=0 && !(r>=y));     // {I && !B}
      assert (x==q*y+r && r>=0 && r<y);         // {Q}
      return r;
   }

   // Beispiel 2 aus der Vorlesung, Bilden des Quadrats aus einer Zahl
   public static int quad(int n) {                          
      assert (n>=0);                                        // {P}
      assert (-1==(0*2-1) && 0==(0*0) && 0<=n);
      int i = 0;
      assert (-1==(i*2-1) && 0==(i*i) && i<=n);
      int k = -1;
      assert (k==(i*2-1) && 0==(i*i) && i<=n);
      int y = 0;
      assert (k==(i*2-1) && y==(i*i) && i<=n);              // {I}
      while (i < n) {
         assert (k==(i*2-1) && y==(i*i) && i<=n && i<n);    // {I && B}
         assert (k+2==((i+1)*2-1) && y+k+2==((i+1)*(i+1)) && (i+1)<=n);
         i = i + 1;
         assert (k+2==(i*2-1) && y+k+2==(i*i) && i<=n);
         k = k + 2;
         assert (k==(i*2-1) && y+k==(i*i) && i<=n);
         y = y + k;
         assert (k==(i*2-1) && y==(i*i) && i<=n);           // {I}
      }
      assert (k==(i*2-1) && y==(i*i) && i<=n && !(i<n));    // {I && !B}
      assert (y==Math.pow(n, 2));                           // {Q}
      return y;
   }

   // Beispiel 3 aus der Vorlesung, Potenzieren mit Basis und Exponent
   public static int exp(int x, int n) { 
      assert (n>=0);                                                       // {P}
      assert (Math.pow(x, n)==(1*(Math.pow(x, n))) && n>=0);
      int k = n;
      assert (Math.pow(x, n)==(1*(Math.pow(x, k))) && k>=0);
      int p = x;
      assert (Math.pow(x, n)==(1*(Math.pow(p, k))) && k>=0);
      int y = 1;
      assert (Math.pow(x, n)==(y*(Math.pow(p, k))) && k>=0);               // {I}
      while (k > 0) {
         assert (Math.pow(x, n)==(y*(Math.pow(p, k))) && k>=0 && k>0);     // {I && B}
         if (k % 2 == 0) {
            assert (Math.pow(x, n)==(y*(Math.pow(p*p, (k/2)))) && k/2>=0 && k%2==0); // Fall 1
            p = p * p;
            assert (Math.pow(x, n)==(y*(Math.pow(p, (k/2)))) && k/2>=0);
            k = k / 2;
         } else {
            assert (Math.pow(x, n)==(y*p*(Math.pow(p, k-1))) && k-1>=0 && k%2!=0);   // Fall 2
            y = y * p;
            assert (Math.pow(x, n)==(y*(Math.pow(p, k-1))) && k-1>=0);
            k = k - 1;
         }
         assert (Math.pow(x, n)==(y*(Math.pow(p, k))) && k>=0);            // {I}
      }
      assert (Math.pow(x, n)==(y*(Math.pow(p, k))) && k>=0 && !(k>0));     // {I && !B}
      assert (y==Math.pow(x, n));                                          // {Q}
      return y;
   }

   // Beispiel 4 aus der Vorlesung, Vertauschen zweier Variablen
   public static void swap(int x, int y) { 
      int A=x, B=y;
      assert (x==A && y==B);  // {P}
      assert ((x+y)-((x+y)-y)==B && (x+y)-y==A);
      x = x + y;
      assert (x-(x-y)==B && x-y==A);
      y = x - y;
      assert (x-y==B && y==A);
      x = x - y;
      assert (x==B && y==A);  // {Q}
   }  
      
   // Hilfsmethoden für lineare Suche
   private static boolean contains(final int[] arr, final int key) {
      return Arrays.stream(arr).anyMatch(i->i==key);
   }

   private static boolean partCheck(final int[] arr, int c, final int key) {
      int[] a = new int[arr.length - c];
      for (int j = 0; c < arr.length; c++, j++) 
         a[j] = arr[c];
      return contains(a, key);
   }

   // Beispiel 5 aus der Vorlesung, Lineare Suche
   public static int linearSearch(int x, int[] elems) { 
      assert (contains(elems, x));                          // {P}
      assert (partCheck(elems, 0, x));
      int i = 0;
      assert (partCheck(elems, i, x));                      // {I}
      while (elems[i] != x) {
         assert (partCheck(elems, i, x) && elems[i]!=x);    // {I && B}
         assert (partCheck(elems, i+1, x));
         i = i + 1;
         assert (partCheck(elems, i, x));                   // {I}
      }
      assert (elems[i]==x && !(elems[i]!=x));               // {I && !B}
      assert (elems[i]==x);                                 // {Q}
      return i;
   }

   // Beispiel 5 aus der Vorlesung, Bilden einer Summe
   public static int sum(int n) { 
      assert (n>=1);                               // {P}
      assert (0==(1*(1-1)/2));
      int i = 1;
      assert (0==(i*(i-1)/2));
      int sum = 0;
      assert (sum==(i*(i-1)/2));                   // {I}
      while (i<=n) {
         assert (sum==(i*(i-1)/2) && i<=n);        // {I && B}
         assert (sum+i==((i+1)*((i+1)-1)/2));
         sum = sum + i;
         assert (sum==((i+1)*((i+1)-1)/2));
         i = i + 1;
         assert (sum==(i*(i-1)/2));                // {I}
      }
      assert (sum==(i*(i-1)/2) && !(i<=n));        // {I && !B}
      assert (sum==(i*(i-1)/2));                   // {Q}
      return sum;
   }

   public static void main(String[] args) {
      System.out.println("Beispiel 1: " + rest(4, 2));
      System.out.println("Beispiel 2: " + quad(4));
      System.out.println("Beispiel 3: " + exp(4, 1));
      
      // Kurze Frage: Warum klappt dieses Beispiel nicht?
      System.out.println("Beispiel 4: ");
      int x=4, y=2;
      swap(x, y);
      System.out.println("x="+x+", y="+y);
      // Wenn die Antwort "Call-by-Value" beinhaltet, 
      // könnte sie korrekt sein :)
             
      int[] arr = {1, 2, 3, 4, 5, 6, 67, 42, 23, 234, 99};
      System.out.println("Beispiel 5: " + linearSearch(4, arr));
      
      System.out.println("Beispiel 6: " + sum(1));
   }
}