package es.iesvegademijas.ej1a2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bag<T> {
	private Map<T,Integer> bolsa;
	
	
	public Bag() {
		this.bolsa= new HashMap<>();
	}
	
	
	public void add(T e) {
		int cantidad;
		if(bolsa.containsKey(e)) {	//comprobamos si esta presente y si lo esta añade 1
			cantidad=bolsa.get(e);
			bolsa.replace(e, cantidad+1);
		}else {
			bolsa.put(e, 1);
		}
	}
	
	public void add(T e, Integer num) {
		int cantidad;
		if(bolsa.containsKey(e)) {
			cantidad = bolsa.get(e);
			bolsa.replace(e, cantidad+num);
		}else {
			bolsa.put(e, num);
		}
	}
	
	public Integer getCount(T e) {
		Integer cantidad=0;
		
		if(bolsa.containsKey(e)) {
			cantidad = bolsa.get(e);
		}
		
		return cantidad;
	}
	
	public void remove(T e) {
		if(bolsa.containsKey(e)) {
			bolsa.remove(e);
		}
	}
	
	public void remove(T e, Integer n) {
		int cantidad=0;
		if(bolsa.containsKey(e)) {
			cantidad = bolsa.get(e);
			if(n>cantidad) {
				bolsa.remove(e);
			}else {
				bolsa.replace(e, cantidad-n);
			}
		}
	}
	
	public int size() {
		int tamano=0;
		Integer[] arr;
		Collection<Integer> cantidadenBolsa=bolsa.values();		
		arr = (Integer[])cantidadenBolsa.toArray();	//cogemos los valores y los pasamos a array
		
		for(int i=0; i<arr.length;i++) {
		tamano+=arr[i];		//vemos cuanto acumula
		}
		
		return tamano;
	}
	
	public Set<T> uniqueSet(){
		Set<T> resultado = null;
		
		resultado=bolsa.keySet();
		
		return resultado;
	}
	
	public String toString() {
		String resultado="";
		resultado = bolsa.toString();
		return resultado;
	}
}
