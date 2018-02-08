package dot.sx.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import dot.sx.Dot;
import dot.sx.Line;
import utils.Caster;

/**
 * @author rob3ns
 */
public final class LineMgr {

	public static final class LineComparator implements Comparator<Line> {
		@Override
		public int compare(Line a, Line b) {
			return a.getDist() < b.getDist() ? -1 : a.getDist() == b.getDist() ? 0 : 1;
		}
	}

	public static final List<Line> createAllPossibleLines(Collection<Dot> dots) {
		List<Line> result = new LinkedList<Line>();
		for (Dot a : dots) {
			for (Dot b : dots) {
				if (!a.equals(b) && a.isValid() && b.isValid()) {
					result.add(new Line(a, b));
				}
			}
		}

		Collections.sort(result, new LineComparator());
		return result;
	}

	public static final boolean containsInversion(Collection<Line> list, Line l) {
		for (Line x : list) {
			if (x.isInversion(l)) {
				return true;
			}
		}
		return false;
	}

	public static final void removeInversions(Collection<Line> list) {
		List<Line> newList = new ArrayList<Line>();
		for (Line l : list) {
			if (!containsInversion(newList, l)) {
				newList.add(l);
			}
		}

		list.clear();
		list.addAll(newList);
	}

	public static final List<Line> activeLines(List<Line> lines) {
		List<Line> activeLines = new ArrayList<Line>();
		for (Line l : lines) {
			if (l.isValid() && !l.containsLast()) {
				l.activate();
				activeLines.add(l);
			}
		}

		for (Line l : lines) {
			if (l.containsLast() && l.isValid()) {
				activeLines.add(l);
				return activeLines;
			}
		}

		return null;
	}

	public static final double totalDistance(List<Line> lines) {
		double total = 0;
		for (Line l : lines) {
			total += l.getDist();
		}

		return total;
	}

	private static final int uniqueDotsSize(List<Line> lines) {
		return Caster.isValidCollection(lines) ? lines.size() + 1 : 0;
	}

	public static final List<Double[]> linesToList(List<Line> lines) {
		List<Double[]> result = new LinkedList<Double[]>();

		for (Line line : lines) {
			if (line.containsLast()) {
				result.add(line.getEnd().toArray());
			}
			result.add(line.getStart().toArray());
		}

		return result;
	}
	
	public static final Double[][] linesToMatrix(List<Line> lines) {
		Double[][] result = new Double[uniqueDotsSize(lines)][2];
		
		int x = 0;
		for (Line line : lines) {
			if (line.containsLast()) {
				result[x++] = line.getEnd().toArray();
			}
			result[x++] = line.getStart().toArray();
		}
		
		return result;
	}
}
