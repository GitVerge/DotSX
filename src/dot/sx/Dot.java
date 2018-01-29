package dot.sx;

public class Dot {

	private double x;
	private double y;
	private int connections;
	private boolean first;
	private boolean last;

	public Dot(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getDist(Dot dot) {
		return Math.sqrt( Math.pow(x - dot.getX(), 2) + Math.pow(y - dot.getY(), 2) );
	}
	
	public boolean isValid() {
		int max = (first || last) ? 1 : 2;
		return connections <  max;
	}
	
	@Override
	public String toString() {
		return "Dot [x=" + x + ", y=" + y + ", connections=" + connections + ", first=" + first + ", last=" + last
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dot other = (Dot) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	public int getConnections() {
		return connections;
	}

	public void increaseConnections() {
		++connections;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

}
