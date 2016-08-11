import java.util.*;

public class Table {

	protected int start;
	protected List<Row> rows;
	protected int stop;
	
	protected int getStart() {
		return this.start;
	}
	
	protected List<Row> getTable() {
		return this.rows;
	}
	
	public Table(List<Row> rows) {
		this.start = rows.get(0).start;
		this.rows = rows;		
	}
	
	public Table() {
		this.start = 0;
		this.stop = 0;
		this.rows = new ArrayList<>();		
	}
	
	public void mergeRows(int start, int end) {
		
	}
	
	public void divideRows() {
		
	}
	
	public void sortRows() {
		Row.sort(this.rows);
	}
	
	private int getStartIndex(Row row){
		boolean checkStart = true;
		int startIndex = -2;
		if(row.start < start){
			startIndex = -1;
			checkStart = false;
		}
		if(row.start > stop){
			checkStart = false;
			startIndex = rows.size();
		}
		int i;
		for(i=0; i<rows.size() && checkStart; i++){
			if(start > rows.get(i).start){
				startIndex = i;
				break;
			}
		}
		return startIndex;
	}
	
	private int getStopIndex(Row row){
		boolean checkStop = true;
		int stopIndex = -2;
		if(row.stop > stop){
			stopIndex = rows.size();
			checkStop = false;
		}
		if(row.stop < start){
			checkStop = false;
			stopIndex = -1;
		}
		int i;
		for(i=0; i<rows.size() && checkStop; i++){
			if(stop < rows.get(i).stop){
				stopIndex = i;
				break;
			}
		}
		return stopIndex;
	}
	
	public void addRow(Row row){
		//Check overlaps here;
		
		int startIndex = getStartIndex(row);
		int stopIndex = getStopIndex(row);
		
		if(startIndex == -2 || stopIndex == -2){
			//SOME ERROR
			System.out.println("Error. Undesirable case");
		}
		System.out.println(startIndex+""+stopIndex);
		
	}
	
	public void print(String caseName){
		;
	}
	
}
