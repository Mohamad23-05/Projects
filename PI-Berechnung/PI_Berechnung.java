public class PI_Berechnung {
    public static double piMadhavaLeibniz(int maxIterations) {
		double piViertel = 0;
		int vorzeichen = 1;

		for (int i = 1; i <= maxIterations * 2; i += 2) {
			piViertel += vorzeichen * (1.0 / i);
			vorzeichen *= -1;
		}

		return 4 * piViertel;
	}

    public static double wallis(int num){
        double term =1;

        for(int i = 1; i < num; i++){
            term *= (4 * Math.pow(i, 2))/ ( ((2*i)-1) * ((2*i)+1) );
            
            System.out.printf("%f\n",term);

        }
        return term;
    }

    public static double piNewton(int n) {
        double result = 0.0;
        
        for (int i = 0; i < n; i++) {
            double term = 1.0 / ((2 * i) + 1);
            
            if (i % 4 <= 1) {
                result += term;
                System.out.println(result);
                
            } else {
                result -= term;
                System.out.println(result);
            }
        }
        
        return result;
    }
    
    public static double piEuler(int num) {
        double result = 0;
        int currentIteration = 0;
        int zaehler = 1, nenner = 1;

        while (currentIteration < num) {
            result += (double) zaehler / nenner;
            
            nenner++;
            if(currentIteration % 2!=0){
                nenner++;
            }
            zaehler *= -1;
            currentIteration++;
        }
        return result*3*Math.sqrt(3);
    }
    
    

    public static void main(String[] args){

        // double res = wallis(100);
        // double pi = res * 2;
        
        // System.out.printf("π = %g\n", pi);

        // double res = piNewton(1000);
        // res = 2 * Math.sqrt(2)*res;
        // System.out.printf("%g\n", res);

        double res = piEuler(1000);
        System.out.printf("%g\n",res);
    }
}
