import java.util.*;

public class Table {

	protected int start;
	protected List<Row> Rows;
	
	protected int getStart() {
		return this.start;
	}
	
	protected List<Row> getTable() {
		return this.Rows;
	}
	
	public Table(List<Row> rows) {
		this.start = rows.get(0).start;
		this.Rows = rows;		
	}
	
	public void mergeRows() {
		
	}
	
	public void divideRows() {
		
	}
	
	public void updateStatus() {
		
	}
	
	public void sortRows() {
		Row.sort(this.Rows);
	}
	
}
