package movieServerPackage;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import movieServerPackage.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author panda
 */
@ManagedBean
@SessionScoped
public class UserController {
   private String email;
   private String password;
   private Session session;
   private Transaction transaction;
   private User user;
   private String message;
   private String  status;

    public UserController() {
        message = "   ";
        status = "none";
    }

    public UserController(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @PostConstruct
    public void init() {
        user = new User();
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    public String loginHandler(){
        System.err.println("opeining sess");
        session = SessionFactorySingleton.getSession().openSession();
        try{
            System.err.println("searching user");
            user = (User)session.get(User.class, email);
            session.close();
            System.err.println("check pass");
            if(user.getPassword().equals(password)){
                System.err.println("pass matched, chek type");
                if(user.getUser_type().equals("admin")){
                    System.err.println("adminnnnnnnnnnnnnnnn");
                    status="block";
                    return "index?faces-redirect=true";
                }
                else if(user.getUser_type().equals("user")){
                    System.err.println("userrrrrrrrrrrrrrrrr");
                    status="none";
                    return "index?faces-redirect=true";
                }
            }
            else{
                System.err.println("wrong passssssssssss");
                message = "Worng Password";
            }
        }
        catch(Exception e){
            System.err.println("excepton........");
            e.printStackTrace();
            message = "There is a problem, Pls try again with a proper user name and password";
        }
        return "login?faces-redirect=true";
    }
   
}
