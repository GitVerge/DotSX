package dot.sx;

import java.util.ArrayList;
import java.util.List;

import dot.sx.tools.DotMgr;
import dot.sx.tools.LineMgr;
import utils.Log;

/**
 * @author rob3ns
 */
public class Main {

	public static void main(String[] args) {

		List<Dot> dots = new ArrayList<Dot>();
		
		Integer[] xs = {0, -1, -1, -1, 4, 0 ,0};
		Integer[] ys = {0, 0, -3, -4, -2, -2, 0};
		
		for (int i = 0; i < xs.length; ++i) {
			dots.add(new Dot(xs[i], ys[i]));
		}
		
		DotMgr.setFirstDot(dots, 0);
		DotMgr.setLastDot(dots, 6);

		List<Line> lines = LineMgr.createAllPossibleLines(dots);
		LineMgr.removeInversions(lines);

		List<Line> activeLines = LineMgr.activeLines(lines);
		System.out.println("Final result");
		Log.printCollection(activeLines);

		System.out.println("Total distance is " + LineMgr.totalDistance(activeLines));
		// 15.507582302006968
	}
}
