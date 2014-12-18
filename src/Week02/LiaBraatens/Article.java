package Week02.LiaBraatens;

/**
 * Project: SE1021-031_Labs
 * Assignment Name: Keeping our Sources Straight
 * Description: an extension of Reference that caters to articles in a journal
 * Objectives: to follow a UML diagram and utilize inheritance
 * Class: SE1021-031 Dennis  Lab: 2
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/8/2014 at 2:01 PM.
 */
public class Article extends Reference
{
    /**
     * the first page of the sited article
     */
    private int startingPage;
    /**
     * the last page of the sited article
     */
    private int endingPage;
    /**
     * the publication in which the article can be found
     */
    private String journal;

    /**
     * the constructor for a new Article object
     * @param author the author of the article (handled by the super class)
     * @param title the title of the article (handled by the super class)
     * @param publicationYear the year of publication of the article (handled by the super class)
     * @param journal the name of the journal or publication which the article can be found
     * @param startingPage the first page of the sited article
     * @param endingPage the last page of the sited article
     */
    public Article (String author, String title, int publicationYear, String journal, int startingPage, int endingPage)
    {
        super(author, title, publicationYear);
        this.setJournal(journal);
        this.setStartingPage(startingPage);
        this.setEndingPage(endingPage);
    }

    /**
     * to format and return the details of an article in Bibtex format
     * @return the uniqueId, author, title, journal, pages and publication year in the proper Bibtex format
     */
    @Override
    public String getBibtexEntry ()
    {
        String output = "@ARTICLE { REF" + this.getMyUniqueID() + ",\n";
        output += "author = \"" + this.getAuthor() + "\",\n";
        output += "title = \"" + this.getTitle() + "\",\n";
        output += "journal = \"" + this.getJournal() + "\",\n";
        output += "pages = \"" + this.getStartingPage() + "-" + this.getEndingPage() + "\",\n";
        output += "year = \"" + this.getPublicationYear() + "\"";
        output += "},";
        return output;
    }

    /**
     *
     * @return the starting page of the article
     */
    public int getStartingPage ()
    {
        return startingPage;
    }

    /**
     *
     * @return the ending page of the article
     */
    public int getEndingPage ()
    {
        return endingPage;
    }

    /**
     *
     * @return the journal in which the article is contained
     */
    public String getJournal ()
    {
        return journal;
    }

    /**
     * to set the starting page of the article iff it is not negative and less than or equal to the ending page
     * @param startingPage the first page of the sited article
     */
    public void setStartingPage (int startingPage)
    {
        if (startingPage >= 0 && startingPage <= endingPage)
            this.startingPage = startingPage;
    }

    /**
     * to set the ending page of the article iff it is not negative and it is greater than or equal to the starting page
     * @param endingPage
     */
    public void setEndingPage (int endingPage)
    {
        if (endingPage >= 0 && endingPage >= startingPage)
            this.endingPage = endingPage;
    }

    /**
     * to set the journal that contains the article
     * @param journal the name of the journal or publication which the article can be found
     */
    public void setJournal (String journal)
    {
        this.journal = journal;
    }


}
