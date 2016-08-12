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
	/*
	public void addRow(Row row){
		//Check overlaps here;
		
		int startIndex = getStartIndex(row);
		int stopIndex = getStopIndex(row);
		
		if(startIndex == -2 || stopIndex == -2){
			//SOME ERROR
			System.out.println("Error. Undesirable case");
		}
		
	}*/
	
	public void addRow(Row row){
		//Check overlaps here;
		List<Row> updateList = new ArrayList<>();
		boolean added = false;
		for(Row r : rows) {
			if(r.disjoint(row)) {
				updateList.add(r);
			} else if(r.equals(row)) {
				/*Just add the new one*/
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				added = true;
			}	else if(r.lessOverlap(row)) {
				/*Add the new one from lo to hi and then add the remaining elements of old row after that*/
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				updateList.add(new Row(row.getHi()+1,r.getHi(),r.getStatusCode(),r.getTransferCode()));
				added = true;
			} else if(r.moreOverlap(row)) {
				/*Add the old one from its lo to new one's lo-1 which are not overlapped, add the new row*/
				updateList.add(new Row(r.getLo(),row.getLo()-1,r.getStatusCode(),r.getTransferCode()));
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				added = true;
			} else if(r.subset(row)) {
				/*If it is a subset we get 3 breakdowns*/
				updateList.add(new Row(r.getLo(),row.getLo()-1,r.getStatusCode(),r.getTransferCode()));
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				updateList.add(new Row(row.getHi()+1,r.getHi(),r.getStatusCode(),r.getTransferCode()));
				added = true;
			} 
		}
		/*If all the rows are disjoint to new row we need to add the row to the list*/
		if(added == false) {
			updateList.add(row);
		}
		rows=updateList;
		/* if the new row is the new first row it needs to be updated*/
		this.sortRows();
		this.start = rows.get(0).getLo();
		this.stop = rows.get(rows.size()-1).getHi();
	}
	
	public void print(String caseName){

	}
	
}
