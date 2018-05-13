package aibasics.resolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Clause {
	private Set<Literal> literals = new HashSet<Literal>();
	public final boolean isTautology;
	
	private static int nextNum = 1;
	public final int num = nextNum++;
	
	/**
	 * Generates a new clause from a CSV list of literals.
	 * All literals preceded with ! are negative. 
	 * @param csvClause a string representation of the clause
	 */
	public Clause(String csvClause)
	{
		String[] litStrings = csvClause.split(";");
		for (String l : litStrings) {
			l = l.trim();
			if ("".equals(l))
				continue;
			
			if (l.charAt(0) == '!')
				literals.add(new Literal(l.substring(1), true));
			else
				literals.add(new Literal(l, false));
		}
		
		isTautology = checkForTautology();
	}
	
	private Clause(Set<Literal> literals)
	{
		this.literals = literals;
		this.isTautology = checkForTautology();
	}
	
	/**
	 * Returns true iff the clause is a tautology, i.e. it
	 * always evaluates to True.
	 * @return true, iff clause is a tautology
	 */
	private boolean checkForTautology() {
		throw new RuntimeException("Add your code here.");
	}

	public Set<Literal> getLiterals() {
		return Collections.unmodifiableSet(literals);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Clause)
		{
			Clause other = (Clause) obj;
			return this.literals.equals(other.literals);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return literals.hashCode();
	}
	
	@Override
	public String toString() {
		if (isTautology)
			return ""+ num + ": {true}";
		
		Iterator<Literal> litIt = literals.iterator();
		if (!litIt.hasNext())	// no literals --> FALSE
			return ""+ num + ": {false}";
		
		StringBuffer b = new StringBuffer();
		b.append(num);
		b.append(": ");
		b.append(litIt.next().toString());
		while(litIt.hasNext()) {
			b.append(" or ");
			b.append(litIt.next().toString());
		}
		
		return b.toString();
	}

	public static Collection<Clause> plresolve(Clause c1, Clause c2) {
		throw new RuntimeException("Add your code here.");
	}

	
}
