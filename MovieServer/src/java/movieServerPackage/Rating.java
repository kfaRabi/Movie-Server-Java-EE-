/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieServerPackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author panda
 */
//@Entity
public class Rating {
    //@Id @GeneratedValue
    private int ratingId;
    private double rating;
}
