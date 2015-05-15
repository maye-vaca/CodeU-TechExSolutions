import java.util.Iterator;
public class QueryStream<Query> implements Iterable<Query> {
    private Query[] stream;
    private int size;
    //make a linked list instead of a backing array
    public QueryStream(Query[] q) {
	this.stream = q;
	this.size = q.length;
    }

    @override
    public Iterator<Query> iterator() {
	Iterator<Query> iter = new Iterator<Query>(){
	    private int currInd = 0;

	    @override
	    public boolean hasNext() {
		return (currInd < size) && (stream[currInd] != null);
	    }
	    //gets the next word in the query if there is one
	    //or the next query if there is no other word
	    @override
	    public String next() {
		if (stream[currIndex] != null) { 
		    return stream[currIndex].getWord();
		} else {
		    currIndex++;
		    if (stream[currIndex] == null) {
			return null;
		    } else {
			String word =  stream[currIndex].getWord();
			if (word != null) {
			    return word;
			}
		    }
		}
	    }
	    //implement remove
    }
    
}
