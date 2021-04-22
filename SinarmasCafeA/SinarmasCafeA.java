import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SinarmasCafeA {
	public static final  String  APPLE_PIE      = "APPLE PIE";
	public static final  String  PINEAPPLE_PIE  = "PINEAPPLE PIE";
	public static final  String  FRUIT_PARFAIT  = "FRUIT PARFAIT";
	public HashMap<String, Integer> mTmp = new HashMap<>();
	
		  public List<String> getSortedList(List<String> names,String param) {	
			  for(int i=0; i<names.size(); i++) {
				  String data = (String) names.get(i).replace(",", "").replace(" ", "");
				  if(mTmp.get(data.toUpperCase()) == null) {
					  mTmp.put(data.toUpperCase(), 1);
				  }else {
					  int tmp = (mTmp.get(data.toUpperCase())+1);
					  mTmp.put(data.toUpperCase(), tmp);
				  }
			  }
			  logikMenuSinarmasCafeA(param);
			  return null;
		  }
		  
		  private void logikMenuSinarmasCafeA(String dataparam) {
			  if(APPLE_PIE.equals(dataparam)) {
				  int apple = 0;
				  if(mTmp.get("Apple".toUpperCase())!=null){
					  apple = mTmp.get("Apple".toUpperCase());
				  }
				  
				  if(mTmp.get("Apples".toUpperCase())!=null){
					  apple = (apple+mTmp.get("Apples".toUpperCase()));
				  }
				  if(apple==3) {
					  System.out.println("You shall have "+APPLE_PIE+" !");
				  }else {
					  System.out.println("You shall not have "+APPLE_PIE+"");
				  }
			  }else if(PINEAPPLE_PIE.equals(dataparam)) {
				  int nanas = 0;
				  if(mTmp.get("Pineapple".toUpperCase())!=null){
					  nanas = mTmp.get("Pineapple".toUpperCase());
				  }
				  
				  if(mTmp.get("Pineapples".toUpperCase())!=null){
					  nanas = (nanas+mTmp.get("Pineapples".toUpperCase()));
				  }
				  
				  if(nanas==3) {
					  System.out.println("You shall have "+PINEAPPLE_PIE+" !");
				  }else {
					  System.out.println("You shall not have "+PINEAPPLE_PIE+"");
				  }				  
			  }else if(FRUIT_PARFAIT.equals(dataparam)) {
				  int apple = 0;
				  int nanas = 0;
				  if(mTmp.get("Apple".toUpperCase())!=null){
					  apple = mTmp.get("Apple".toUpperCase());
				  }
				  
				  if(mTmp.get("Apples".toUpperCase())!=null){
					  apple = (apple+mTmp.get("Apples".toUpperCase()));
				  }
				  
				  if(mTmp.get("Pineapple".toUpperCase())!=null){
					  nanas = mTmp.get("Pineapple".toUpperCase());
				  }
				  
				  if(mTmp.get("Pineapples".toUpperCase())!=null){
					  nanas = (nanas+mTmp.get("Pineapples".toUpperCase()));
				  }
				  
				  if((apple == 2)&& (nanas == 2)) {
					  System.out.println("You shall have "+FRUIT_PARFAIT+" !");
				  }else {				
					  System.out.println("You shall not have "+FRUIT_PARFAIT+"");
				  }		
			  }else {
				  System.out.println("We do not have that on the menu");
			  }
		  }

}
