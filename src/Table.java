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
		this.start = rows.get(0).getLo();
		this.rows = rows;		
	}
	
	public Table() {
		this.start = 0;
		this.stop = 0;
		this.rows = new ArrayList<>();		
	}
	
	public void mergeRows() {

	}
	
	public void divideRows() {

	}
	
	public void sortRows() {
		Row.sort(this.rows);
	}
	
	private int getStartIndex(Row row){
		boolean checkStart = true;
		int startIndex = -2;
		if(row.getLo() < start){
			startIndex = -1;
			checkStart = false;
		}
		if(row.getLo() > stop){
			checkStart = false;
			startIndex = rows.size();
		}
		int i;
		for(i=0; i<rows.size() && checkStart; i++){
			if(start > rows.get(i).getLo()){
				startIndex = i;
				break;
			}
		}
		return startIndex;
	}
	
	private int getStopIndex(Row row){
		boolean checkStop = true;
		int stopIndex = -2;
		if(row.getHi() > stop){
			stopIndex = rows.size();
			checkStop = false;
		}
		if(row.getHi() < start){
			checkStop = false;
			stopIndex = -1;
		}
		int i;
		for(i=0; i<rows.size() && checkStop; i++){
			if(stop < rows.get(i).getHi()){
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
		
	}
	
	public void print(String caseName){

	}
	
}
