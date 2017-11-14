package main.java;

import org.apache.log4j.Logger;

import java.util.ArrayList;
/**
*   Standard floor object. Implements abstract methods from parent class to set and manage
 *   floor.
 *
 *   @author Brandon Gomez
 */
public class StandardFloor extends Floor
{
    private final Logger log = Logger.getRootLogger();
    private ArrayList<Double> waitTimes = new ArrayList<>();
    private ArrayList<Person> waiting = new ArrayList<>();
    private ArrayList<Person> offLoaded = new ArrayList<>();

    public ArrayList<Person> getWaiting()
    {
        return waiting;
    }

    public void setWaiting(ArrayList<Person> people)
    {
        this.waiting = people;
    }

    public void setWaiting(Person person)
    {
        waiting.add(person);
    }

    public void setOffLoaded(Person person)
    {
        offLoaded.add(person);

        TravelProperties tp = new TravelProperties(person.getStart(), person.getDestination(),person.getRideTime());
        Building.getInstance().addToBuildingLog(tp);
    }

    public void addWaitTime(double time)
    {
        waitTimes.add(time);
    }
}