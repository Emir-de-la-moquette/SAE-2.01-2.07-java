public class RandomNumberInRange {
	public static double getRandom(double min, double max) {

		double range = (max - min);
     		double random = ((range * Math.random()) + min);
		return random;
	}
}