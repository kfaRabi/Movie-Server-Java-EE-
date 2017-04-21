/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author panda
 */
@ManagedBean
@SessionScoped
public class AdminActionController {
    private Session session;
    private Transaction transaction;
    private String message;
    private String movieName;
    private String releasedYear;
    private String description;
    private String movieExtention;
    private String imageExtention;
    private double rating;
    private List<String> categories;
    private List<Category> selectedCat;
    private Movie movie;
    private Category category;
    private List<String> selectedCategories;
    private UploadedFile uploadedVideoFile;
    private UploadedFile uploadedImageFile;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        message=" fill up all the froms and choose appropriate file format ";
        categories = new ArrayList<>();
        selectedCategories = new ArrayList<>();
        movie = new Movie();
        category = new Category();
        categories.add("Adventure");
        categories.add("Animation");
        categories.add("Biography");
        categories.add("Comedy");
        categories.add("Crime");
        categories.add("Documentary");
        categories.add("Drama");
        categories.add("Fantasy");
        categories.add("Horror");
        categories.add("History");
        categories.add("Musical");
        categories.add("Mystery");
        categories.add("Romance");
        categories.add("Sci-Fi");
        categories.add("Sport");
        categories.add("Thriller");
        categories.add("War");
        categories.add("Western");
    }
    
    public AdminActionController() {
        categories = new ArrayList<>();
        selectedCategories = new ArrayList<>();
    }

    public AdminActionController(String movieName, String releasedYear, String Description, String movieExtention, String imageExtention, double rating, List<String> categories, List<String> selectedCategories) {
        this.movieName = movieName;
        this.releasedYear = releasedYear;
        this.description = Description;
        this.movieExtention = movieExtention;
        this.imageExtention = imageExtention;
        this.rating = rating;
        this.categories = categories;
        this.selectedCategories = selectedCategories;
    }



    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public void setDescription(String Description) {
        this.description = Description;
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



    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getMessage() {
        return message;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public UploadedFile getUploadedVideoFile() {
        return uploadedVideoFile;
    }

    public void setUploadedVideoFile(UploadedFile uploadedVideoFile) {
        this.uploadedVideoFile = uploadedVideoFile;
    }

    public UploadedFile getUploadedImageFile() {
        return uploadedImageFile;
    }

    public void setUploadedImageFile(UploadedFile uploadedImageFile) {
        this.uploadedImageFile = uploadedImageFile;
    }

    public void uploadAndStore() throws IOException{
        //System.out.println("trying.....");
        InputStream inp1 = uploadedVideoFile.getInputstream();
        InputStream inp2 = uploadedImageFile.getInputstream();
        //System.out.println("got input stream");
        //if(uploadedImageFile!=null && uploadedImageFile!=null)
        //File uploads = new File("resources/img/");
        //System.out.println("creating file and setting path");
        //File file = new File("/home/panda/Desktop", "new-"+uploadedImageFile.getFileName());
        String fileName1 = uploadedVideoFile.getFileName();
        String fileName2 = uploadedImageFile.getFileName();
        String extension1 = fileName1.substring(fileName1.lastIndexOf('.'), fileName1.length());
        String extension2 = fileName2.substring(fileName2.lastIndexOf('.'), fileName2.length());
        System.out.println("ext 1: "+extension1+" ext2 : "+extension2);
        File file1 = new File("/home/panda/NetBeansProjects/MovieServer/web/resources/vdo/",movieName+extension1);
        File file2 = new File("/home/panda/NetBeansProjects/MovieServer/web/resources/img/",movieName+extension2);
        //System.out.println("half done.. stng input=inp");
        try{
            InputStream input1 = inp1;
            InputStream input2 = inp2;
            System.out.println("input1 = inp1 ......");
            Files.copy(input1, file1.toPath(),StandardCopyOption.REPLACE_EXISTING);
            System.out.println("input2 = inp2 ......");
            Files.copy(input2, file2.toPath(),StandardCopyOption.REPLACE_EXISTING);
            System.out.println("file stored.......................");
            
            /* storing movie into db using hibernate */
            try{
                session = SessionFactorySingleton.getSession().openSession();
                transaction = session.beginTransaction();
                System.out.println("converting category string to object");
                selectedCat = new ArrayList<>();
                for(String each:selectedCategories){
                    //System.out.println("looping through selected category: "+each);
                    category = new Category();
                    category.setCategoryName(each);
                    //category.addMovie();
                    selectedCat.add(category);
                }
//                for(Category e: selectedCat){
//                    System.out.println("testing cat: "+e.getCategoryName());
//                }
                movie = new Movie(movieName, description, extension1, extension2, rating, releasedYear, selectedCat);
                System.out.println("mapping the categories with the movie");
                for(Category each:selectedCat){
                    //session = SessionFactorySingleton.getSession().openSession();
                    //transaction = session.beginTransaction();
                    each.addMovie(movie);
                    //System.out.println("*** "+each.getCategoryName());
                    session.saveOrUpdate(each);
                    //transaction.commit();
                   // session.close();
                    //Category c = (Category)session.get(Category.class, each.categoryName);
//                    if(c!=null){
//                        System.out.println("*** "+c.getCategoryName());
//                        c.addMovie(movie);
//                        session.update(c);
//                    }
//                    else{
//                        each.addMovie(movie);
//                        session.save(c);
//                    }
                    //transaction.commit();
                }
                //session = SessionFactorySingleton.getSession().openSession();
                //transaction = session.beginTransaction();
                System.out.println("category stored.............");
               // transaction = session.beginTransaction();
                session.save(movie);
                System.out.println("movie stored.................");
                transaction.commit();
                session.close();
                message = "successfully done!";
            }
            catch(HibernateException e){
                transaction.rollback();
                System.out.println("rolled back");
                e.printStackTrace();
                message = "file stored, but hibernate rolled back";
            }
            
        }
        catch(IOException e){
            System.out.println("exception..........................");
            e.printStackTrace();
            message = "could not store the file";
            
        }
        System.out.println("name 1: "+movieName+extension1+" name 2: "+movieName+extension1);
            //message="name 1: "+movieName+extension1+" name 2: "+movieName+extension2;
        //else message="empty";
    }
    
    public void flistener1(FileUploadEvent e){
        uploadedVideoFile=e.getFile();
    }

    public void flistener2(FileUploadEvent e){
        uploadedImageFile=e.getFile();
    }
    
    
}
