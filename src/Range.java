
public class Range {
	private int hi;
	private int lo;
	
	public Range(int hi, int lo) {
		this.hi = hi;
		this.lo = lo;
	}
	
	private boolean equals(Range other) {
		return (this.hi == other.hi && this.lo == other.lo);
	}
	
	private boolean subset(Range other) {
		return (this.hi >= other.hi && this.lo <= other.lo);
	}
	
	private boolean disjoint(Range other) {
		return (this.lo > other.hi || this.hi < other.lo);
	}
	
	private boolean lessOverlap(Range other) {
		return (this.lo >= other.lo && this.hi < other.hi);
	}
	
	private boolean moreOverlap(Range other) {
		return (this.lo > other.lo && this.hi >= other.hi);
	}
	
	public static enum Classes {
		EQUAL, SUBSET, DISJOINT, MOREOVERLAP, LESSOVERLAP;
	}
	
	public Classes classify(Range other) {
		if (this.equals(other)) {
			return Classes.EQUAL;
		} else if (this.disjoint(other)) {
			return Classes.DISJOINT;
		} else if (this.subset(other)) {
			return Classes.SUBSET;
		} else if (this.moreOverlap(other)) {
			return Classes.MOREOVERLAP;
		} else {
			return Classes.LESSOVERLAP;
		}
	}
}
