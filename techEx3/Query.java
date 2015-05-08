import java.util.Date;
public class Query {
    private TimeStamp ts;
    private String words;

    public Query(){
	Date date = new Date();
	this.ts = new Timestamp(date.getTime());
    }
    //gives the next word in the string by splitting the string
    //wherever there is a space
    public String getWord() {
	String[] splitWords = words.split(" ");
	this.words = splitWords[1];
	for (int i = 2; i < splitWords.length; i++) {
	    this.words += splitWords[i];
	}
	return splitWords[0];
    }
}
