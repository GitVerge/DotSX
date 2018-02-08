package dot.sx;

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

		DotMgr.setFirstDot(dots, startIndex);
		DotMgr.setLastDot(dots, endIndex);

		List<Line> lines = LineMgr.createAllPossibleLines(dots);
		LineMgr.removeInversions(lines);

		return LineMgr.activeLines(lines);
	}

}
