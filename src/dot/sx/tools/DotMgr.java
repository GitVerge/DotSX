package dot.sx.tools;

import java.util.ArrayList;
import java.util.List;

import dot.sx.Dot;
import utils.Caster;

/**
 * @author rob3ns
 */
public final class DotMgr {

	private final static int POS_X = 0;
	private final static int POS_Y = 1;

	public final static boolean setFirstDot(List<Dot> dots, Integer dotIndex) {
		if (Caster.isValidCollection(dots, dotIndex) && dotIndex != null) {
			dots.get(dotIndex).setFirst(true);
			return true;
		}
		return false;
	}

	public final static boolean setLastDot(List<Dot> dots, Integer dotIndex) {
		if (Caster.isValidCollection(dots, dotIndex) && dotIndex != null) {
			dots.get(dotIndex).setLast(true);
			return true;
		}
		return false;
	}

	public final static Dot arrayToDot(Double[] position) {
		return new Dot(position[POS_X], position[POS_Y]);
	}

	public final static List<Dot> matrixToDots(Double[][] positions) {
		List<Dot> dots = new ArrayList<Dot>();

		for (int i = 0; i < positions.length; ++i) {
			dots.add(arrayToDot(positions[i]));
		}

		return dots;
	}
}
