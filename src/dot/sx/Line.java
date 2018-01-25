package dot.sx;

public class Line {

	private Dot start;
	private Dot end;
	private double dist;

	public Line(Dot start, Dot end) {
		this.start = start;
		this.end = end;
		setDist(start.getDist(end));
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
