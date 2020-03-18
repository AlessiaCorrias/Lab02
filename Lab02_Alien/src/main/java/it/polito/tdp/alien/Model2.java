package it.polito.tdp.alien;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Model2 {
	
	Map <String, List> dictionary = new TreeMap<String, List> ();
	

	public void addWord(String s) {
		
		String arr [] = s.split(" ");
		
		String p = arr[0];
		String t = arr[1];
		
		char[] chararray = p.toLowerCase().toCharArray();
		boolean flag = true;
		for (char c : chararray) {
			if (c > 'z' || c < 'a')
				flag = false;
		}
		
		char[] chararray2 = t.toLowerCase().toCharArray();
		for (char c : chararray2) {
			if (c > 'z' || c < 'a')
				flag = false;
		}
		
		
	
		
		if(flag == false) {
			throw new InvalidParameterException("Devi inserire parole valide \n");
		} else {
			List<String> traduzioni = new LinkedList<String>();
			if(!traduzioni.contains(t)) {
			traduzioni.add(t);
			}
			dictionary.put(p, traduzioni);
		}
			
	}

	public List getTranslation(String s) {
		if(dictionary.containsKey(s)) {
		 return dictionary.get(s);
		} else
			throw new InvalidParameterException("Puoi cercare solo traduzioni di parole presenti nel dizionario \n");
	}

}
