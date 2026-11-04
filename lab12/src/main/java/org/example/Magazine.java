package org.example;
import java.util.List;
import java.util.ArrayList;

class Magazine {
    private int id;
    private String title;
    private String category;
    private int rating;
    private List<Integer> readerRatings;

    public Magazine(int id, String title, String category, int rating, List<Integer> readerRatings) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.readerRatings = new ArrayList<>(readerRatings);
    }

    public double getAverageRating() {
        if (readerRatings.isEmpty()) return 0;
        int sum = 0;
        for (int r : readerRatings) sum += r;
        return (double) sum / readerRatings.size();
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public int getId() { return id; }
    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "Magazine{id=" + id + ", title='" + title + "', category='" + category +
                "', rating=" + rating + ", avg=" + String.format("%.2f", getAverageRating()) + "}";
    }
}
