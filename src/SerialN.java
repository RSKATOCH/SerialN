import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SerialN {
	
	public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		inputBasedExecute();
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
				table.addRow(row);
			}
			System.out.println(table);
		}
		s.close();
	}
	
	private static int getCharacterIndex(String s) {
		return ALPHABET.indexOf(s);
	}
	
	
	public static void debug() {
		// First Test Case
		List<Row> rowList = new ArrayList<>();
		rowList.add(new Row(1,100000,1,1));
		Table t = new Table(rowList);

		
		t.addRow(new Row(1,100000, getCharacterIndex("A"), 1));
		System.out.println(t);
		t.addRow(new Row(12345,12345, getCharacterIndex("B"), 2));
		System.out.println(t);
		t.addRow(new Row(12000,12999, getCharacterIndex("A"), 2));
		System.out.println(t);
		t.addRow(new Row(12345,12345, getCharacterIndex("B"), 2));
		
		System.out.println(t+"\n\n");
		/*// Second Test Case
		rowList = new ArrayList<>();
		rowList.add(new Row(1, 1000, getCharacterIndex("A"), 1));
		t = new Table(rowList);
		System.out.println(t);
		t.addRow(new Row(100, 150, getCharacterIndex("A"), 2));
		System.out.println(t);
		t.addRow(new Row(100, 150, getCharacterIndex("A"), 1));
		*/
		System.out.println(t);
	}
	
}