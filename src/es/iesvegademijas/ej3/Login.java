package es.iesvegademijas.ej3;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



@Credencial(usuario = "usuario2", hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270") 
@Credencial(usuario = "usuario1", hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918") 
public class Login {
	private static Map<String,String> lista = new HashMap<>();
	private String nombre;
	private String passwd;
	
	
	public  void login() throws NoSuchAlgorithmException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de usuario");
		this.nombre=sc.next();
		System.out.println("Introduce la contraseña");
		this.passwd=Login.hashPassword(sc.next());
		sc.close();
	}
	
	
	public static Map<String, String> getLista() {
		return lista;
	}




	public void aniadir(String param, String param2) {
		lista.put(param, param2);
	}
    @Override
	public String toString() {
		return lista.toString();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	/**
     * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:          
8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
     * @param password
     * @return hash de encriptación de la password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password ) throws NoSuchAlgorithmException {
        MessageDigest digest;
        
        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        
        return bytesToHex(encodedhash);                    
        
    }
    
    private static String bytesToHex(byte[] byteHash) {
        
        StringBuilder hexString = new StringBuilder(2 * byteHash.length);          
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        
        return hexString.toString();
        
    }
    
    
    public static Login contexto() throws NoSuchAlgorithmException {
    	Login l = new Login();
    	
    	Credencial[] cont = Login.class.getAnnotationsByType(Credencial.class);
    	
    	for(Credencial conts :cont) {
    		l.aniadir(conts.usuario(), conts.hashPasswd());
    	}
    	
    	return l;
    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String nombre="";
		String passwd="";
		Login l = Login.contexto();
		Scanner sc = new Scanner(System.in);
		l.login();
		
		if(l.getLista().containsKey(l.getNombre())) {
			if(l.getLista().get(l.getNombre()).equals(l.getPasswd())) {
				System.out.println("Login correcto");
			}else {
				System.out.println("Login incorrecto");
			}
		}
		
		
		

	}

}
