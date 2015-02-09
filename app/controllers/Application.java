package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import models.Archivo;
import play.db.jpa.Blob;
import play.libs.MimeTypes;
import play.mvc.Controller;
import play.mvc.results.Result;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void nuevo(File archivo) throws FileNotFoundException {
		Archivo archi = new Archivo();
		archi.nombre = archivo.getName();
		archi.file = new Blob();
		archi.file.set(new FileInputStream(archivo),
				MimeTypes.getContentType(archivo.getName()));
		archi.save();
		index();

	}

	public static void download(long id) {
		
		Archivo archi = Archivo.findById(id);
		notFoundIfNull(archi);
		response.setContentTypeIfNotSet(archi.file.type());
		renderBinary(archi.file.get(), archi.nombre);
	}
	
	public static void validar(){
		
	}
}