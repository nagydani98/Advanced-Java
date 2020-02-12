package hu.me.krz.haladojava;

public class Point {
	private final long x;
	private final long y;
	private final long z;
	
	public Point(long x, long y, long z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point() {
		this(0, 0, 0);
	}

	public long getX() {
		return x;
	}

	public long getY() {
		return y;
	}

	public long getZ() {
		return z;
	}
	
	public Point translate(Point point) {
		return new Point(point.x + this.x, point.y + this.y, point.z + this.z);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	
}
