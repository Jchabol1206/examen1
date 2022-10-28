package es.iesvegademijas.ej3;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Repeatable(Credenciales.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Credencial {
	
	String usuario();
	String hashPasswd();

}
