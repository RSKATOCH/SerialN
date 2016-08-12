import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SerialN {
	
	public static void main(String[] args) {
		debug();
	}
	public static void inputBasedExecute() {
		Scanner s = new Scanner(System.in);

		String testCase;
		while(!(testCase = s.nextLine()).equals("END")){
			
			String[] lineTokens;
			Table table = new Table();
			
			System.out.println();
			System.out.println(testCase);
			while(!((lineTokens = s.nextLine().split(" ")).length == 1 && lineTokens[0].charAt(0) == '0')){
				Row row = new Row(Integer.parseInt(lineTokens[0]), Integer.parseInt(lineTokens[1]), (int)(lineTokens[2].charAt(0)-'A'), Integer.parseInt(lineTokens[3]));
				System.out.println(row);
				table.addRow(row);
			}
		}
		s.close();
	}
	public static void debug() {
		List<Row> rowList = new ArrayList<>();
		rowList.add(new Row(1,100000,1,1));
		
		Table t = new Table(rowList);
		
		t.addRow(new Row(12345,12345,2,1));
		t.addRow(new Row(12345,12345,2,2));
		t.addRow(new Row(1000001,1999999,25,99));
		
		System.out.println(t);
	}
	
}