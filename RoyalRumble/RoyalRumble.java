import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoyalRumble{ 
  public List<String> getSortedList(List<String> names) {	 
	  List<String> tmp= new ArrayList<String>();
	  HashMap<String, Integer> mTmp = new HashMap<>();
	  Collections.sort(names);	
	  for(int i=0; i<names.size(); i++) {
		  String data = (String) names.get(i);
		  String[] token = data.split(" ");
		  Integer bil = RomanKeInteger(token[1]);		  
		  int id;
		  if(mTmp.get(token[0])==null) {			 
			  mTmp.put(token[0], bil);       			  id = bil;
		  }else {
			  id = mTmp.get(token[0]);
			  if(id <= bil) {
				  mTmp.put(token[0], bil);				  id = bil;
			  }else {
				  mTmp.put(token[0], id);
			  }
		  }
		  String concatData  = token[0]+" "+BulatKeRoman(id);		  
		  tmp.add(concatData);	
	  }
	
      names.clear();
	  names.addAll(tmp);
	  names.forEach(System.out::println); 
    return null;
  }
  
  private String BulatKeRoman(int num){
   String[] romanCharacters = { "M", "CM", "D", "C", "XC", "L", "X", "IX", "V", "I" };
   int[] romanValues = { 1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };
   String result = "";
    
   for (int i = 0; i < romanValues.length; i++){
	    int numberInPlace = num / romanValues[i];
	    if (numberInPlace == 0) continue;
	    result += numberInPlace == 4 && i > 0? romanCharacters[i] + romanCharacters[i - 1]:
	    new String(new char[numberInPlace]).replace("\0",romanCharacters[i]);
	    num = num % romanValues[i];
   }
   return result;
  }
  
  private int RomanKeInteger(String str) {
       if(str == null || str.length() == 0) {       return 0;       }
       Map<Character, Integer> charMap = new HashMap<>();
       charMap.put('I', 1);       charMap.put('V', 5);       charMap.put('X', 10);       charMap.put('L', 50);
       charMap.put('C', 100);     charMap.put('D', 500);     charMap.put('M', 1000); 
       int result = 0; 
       for(int i = 0; i < str.length()-1; i++) {
             if(charMap.get(str.charAt(i)) >= charMap.get(str.charAt(i+1))) {
                result = result + charMap.get(str.charAt(i));
              } else {
                result = result - charMap.get(str.charAt(i));
              } 
        } 
         result = result + charMap.get(str.charAt(str.length()-1)); 
        return result;
   }
  
  
}
