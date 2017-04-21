/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author panda
 */
@Entity
public class User {
   @Id
   private String email;
   private String password;
   private String user_type;

   public User() {
   }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.user_type = "user";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
   
}
