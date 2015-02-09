package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.io.File;
import java.util.*;

@Entity
public class Archivo extends Model {
    public String nombre;
    public Blob file;
	    
}
