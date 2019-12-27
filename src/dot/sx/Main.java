package dot.sx;

import java.util.List;
import java.util.Random;

import javax.swing.SwingUtilities;

/**
 * @author rob3ns
 */
public class Main {

	private static final Double[][] pos = {{0.0, 0.0}, {-1.0, 0.0}, 
			{-1.0, -3.0}, {-1.0, -4.0}, {4.0, -2.0}, {0.0, -2.0}, {0.0, 0.0}};
	
	private static final int maxDots = 4;

	public static void main(String[] args) {

		Random r = new Random();
		Double[][] k = new Double[maxDots][2];
		
		for (int i = 0; i < maxDots; ++i) {
			double x = r.nextInt(800);
			double y = r.nextInt(800);
			k[i][0] = x;
			k[i][1] = y;
		}

		// Option 1
		Double[][] resultMatrix = DotSx.shortestPathMatrix(pos, 0, 6);

		System.out.println("Result matrix");
		for (int i = 0; i < resultMatrix.length; ++i) {
			System.out.println(resultMatrix[i][0] + " : " + resultMatrix[i][1]);
		}

		// Option 2
		List<Double[]> dots = DotSx.shortestPathList(k, r.nextInt(maxDots), r.nextInt(maxDots));
		System.out.println("Drawing canvas");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Draw(dots, maxDots);
			}
		});
		
		
	}
}
