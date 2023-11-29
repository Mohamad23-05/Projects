public class Pi {
	// Calculation for PI according to Madhava-Leibniz
	public static double piMadhavaLeibniz(int maxIterations) {
		double piViertel = 0;
		int vorzeichen = 1;

		for (int i = 1; i <= maxIterations * 2; i += 2) {
			piViertel += vorzeichen * (1.0 / i);
			vorzeichen *= -1;
		}

		return 4 * piViertel;
	}

	// Calculation for PI according to Wallis
	public static double piWallis(int maxIterations) {
		double piHalbe = 1;

		int currentIteration = 0;
		int zaehler = 2, nenner = 1;
		while (currentIteration < maxIterations) {
			piHalbe *= (double)zaehler / nenner;

			// Update numerator and demoninator
			if (currentIteration % 2 != 0)
				zaehler += 2;
			else
				nenner += 2;
			currentIteration++;
		}
		return 2 * piHalbe;
	}

	// Calculation for PI according to Newton
	public static double piNewton(int maxIterations) {
		double piAnteilig = 0;

		int currentIteration = 0;
		int zaehler = 1, nenner = 1;
		while (currentIteration < maxIterations) {
			piAnteilig += (double) zaehler / nenner;

			// Update numerator and demoninator
			nenner += 2;
			if (currentIteration % 2 != 0)
				zaehler *= -1;

			currentIteration++;
		}

		return piAnteilig * 2 * Math.sqrt(2);
	}

	// Calculation for PI according to Euler
	public static double piEuler(int maxIterations) {
		double piAnteilig = 0;

		int currentIteration = 0;
		int zaehler = 1, nenner = 1;
		while (currentIteration < maxIterations) {
			piAnteilig += (double) zaehler / nenner;

			// Update numerator and demoninator
			nenner++;
			if (currentIteration % 2 != 0)
				nenner++;
			zaehler *= -1;

			currentIteration++;
		}

		return piAnteilig * 3 * Math.sqrt(3);
	}

	public static double piBailey(int maxIterations) {
		double pi = 0, term;

		int currI = 0;
		while (currI < maxIterations) {
			term = 4.0 / (8 * currI + 1) - 2.0 / (8 * currI + 4) - 1.0
					/ (8 * currI + 5) - 1.0 / (8 * currI + 6);
			pi += 1.0 / Math.pow(16, currI) * term;
			currI++;
		}
		return pi;
	}

	// Checks prefixes of both lists and returns
	// number of matching elements
	private static int countEquals(char[] a, char[] b) {
		int ret=0;
		while (ret<a.length && ret<b.length && (a[ret]==b[ret]))
			ret++;

		return ret;
	}

	// Performs comparison test
	public static void main(String[] args) {
		int[] durchlauf = { 5, 50, 500, 5000, 50000, 500000, 5000000,
				50000000, 500000000 };

		char[] pi_leibniz, pi_biblio, pi_wallis, pi_newton, pi_euler, pi_bailey;

		for (int j = 0; j < durchlauf.length; j++) {
			// Madhava-Leibniz
			long startZeit_Leibniz = System.currentTimeMillis();
			double piLeibniz = piMadhavaLeibniz(durchlauf[j]);
			long stopZeit_Leibniz = System.currentTimeMillis();

			// Wallis
			long startZeit_Wallis = System.currentTimeMillis();
			double piWallis = piWallis(durchlauf[j]);
			long stopZeit_Wallis = System.currentTimeMillis();

			// Newton
			long startZeit_Newton = System.currentTimeMillis();
			double piNewton = piNewton(durchlauf[j]);
			long stopZeit_Newton = System.currentTimeMillis();

			// Euler
			long startZeit_Euler = System.currentTimeMillis();
			double piEuler = piEuler(durchlauf[j]);
			long stopZeit_Euler = System.currentTimeMillis();

			// Bailey
			long startZeit_Bailey = System.currentTimeMillis();
			double piBailey = piBailey(durchlauf[j]);
			long stopZeit_Bailey = System.currentTimeMillis();

			// Conversion from double to char[]
			pi_leibniz = (Double.toString(piLeibniz)).toCharArray();
			pi_biblio = (Double.toString(Math.PI)).toCharArray();
			pi_wallis = (Double.toString(piWallis)).toCharArray();
			pi_newton = (Double.toString(piNewton)).toCharArray();
			pi_euler = (Double.toString(piEuler)).toCharArray();
			pi_bailey = (Double.toString(piBailey)).toCharArray();

			// Comparison of precision between Leibniz and Mathe.PI
			int sumGleich_Leibniz = countEquals(pi_leibniz, pi_biblio);

			// Comparison of precision between Wallis and Mathe.PI
			int sumGleich_Wallis = countEquals(pi_wallis, pi_biblio);

			// Comparison of precision between Newton and Mathe.PI
			int sumGleich_Newton = countEquals(pi_newton, pi_biblio);

			// Comparison of precision between Euler and Mathe.PI
			int sumGleich_Euler = countEquals(pi_euler, pi_biblio);

			// Comparison of precision between Bailey and Mathe.PI
			int sumGleich_Bailey = countEquals(pi_bailey, pi_biblio);

			// The difference tells us how much time
			// the algorithm took for the calculation
			System.out.print("-------------------------------------- ");
			System.out.println("Iterations " + durchlauf[j] + "");

			System.out.println("--- Madhava-Leibniz ---");
			System.out.println("Duration: "
					+ (stopZeit_Leibniz - startZeit_Leibniz));
			System.out.println(Double.toString(Math.PI).subSequence(0,
					sumGleich_Leibniz)
					+ "\n");

			System.out.println("--- Wallis ---");
			System.out.println("Duration: "
					+ (stopZeit_Wallis - startZeit_Wallis));
			System.out.println(Double.toString(Math.PI).subSequence(0,
					sumGleich_Wallis)
					+ "\n");

			System.out.println("--- Newton ---");
			System.out.println("Duration: "
					+ (stopZeit_Newton - startZeit_Newton));
			System.out.println(Double.toString(Math.PI).subSequence(0,
					sumGleich_Newton)
					+ "\n");

			System.out.println("--- Euler ---");
			System.out.println("Duration: "
					+ (stopZeit_Euler - startZeit_Euler));
			System.out.println(Double.toString(Math.PI).subSequence(0,
					sumGleich_Euler)
					+ "\n");

			System.out.println("--- Bailey ---");
			System.out.println("Duration: "
					+ (stopZeit_Bailey - startZeit_Bailey));
			System.out.println(Double.toString(Math.PI).subSequence(0,
					sumGleich_Bailey)
					+ "\n");
		}
	}
}
