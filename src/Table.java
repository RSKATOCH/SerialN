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
	
	public void sortRows() {
		Row.sort(this.rows);
	}
	
	public void addRow(Row row){
		//Check overlaps here;
		List<Row> updateList = new ArrayList<>();
		boolean added = false;
		for(Row r : rows) {
			if(r.classify(row) == Range.Classes.DISJOINT) {
				updateList.add(r);
			} else if(r.classify(row) == Range.Classes.EQUAL) {
				/*Just add the new one*/
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				added = true;
			}	else if(r.classify(row) == Range.Classes.LESSOVERLAP) {
				/*Add the new one from lo to hi and then add the remaining elements of old row after that*/
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				updateList.add(new Row(row.getHi()+1,r.getHi(),r.getStatusCode(),r.getTransferCode()));
				added = true;
			} else if(r.classify(row) == Range.Classes.MOREOVERLAP) {
				/*Add the old one from its lo to new one's lo-1 which are not overlapped, add the new row*/
				updateList.add(new Row(r.getLo(),row.getLo()-1,r.getStatusCode(),r.getTransferCode()));
				updateList.add(new Row(row.getLo(),row.getHi(),row.getStatusCode(),row.getTransferCode()));
				added = true;
			} else if(r.classify(row) == Range.Classes.SUBSET) {
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
	
	public String toString() {
		String s = "";
		for (Row r : this.rows) {
			s += r.toString() + "\n";
		}
		return s;
	}
	
}
