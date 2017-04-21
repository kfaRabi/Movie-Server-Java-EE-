/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author panda
 */
@ManagedBean
@SessionScoped
public class Test implements Serializable{
    @Id
    int id;
    List<String> list;

    public Test(List<String> list) {
        this.list = list;
    }

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    
    
    

    public List<String> getList() {
        list = new ArrayList<>();
        list.add("her");
        list.add("her");
        return list;
    }
    
    
}
