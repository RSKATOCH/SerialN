import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Row extends Range {

	protected int statusCode;
	protected int transferCode;

	public Row(int start, int stop, int statusCode, int transferCode) {
		super(start,stop);
		this.statusCode = statusCode;
		this.transferCode = transferCode;
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
				return o1.getLo() - o2.getLo();
			}
		});
	}
	public boolean areConsecutive(Row a) {

		if(this.getLo() == a.getHi() +1) {
			return true;
		}
		if(this.getHi() == a.getLo() -1) {
			return true;
		}
		return false;
	}
	
	public boolean haveEqualCodes(Row a) {

		return this.statusCode==a.statusCode && this.transferCode==a.transferCode;
	}
	
	public String toString(){
		return getLo() + " " + getHi() + " " + (char)(statusCode+65) + " " + transferCode;
	}
}

