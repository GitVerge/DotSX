package dot.sx.tools;

import java.util.List;

import dot.sx.Dot;
import utils.Caster;

/**
 * @author rob3ns
 */
public final class DotMgr {

	public final static boolean setFirstDot(List<Dot> dots, int dotIndex) {
		if (Caster.isValidCollection(dots, dotIndex)) {
			dots.get(dotIndex).setFirst(true);
			return true;
		}
		return false;
	}
	
	public final static boolean setLastDot(List<Dot> dots, int dotIndex) {
		if (Caster.isValidCollection(dots, dotIndex)) {
			dots.get(dotIndex).setLast(true);
			return true;
		}
		return false;
	}
}
