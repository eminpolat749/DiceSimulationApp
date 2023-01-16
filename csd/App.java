package csd;

class App {
	public static void main(String [] args)
	{
		DiceSimulationApp.run();
	}
}

class DiceSimulationApp {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		DiceSimulation ds = new DiceSimulation();
		
		for (;;) {
			System.out.print("Kaç kez zar atmak istersiniz:");
			int val = Integer.parseInt(kb.nextLine());
			
			if (val <= 0)
				break;
			
			ds.run(val);
			System.out.printf("Çift gelme olasılığı:%f%n", ds.p);
		}		
	}
}

class DiceSimulation {
	public double p;
	
	public static int getSameCount(int count)
	{
		java.util.Random r = new java.util.Random();
		int diceCount = 0;
		
		for (int i = 0; i < count; ++i)
			if (areSame(r))
				++diceCount;
		
		return diceCount;
	}
	
	public static boolean areSame(java.util.Random r)
	{
		return r.nextInt(1, 7) == r.nextInt(1, 7);
	}
	
	public void run(int count)
	{
		p = getSameCount(count) / (double)count;
	}
}