package Week02.LiaBraatens;

/**
 * Project: SE1021-031_Labs
 * Assignment Name:  Keeping our Sources Straight
 * Description: a general text reference that includes basic parameters
 * Objectives: to follow a UML diagram and utilize inheritance
 * Class: SE 1021-031 Dennis  Lab: 2
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/8/2014 at 1:51 PM.
 */
public class Reference
{
    /**
     * the author of the reference
     */
    private String author;
    /**
     * the title of the reference
     */
    private String title;
    /**
     * the number of instances of Reference that are created
     */
    private static int instanceCount = 0;
    /**
     * the unique number that is created from the instance count to identify each entry
     */
    private final int myUniqueID;
    /**
     * the year of publication of the reference, value is set to the absolute value of input to remove possible errors
     */
    private int publicationYear;

    /**
     * the constructor for Reference
     * @param author the author of the reference to be created
     * @param title the title of the reference to be created
     * @param publicationYear the publication year of the reference to be created
     * instance count is incremented at the end of the constructor
     */
    public Reference (String author, String title, int publicationYear)
    {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPublicationYear(publicationYear);
        myUniqueID = instanceCount++;
    }

    /**
     * @return the name of the author of the reference
     */
    public String getAuthor ()
    {
        return author;
    }

    /**
     * formats ant returns the components of reference
     * @return the uniqueId, author, title and published year in the proper Bibtex format
     */
    public String getBibtexEntry ()
    {
        String output = "@REFERENCE { REF" + this.getMyUniqueID() + ",\n";
        output += "author = \"" + this.getAuthor() + "\",\n";
        output += "title = \"" + this.getTitle() + "\",\n";
        output += "publisher = \"" + this.getPublicationYear() + "\",\n";
        output += "},";
        return output;
    }

    /**
     *
     * @return the uniqueId of the reference
     */
    public int getMyUniqueID ()
    {
        return myUniqueID;
    }

    /**
     *
     * @return the publication year of the reference
     */
    public int getPublicationYear ()
    {
        return publicationYear;
    }

    /**
     *
     * @return the title of the reference
     */
    public String getTitle ()
    {
        return title;
    }

    /**
     * sets the author of the reference from a parameter
     * @param author the author of the reference
     */
    public void setAuthor (String author)
    {
        this.author = author;
    }

    /**
     * sets the publication year of the reference from the absolute value of a parameter
     * @param publicationYear the publication year of the reference
     */
    public void setPublicationYear (int publicationYear)
    {
        this.publicationYear = Math.abs(publicationYear);
    }

    /**
     * sets the title of the reference
     * @param title the title of the reference
     */
    public void setTitle (String title)
    {
        this.title = title;
    }


}
