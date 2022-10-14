public class Book
{
    private String title;
    private String author;
    private String publisher;
    private int copiesSold;

    /**
     Constructor
     @param t The title of the book
     @param a The author of the book
     @param p The publisher of the book
     @param sold The number of copies sold
     */
    public Book (String title, String author, String publisher, int copiesSold)
    {
        title = t;
        author = a;
        publisher = p;
        copiesSold = sold;
    }

    /**
     * setTitle method
     * @param t The title of the book
     */
    public void setTitle(String t)
    {
        title = t;
    }

    /**
     * setAuthor method
     * @param a The author of the book
     */
    public void setAuthor(String a)
    {
        author = a;
    }

    /**
     * setPublisher method
     * @param p The publisher of the book
     */
    public void setPublisher(String p)
    {
        publisher = p;
    }

    /**
     * setCopiesSold method
     * @param sold The number of copies sold
     */
    public void setCopiesSold(int sold)
    {
        copiesSold = sold;
    }

    /**
     * getTitle method
     * @return The title of the book
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * getAuthor method
     * @return The author of the book
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * getPublisher method
     * @return The publisher of the book
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * getCopiesSold method
     * @return The number of copies sold
     */
    public int getCopiesSold()
    {
        return copiesSold;
    }
}
