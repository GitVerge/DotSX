package dot.sx;

import java.util.List;

/**
 * @author rob3ns
 */
public class Main {

	private static final Double[][] pos = {{0.0, 0.0}, {-1.0, 0.0}, 
			{-1.0, -3.0}, {-1.0, -4.0}, {4.0, -2.0}, {0.0, -2.0}, {0.0, 0.0}};

	public static void main(String[] args) {

		// Option 1
		Double[][] resultMatrix = DotSx.shortestPathMatrix(pos, 0, 6);

		System.out.println("Result matrix");
		for (int i = 0; i < resultMatrix.length; ++i) {
			System.out.println(resultMatrix[i][0] + " : " + resultMatrix[i][1]);
		}

		// Option 2
		List<Double[]> resultList = DotSx.shortestPathList(pos, 0, 6);

		System.out.println("Result list");
		for (Double[] value : resultList) {
			System.out.println(value[0] + " : " + value[1]);
		}
	}
}
