package aibasics.resolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KnowledgeBase {
	private Set<Clause> clauses = new HashSet<Clause>();
	
	/**
	 * Reads a CSV list from the input stream and adds the clauses
	 * to the knowledge base.
	 * @param stream the stream to read the CSV data from
	 * @throws IOException on I/O errors
	 */
	public void addClauses(InputStream stream) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		while (null != (line = reader.readLine())) {
			line = line.trim();
			if ("".equals(line))
				continue;
			clauses.add(new Clause(line));
		}
	}
	
	public void addClause(Clause nc) {
		clauses.add(nc);
	}
	
	/**
	 * Does the resolution and adds new derived clauses
	 * to the knowledge base.
	 * @return true, if a contradiction is found
	 */
	public boolean resolve() {
		throw new RuntimeException("Add your code here.");
	}
	
	
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		List<Clause> list = new ArrayList<Clause>(clauses);
		Collections.sort(list, new Comparator<Clause>() {
			public int compare(Clause a, Clause b) {
				if (a.num == b.num)
					return 0;
				return (a.num < b.num)?-1:1;
			}
		});
		for (Clause c : list) {
			b.append(c.toString());
			b.append('\n');
		}
		return b.toString();
	}

	
}
