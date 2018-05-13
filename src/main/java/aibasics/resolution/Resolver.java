package aibasics.resolution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Resolver {

	public static void main(String[] args) throws IOException {
		KnowledgeBase kb = new KnowledgeBase();
		//FileInputStream in = new FileInputStream("testkb.csv");
		FileInputStream in = new FileInputStream("wumpusPitKB.csv");
		kb.addClauses(in);
		in.close();
		
		System.out.println("=== INITIAL KNOWLEDGE BASE ===");
		System.out.println(kb.toString());
		
		
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("New KNF-Clause: ");
			String newKnowledge = cin.readLine();
			if (newKnowledge == null)
				System.exit(0);
			
			newKnowledge = newKnowledge.trim();
			if (! "".equals(newKnowledge)) {
				Clause nc = new Clause(newKnowledge);
				System.out.println("Adding " + nc.toString());
				kb.addClause(nc);
			} else {
				boolean contradict = kb.resolve();
				System.out.println("=== RESULTING KNOWLEDGEBASE ===");
				System.out.println(kb.toString());
				
				if (contradict)
					System.out.println("Widerspruch in Wissensbasis!");
				else
					System.out.println("kein Widerspruch in der Wissensbasis");
			}
			
		}
	}

}
