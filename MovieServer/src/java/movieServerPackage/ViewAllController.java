/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;

/**
 *
 * @author panda
 */
@ManagedBean
@SessionScoped
public class ViewAllController {
    private List<Movie> movies;
    private List<Movie> featuredMovies;
    private Movie selectedMovie;

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<Movie> getFeaturedMovies() {
        int sz;
        featuredMovies.clear();
        if(movies.size()<=10)sz=movies.size();
        else sz=10;
        for(int i=0;i<sz;i++){
            featuredMovies.add(movies.get(i));
        }
        return featuredMovies;
    }

    public void setFeaturedMovies(List<Movie> featuredMovies) {
        this.featuredMovies = featuredMovies;
    }
    
    

    @PostConstruct
    public void init(){
        movies = new ArrayList<>();
        featuredMovies = new ArrayList<>();
        Session s = SessionFactorySingleton.getSession().openSession();
        movies = s.createCriteria(Movie.class).list();
    }
    
    public ViewAllController() {
    }

    public ViewAllController(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
}
