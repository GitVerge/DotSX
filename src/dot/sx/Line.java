package dot.sx;

import java.util.Comparator;

public class Line {

	private Dot start;
	private Dot end;
	private double dist;

	public Line(Dot start, Dot end) {
		this.start = start;
		this.end = end;

		setDist(start.getDist(end));
	}

	public int compareTo (Object o) {
		Line other = (Line) o;

		if (dist > other.dist) {
			return 1;
		} else if (dist < other.dist) {
			return -1;
		}

		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dist);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	public boolean isInversion(Line l) {
		return l.start.equals(end) && l.end.equals(start);
	}
	
	public boolean containsLast() {
		return start.isLast() || end.isLast();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (Double.doubleToLongBits(dist) != Double.doubleToLongBits(other.dist))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + ", dist=" + dist + "]";
	}

	public boolean isValid() {
		return start.isValid() && end.isValid();
	}
	
	public void activate() {
		start.increaseConnections();
		end.increaseConnections();
	}

	public Dot getStart() {
		return start;
	}

	public void setStart(Dot start) {
		this.start = start;
	}

	public Dot getEnd() {
		return end;
	}

	public void setEnd(Dot end) {
		this.end = end;
	}

	public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}
}
