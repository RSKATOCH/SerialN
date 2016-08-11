import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Row extends Range {

	protected int start;
	protected int stop;
	protected int statusCode;
	protected int transferCode;

	public Row(int start, int stop, int statusCode, int transferCode) {
		this.start = start;
		this.stop = stop;
		this.statusCode = statusCode;
		this.transferCode = transferCode;
	}

	protected int getStart() {
		return this.start;
	}

	protected int getStop() {
		return this.stop;
	}

	protected int getStatusCode() {
		return this.statusCode;
	}

	protected int getTransferCode() {
		return this.transferCode;
	}

	public static void sort(List<Row> rows) {
		Collections.sort(rows, new Comparator<Row>() {
			@Override
			public int compare(Row o1, Row o2) {
				return o1.getStart() - o2.getStart();
			}
		});
	}
	public boolean areConsecutive(Row a) {

		if(this.start == a.stop +1) {
			return true;
		}
		if(this.stop == a.start -1) {
			return true;
		}
		return false;
	}
	
	public boolean haveEqualCodes(Row a) {

		return this.statusCode==a.statusCode && this.transferCode==a.transferCode;
	}
	
	public String toString(){
		return start + " " + stop + " " + (char)(statusCode+65) + " " + transferCode;
	}
}

