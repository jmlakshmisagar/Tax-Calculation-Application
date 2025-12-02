package tax.calculation.util;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {

	private List<String[]> rows = new ArrayList<>();
	private String[] headers;

	public ConsoleTable(String... headers) {
		this.headers = headers;
	}

	public void addRow(String... columns) {
		rows.add(columns);
	}

	public void printTable() {
		int[] columnWidths = getColumnWidths();

		printLine(columnWidths);
		printRow(headers, columnWidths);
		printLine(columnWidths);

		for (String[] row : rows) {
			printRow(row, columnWidths);
		}

		printLine(columnWidths);
	}

	private int[] getColumnWidths() {
		int[] widths = new int[headers.length];

		for (int i = 0; i < headers.length; i++) {
			widths[i] = headers[i].length();
		}

		for (String[] row : rows) {
			for (int i = 0; i < row.length; i++) {
				widths[i] = Math.max(widths[i], row[i].length());
			}
		}
		return widths;
	}

	private void printLine(int[] widths) {
		StringBuilder sb = new StringBuilder();
		sb.append("=");

		for (int width : widths) {
			sb.append("=".repeat(width + 2)).append("=");
		}
		System.out.println(sb);
	}

	private void printRow(String[] row, int[] widths) {
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for (int i = 0; i < row.length; i++) {
			sb.append(" ").append(padRight(row[i], widths[i])).append(" |");
		}
		System.out.println(sb);
	}

	private String padRight(String text, int length) {
		return String.format("%-" + length + "s", text);
	}
}
