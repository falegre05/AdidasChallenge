package spring.challenge.citiesClient.service.model;

import spring.challenge.citiesClient.repository.model.City;

public class ItineraryTimeNode implements Comparable<ItineraryTimeNode> {
    private City current;
    private City previous;
    private int timeScore;
    private int estimatedTimeScore;
    private int conns;

    public ItineraryTimeNode(City current) {
        this(current, null, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
    }

    public ItineraryTimeNode(City current, City previous, int timeScore, int estimatedTimeScore, int conns) {
        this.current = current;
        this.previous = previous;
        this.timeScore = timeScore;
        this.estimatedTimeScore = estimatedTimeScore;
        this.conns = conns;
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

    public int getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(int timeScore) {
        this.timeScore = timeScore;
    }

    public int getEstimatedTimeScore() {
        return estimatedTimeScore;
    }

    public void setEstimatedTimeScore(int estimatedTimeScore) {
        this.estimatedTimeScore = estimatedTimeScore;
    }

    public int getConns() {
        return conns;
    }

    public void setConns(int conns) {
        this.conns = conns;
    }

    @Override
    public int compareTo(ItineraryTimeNode other) {
        if (this.estimatedTimeScore > other.estimatedTimeScore) {
            return 1;
        } else if (this.estimatedTimeScore < other.estimatedTimeScore) {
            return -1;
        } else {
            return 0;
        }
    }
}