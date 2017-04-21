/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @Id
 * @author panda
 */
@Entity
public class Category {
    @Id
    String categoryName;
    @ManyToMany(mappedBy = "categories")
    List<Movie> movies;

    public Category() {
        movies = new ArrayList<>();
    }

    public Category(String categoryName, List<Movie> movies) {
        super();
        this.categoryName = categoryName;
        this.movies = movies;
    }
  
    
    public String getCategoryName() {
        return categoryName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
    
}
