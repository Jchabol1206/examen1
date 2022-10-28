package es.iesvegademijas.ej3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Credenciales {
	Credencial[] value();
}
