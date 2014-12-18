package Week02.LiaBraatens;

/**
 * Project: SE1021-031_Labs
 * Assignment Name: Keeping our Sources Straight
 * Description: an extension of the reference class to specifically handle books
 * Objectives: to follow a UML diagram and utilize inheritance
 * Class: SE1021-031 Dennis  Lab: 2
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/8/2014 at 2:10 PM.
 */
public class Book extends Reference
{
    /**
     * the publisher of the book
     */
    private String publisher;

    /**
     * the constructor of a new Book object
     * @param author the author of the book (handled by the super class)
     * @param title the title of the book (handled by the super class)
     * @param publicationYear the publication year of the book (handled by the super class)
     * @param publisher the publisher of the book
     */
    public Book (String author, String title, int publicationYear, String publisher)
    {
        super(author, title, publicationYear);
        this.setPublisher(publisher);
    }

    /**
     * formats and returns the components of the Book class in Bibtex format
     * @return the uniqueId, author, title, publisher and publication year in the proper Bibtex format
     */
    @Override
    public String getBibtexEntry ()
    {
        String output = "@BOOK { REF" + this.getMyUniqueID() + ",\n";
        output += "author = \"" + this.getAuthor() + "\",\n";
        output += "title = \"" + this.getTitle() + "\",\n";
        output += "publisher = \"" + this.getPublisher() + "\",\n";
        output += "year = \"" + this.getPublicationYear() + "\"";
        output += "},";
        return output;    }

    /**
     *
     * @return the publisher of the book
     */
    public String getPublisher ()
    {
        return this.publisher;
    }

    /**
     * to set the publisher of the book
     * @param publisher name of the publisher of the book
     */
    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
    }
}
