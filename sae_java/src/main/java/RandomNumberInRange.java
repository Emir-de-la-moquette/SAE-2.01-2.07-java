public class RandomNumberInRange {
	public static double getRandom(double min, double max) {

		double range = (max - min);
     		double random = ((range * Math.random()) + min);
		return random;
	}

	public static int getRandomInt(int min, int max) {
		int randomInt = (int)Math.round(getRandom(min, max)+0.01);
		return randomInt;
	}
}