package Week02.LiaBraatens.FriClassExample;

import java.sql.Time;

/**
 * Project: SE1021-031_Labs
 * Assignment Name:
 * Description:
 * Objectives:
 * Class:    Lab:
 * FHT VERSION: 1.3 12/01/2014
 *
 * @author Seth
 * @version 1.0 Created on 12/12/2014 at 11:28 AM.
 */
public abstract class FileSystemObject
{
    private String name;
    private int size;
    private Time timestamp;

    public String getName ()
    {
        return this.name;
    }

    public int getSize ()
    {
        return this.size;
    }

    public Time getTimestamp ()
    {
        return timestamp;
    }

    protected void setTimestamp ()
    {
       //set timestamp to current time
        Folder test = (Folder )new Object();
    }

    public void rename (String newName)
    {
        this.name = newName;
    }
}
