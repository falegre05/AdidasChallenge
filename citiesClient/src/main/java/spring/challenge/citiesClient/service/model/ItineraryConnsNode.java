package spring.challenge.citiesClient.service.model;

import spring.challenge.citiesClient.repository.model.City;

// Object made to get A* algorithm based on less connections working with the particularity that 
// it also stores the minutes to get to an specific city from the origin one
public class ItineraryConnsNode implements Comparable<ItineraryConnsNode> {
    private City current;
    private City previous;
    private int connsScore;
    private int estimatedConnsScore;
    private int minutes;

    public ItineraryConnsNode(City current) {
        this(current, null, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
    }

    public ItineraryConnsNode(City current, City previous, int connsScore, int estimatedConnsScore, int minutes) {
        this.current = current;
        this.previous = previous;
        this.connsScore = connsScore;
        this.estimatedConnsScore = estimatedConnsScore;
        this.minutes = minutes;
    }

    public City getCurrent() {
        return current;
    }

    public void setCurrent(City current) {
        this.current = current;
    }

    public City getPrevious() {
        return previous;
    }

    public void setPrevious(City previous) {
        this.previous = previous;
    }

    public int getConnsScore() {
        return connsScore;
    }

    public void setConnsScore(int connsScore) {
        this.connsScore = connsScore;
    }

    public int getEstimatedConnsScore() {
        return estimatedConnsScore;
    }

    public void setEstimatedConnsScore(int estimatedConnsScore) {
        this.estimatedConnsScore = estimatedConnsScore;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public int compareTo(ItineraryConnsNode other) {
        if (this.estimatedConnsScore > other.estimatedConnsScore) {
            return 1;
        } else if (this.estimatedConnsScore < other.estimatedConnsScore) {
            return -1;
        } else {
            return 0;
        }
    }
}