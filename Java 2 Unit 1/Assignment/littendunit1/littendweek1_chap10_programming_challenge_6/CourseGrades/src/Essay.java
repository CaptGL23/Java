/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This subclass determines a numeric score
    for an essay.
 */

class Essay extends GradedActivity
{

    private int grammar;            // The score for grammar
    private int spelling;           // The score for spelling
    private int correctLength;      // The score for correct length
    private int content;            // The score for content

    /**
     * Constructor to assign the following arguments to
     * the appropriate fields
     * @param g The score for grammar
     * @param s The score for spelling
     * @param cL The score for correct length
     * @param ct The score for content
     */
    public Essay(int g, int s, int cL, int ct){
        grammar = g;
        spelling = s;
        correctLength = cL;
        content = ct;
    }

    // Constructor
    public Essay()
    {

    }

    /**
     * doTotal method
     */
    public void doTotal()
    {
        super.setScore(grammar+spelling+correctLength+content);
    }

    /**
     * setGrammar method
     * @param g The score for grammar
     */
    public void setGrammar(int g)
    {
        grammar = g;
    }

    /**
     * setSpelling method
     * @param s The score for spelling
     */
    public void setSpelling(int s)
    {
        spelling = s;
    }

    /**
     * setCorrectLength method
     * @param l The score for the correct length
     */
    public void setCorrectLength(int l)
    {
        correctLength = l;
    }

    /**
     * setContent method
     * @param c The score for content
     */
    public void setContent(int c)
    {
        content = c;
    }

    /**
     * getGrammar method
     * @return The score for grammar
     */
    public int getGrammar()
    {
        return grammar;
    }

    /**
     * getSpelling method
     * @return The score for spelling
     */
    public int getSpelling()
    {
        return spelling;
    }

    /**
     * getCorrectLength method
     * @return The score for correct length
     */
    public int getCorrectLength()
    {
        return correctLength;
    }

    /**
     * getContent method
     * @return The score for content
     */
    public int getContent()
    {
        return content;
    }
}