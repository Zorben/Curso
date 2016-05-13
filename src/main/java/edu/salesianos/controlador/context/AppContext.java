package edu.salesianos.controlador.context;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.apache.log4j.Logger;


public class AppContext {
	
	 private static Context INSTANCE = new Context();

	    // El constructor privado no permite que se genere un constructor por defecto.
	    // (con mismo modificador de acceso que la definición de la clase) 
	    private AppContext() {}

	    public static Context getInstance() {
	        return INSTANCE;
	    }
	
	    private final static Logger log = Logger.getLogger(AppContext.class);
	   
	
	
}

