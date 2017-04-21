/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author panda
 */
@Entity
public class Movie {
    @Id
    private String movieName;
    private String description;
    private String movieExt;
    private String posterExt;
    private Double rating;
    private String releasedYear;
    @ManyToMany
    private List<Category> categories;

    public Movie() {
    }

    public Movie(String movieName, String description, String movieExt, String posterExt, Double rating, String releasedYear, List<Category> categories) {
        this.movieName = movieName;
        this.description = description;
        this.movieExt = movieExt;
        this.posterExt = posterExt;
        this.rating = rating;
        this.releasedYear = releasedYear;
        this.categories = categories;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieExt() {
        return movieExt;
    }

    public void setMovieExt(String movieExt) {
        this.movieExt = movieExt;
    }

    public String getPosterExt() {
        return posterExt;
    }

    public void setPosterExt(String posterExt) {
        this.posterExt = posterExt;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    public void addCategory(Category category) {
        this.categories.add(category);
    }
    
    
/*    private String releasedYear;
    private String Description;
    private String movieExtention;
    private String imageExtention;
    /*@OneToMany
    private List<Rating> ratings;
    private double rating;
    @ManyToMany
    private List<Category> categories;

    public Movie() {
        categories = new ArrayList<>();
        //ratings = new ArrayList<>();
    }

    public Movie(String movieName, String releasedYear, String Description, String movieExtention, String imageExtention, double rating, List<Category> categories) {
        super();
        this.movieName = movieName;
        this.releasedYear = releasedYear;
        this.Description = Description;
        this.movieExtention = movieExtention;
        this.imageExtention = imageExtention;
        this.categories = categories;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public String getDescription() {
        return Description;
    }

    public String getMovieExtention() {
        return movieExtention;
    }

    public void setMovieExtention(String movieExtention) {
        this.movieExtention = movieExtention;
    }

    public String getImageExtention() {
        return imageExtention;
    }

    public void setImageExtention(String imageExtention) {
        this.imageExtention = imageExtention;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }



    public List<Category> getCategories() {
        return categories;
    }

//    public List<Rating> getRatings() {
//        return ratings;
//    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
    
    public void addCategory(Category category){
        this.categories.add(category);
    }
//    public void addRating(Rating rating){
//        this.ratings.add(rating);
//    }
    
    
    
    */
    
}
