package Week02.LiaBraatens;

import java.util.ArrayList;

/**
 * Project: SE1021-031_Labs
 * Assignment Name: Keeping our Sources Straight
 * Description: an array of Reference objects
 * Objectives: to follow a UML diagram and utilize inheritance
 * Class: SE 1021-031 Dennis  Lab: 2
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/8/2014 at 1:47 PM.
 */
public class ReferenceHolder
{
    /**
     * an ArrayList of reference objects, allowing for the easy printing of each entry
     */
    private ArrayList<Reference> references = new ArrayList<Reference>();

    /**
     * adds a reference to the list of references
     * @param myReference the reference to be added
     */
    public void addReference(Reference myReference)
    {
        references.add(myReference);
    }

    /**
     * prints the entire references list's Bibtexts to console
     */
    public void printAllBibtexEntries()
    {
        for (Reference i : references)
            System.out.println(i.getBibtexEntry());
    }
}
