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
	
	public Table() {
		this.start = 0;
		this.Rows = new ArrayList<>();		
	}
	
	public void mergeRows() {
		
	}
	
	public void divideRows() {
		
	}
	
	public void sortRows() {
		Row.sort(this.Rows);
	}
	
	public void addRow(Row row){
		//Check overlaps here;
	}
	
	public void print(String caseName){
		;
	}
	
}
