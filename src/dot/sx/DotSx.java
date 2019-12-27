package dot.sx;

import java.util.Calendar;
import java.util.List;

import dot.sx.tools.DotMgr;
import dot.sx.tools.LineMgr;

public class DotSx {

	public static Double[][] shortestPathMatrix(Double[][] positions, Integer start, Integer end) {
		return LineMgr.linesToMatrix(shortestPathFor(positions, start, end));
	}
	
	public static List<Double[]> shortestPathList(Double[][] positions, Integer start, Integer end) {
		return LineMgr.linesToList(shortestPathFor(positions, start, end));
	}

	private static List<Line> shortestPathFor(Double[][] positions, Integer startIndex, Integer endIndex) {
		List<Dot> dots = DotMgr.matrixToDots(positions);
		long start = Calendar.getInstance().getTimeInMillis();

		DotMgr.setFirstDot(dots, startIndex);
		DotMgr.setLastDot(dots, endIndex);

		System.out.println("end sets in " + (Calendar.getInstance().getTimeInMillis() - start) + " ms");
		start = Calendar.getInstance().getTimeInMillis();
		
		List<Line> lines = LineMgr.createAllPossibleLines(dots);

		System.out.println("end create in " + (Calendar.getInstance().getTimeInMillis() - start) + " ms");
		start = Calendar.getInstance().getTimeInMillis();

		LineMgr.removeInversions(lines);

		System.out.println("end remove inversions in " + (Calendar.getInstance().getTimeInMillis() - start) + " ms");

		return LineMgr.activeLines(lines);
	}

}
