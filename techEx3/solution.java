import java.util.Hashtable;
import java.util.Collections;
public class solution {
    public boolean isInDictionary(String word) {
	int i = 0;
	static Hashtable<Integer, String> seenWords =
	    new Hashtable<Integer, String>();
	String dictWord = TrivialDictionary.wordAt(i);
	while (dictWord != null) {
	    if (!seenWords.contains(dictWord)) {
		seenWords.put(i,dictWord);
	    }
	    if (word.equals(dictWord)) {
		return true;
	    }
	    i++;
	}
	return false;
    }

    public Integer hasMajority(Collection<Integer> list) {
	int count = 0;
	Integer max;
	Hashtable<Integer, Integer> table =
	    new Hashtable<Integer, Interger>();
	for (Integer i: list) {
	    if (max == null) {
		max = i;
	    }
	    if (!table.contains(i)) {
		table.put(i,1);
	    } else {
		int currCount = table.get(i) + 1;
		table.put(i, currCount);
		if (currCount >= table.get(max)) {
		    max = i;
		}
	    }
	}
	return max;
    }

    
}
