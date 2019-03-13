import java.util.Random;
public class Driver{
	public static void fillRandom(int[] data){
	    Random r = new Random();
	    int index = 0;
	    for(int i = 0; i < data.length; i++){
	      data[i] =  i; //r.nextInt(data.length); fills with random numbers
	    }
	    for (int i = 0; i < data.length; i++){
	      int copy = data[i];
	      int rand = r.nextInt(data.length);
	      data[i] = data[rand];
	      data[rand] = copy;
	    }
	 }
	public static void printArray(int[] data){
		String out = "[";
		for(int i : data){
			out+=i;
			if (i != data[data.length-1]){
				out+=", ";
			}
		}
		System.out.println(out+"]");
	}
	public static void main(String[] args){
		Random r = new Random(); int sucesses = 0;
		int tests = 401; //System.out.println("testing array sizes 1-400 having numbers from 0-n, asking for a random smallest int. (arrays do not contain duplicates)");
		for (int i = 1; i < tests; i++){
			int[] data = new int[i];
			int select = i <= 1 ? 0 : r.nextInt(i);
			fillRandom(data);
			//printArray(data);                                            |
			int result = Quick.quickselect(data, select); //sucess message V
			if (result == select) {++sucesses;}//System.out.println("your array of size "+i+" sucessfully found the "+select+"th smallest one"); ++sucesses;}
			else {
				if (data.length < 40) {System.out.print("final Array: "); printArray(data);System.out.println();}
				System.out.println("Uh Oh, your array of size "+i+" DID NOT find the "+select+"th smallest one. It returned " + result +" instead of " + select);
			}
		}
	//	System.out.println("******************************************");
	//	System.out.println("***testing with duplicates in the array***");
		tests++; int[] data = new int[10000];
		for (int i = 0; i < 100; i++){data[i] = r.nextInt(1);} Quick.quickselect(data,500); Quick.quickselect(data,99);
		if (Quick.quickselect(data,0) == 0){++sucesses;} //chance of this driver failing here ;)
		else {System.out.println("uh oh a large array of ones and zeros did not work");}
//		System.out.println("******************************************");

		System.out.println("You have had " + sucesses + " sucesses and " + (tests-sucesses-1) + " failures.");
		System.out.println( (sucesses == tests-1 ? "CONGRATULATIONS!!!" : "Uh Oh")+" Thats " + (sucesses / (tests-1.0)) * 100 + "% sucess rate.");
		if (sucesses <= tests-100) {System.out.println("Yikes!!! Maybe he won't test some of those cases right?");}
		else if (sucesses < tests-1) {System.out.println("Maybe if you compile and run again it will work.");}
  	}
}
