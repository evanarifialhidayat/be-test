import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SinarmasCafeB {
	public static final  String  APPLE_PIE      = "APPLE PIE";
	public static final  String  PINEAPPLE_PIE  = "PINEAPPLE PIE";
	public static final  String  FRUIT_PARFAIT  = "FRUIT PARFAIT";
	public HashMap<String, List<String>> mTmp = new HashMap<>();
	public HashMap<Long, List<String>> mTmpValue = new HashMap<>();
	public HashMap<Long, List<String>> mTmpValuesss = new HashMap<>();
	List<String> tmp= new ArrayList<String>();
	
	public List<String> getSortedList(List<String> names,String param1,String param2) {	
//		STRAWBERRY SHORTCAKE 2019-01-18
			  for(int i=0; i<names.size(); i++) {
				  String datas = (String) names.get(i);
				  String[] token = datas.split(" order=");
				  String[] tokenDate =  token[0].split(" ");
				  String[] tokenOrder =  token[1].split(" fulfilled=");
				  List<String> addData = new ArrayList<String>();
				  SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				  try {
					  Date dt = formatador.parse(token[0]);		
					  String keyHash = tokenDate[0]+(tokenOrder[0].replace("\"", "").toUpperCase());
					  if(mTmp.get(keyHash)==null) {						 
						  if(datas.contains("FALSE")) {
							  addData.add(dt.getTime()+"===="+datas);	
							  mTmp.put(keyHash, addData);	
						  }						 
					  }else {						  
						  if(datas.contains("FALSE")) {
							  addData = mTmp.get(keyHash);
							  if(mTmp.get(keyHash).size()<3) {
								  addData.add(dt.getTime()+"===="+datas);
								  Collections.sort(addData,Collections.reverseOrder());
								  mTmp.put(keyHash, addData);	
							  }
						  }
					  }
				  } catch (Exception e) {
					  e.printStackTrace();
				  }
			  }
			  
		
			  String tmps= param2+param1.toUpperCase();
			  for(int ii=0; ii<mTmp.get(tmps).size(); ii++) {
				  String addData = (String)  mTmp.get(tmps).get(ii);
				  String[] tokendata = addData.split("====");
				  System.out.println(tokendata[1]);
			  }
			  
			  
			  return null;
     }

}
