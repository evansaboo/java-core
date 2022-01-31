import java.util.*; // Scanner, Locale

class Temperaturer
{
	public static void main (String[] args)
	{
	System.out.println ("TEMPERATURER\n");

	// inmatningsverktyg
	Scanner in = new Scanner (System.in);
	in.useLocale (Locale.US);

	// mata in uppgifter om antalet veckor och antalet m�tningar
	System.out.print ("antalet veckor: ");
	int antalVeckor = in.nextInt ();
	System.out.print ("antalet m�tningar per vecka: ");
	int antalMatningarPerVecka = in.nextInt ();

	// plats att lagra temperaturer
	double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

	// mata in temperaturerna
	for (int vecka = 1; vecka <= antalVeckor; vecka++)
	{
		System.out.println ("temperaturer - vecka " + vecka + ":");
		for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			t[vecka][matning] = in.nextDouble ();
	}

	System.out.println ();

	// visa temperaturerna
	System.out.println ("temperaturerna:");
	for (int vecka = 1; vecka <= antalVeckor; vecka++)
	{
		for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			System.out.print (t[vecka][matning] + " ");
		System.out.println ();
	}
	System.out.println ();

	// den minsta, den st�rsta och medeltemperaturen � veckovis
	double[] minT = new double[antalVeckor + 1];
	double[] maxT = new double[antalVeckor + 1];
	double[] sumT = new double[antalVeckor + 1];
	double[] medelT = new double[antalVeckor + 1];

	// visa den minsta, den st�rsta och medeltemperaturen f�r varje vecka
	// koden ska skrivas h�r


	for (int vecka = 1; vecka <= antalVeckor; vecka++)
	{
	sumT[vecka] = t[vecka][1];
	minT[vecka] = t[vecka][1]; // f�rsta tempraturen f�r varje vecka
	maxT[vecka] = t[vecka][1]; // f�rsta tempraturen f�r varje vecka

	for (int inmatning = 2; inmatning <= antalMatningarPerVecka; inmatning++)
	{

	double summa = t[vecka][inmatning];
	double min = t[vecka][inmatning];
	double max = t[vecka][inmatning];

	sumT[vecka] += summa; // summan av alla tempraturer veckovis

	if(min < minT[vecka])
	minT[vecka] = min;
	if(max > maxT[vecka])
	maxT[vecka] = max;

	medelT[vecka] = sumT[vecka] / antalMatningarPerVecka; // f� ut medelv�rdet av tempraturer f�r varje vecka
	}

	System.out.println("Minsta temperaturen for vecka " + vecka + " ar: " + minT[vecka]);
	System.out.println("Hosta temperaturen for vecka " + vecka + " ar: " + maxT[vecka]);
	System.out.println("Summan for vecka "+ vecka + " ar: "+ sumT[vecka]);
	System.out.println("Medelvardet for vecka "+ vecka + " ar: "+ medelT[vecka]);
	System.out.println("------------------");
	}

	// den minsta, den st�rsta och medeltemperaturen - hela m�tperioden
	// koden ska skrivas h�r
	double minTemp = minT[1];
	double maxTemp = maxT[1];
	double sumTemp = sumT[1];
	double medelTemp = 0;



	for (int vecka = 2; vecka <= antalVeckor; vecka++)
	{
	sumTemp += sumT[vecka]; // summan av alla veckotemprraturer

	if(minT[vecka] < minTemp)
	minTemp = minT[vecka];
	if(maxT[vecka] > maxTemp)
	maxTemp = maxT[vecka];
	}
	medelTemp = sumTemp / (antalMatningarPerVecka * antalVeckor); // Medelv�rdet av alla tepmraturer


	System.out.println("Minsta Tempraturen for alla veckor ar: " +  minTemp);
	System.out.println("Hogsta Tempraturen for alla veckor ar: " +  maxTemp);
	System.out.println("Summan av alla temperaturer blir " + sumTemp);
	System.out.println("Totala medelvardet for alla veckor ar: " +  medelTemp);


	}
}
