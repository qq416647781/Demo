package test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

public static void main(String[] args) throws Exception, SecurityException {
	
//	mapSort();
//	System.exit(0);
	
    BigDecimal decimal = new BigDecimal("1.12346");
    System.out.println(decimal.floatValue());
    BigDecimal setScale = decimal.setScale(4,BigDecimal.ROUND_DOWN);
    System.out.println(setScale.floatValue());
    
    BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
    System.out.println(setScale1.floatValue());
    
    
    String k="\"cBrand\":{\"id\":\"4\",\"rcRemark\": [\"R/;\"],\"isSaleCd}";
    String regexp="(\"cBrand\":).*(?=,)";
//    String regexp="(\"cBrand\":).*?,";
    Pattern p=Pattern.compile(regexp);
    Matcher m=p.matcher(k);
    System.out.println(k);
    System.out.println(m.find());
    System.out.println(m.group(0));
    
    new AbstractTest(){
    	public void syso() {
    		System.out.println("自己定义的方法");
		}
    }.show();
   
    NumberFormat format= NumberFormat.getCurrencyInstance(Locale.CHINA);
    System.out.println(format.format(111111));
    System.out.println(format.format(111.111));
    System.out.println(2%7);
    
    String s="XiT+mhZMQw0=|SzmxzQBxI9I=";
    System.out.println("=="+s.split("\\|")[0]);
    
    System.out.println(UUID.randomUUID().toString());
    
    
    System.out.println(System.currentTimeMillis());
    
    System.out.println(Pattern.matches("^[A-Za-z0-9]+$", "e_ieureui"));
    
    System.err.println(Pattern.matches("^(-)?[0-9]*(.)?[0-9]*$", "-9839938431"));
    
    testSubList();   
    
    BigDecimal payAmount=new BigDecimal("0");
    BigDecimal payAmount2=new BigDecimal("-5.73");
    System.out.println(payAmount.longValue()+"~"+payAmount2.longValue());
    System.out.println(System.currentTimeMillis());

    Long rateAmountTotal=111L;
	BigDecimal amountTotal=(new BigDecimal(rateAmountTotal)).setScale(0,BigDecimal.ROUND_HALF_UP);
	BigDecimal rateRadix=(new BigDecimal("1.06")).setScale(2, BigDecimal.ROUND_HALF_UP);
	BigDecimal inAmount=amountTotal.divide(rateRadix,0,BigDecimal.ROUND_HALF_UP);//收入手续费
	Long outAmount=rateAmountTotal-inAmount.longValue();//支出手续费
	System.out.println(rateAmountTotal+":"+inAmount.longValue()+","+outAmount);

	Long balance=40000000L;
	Float jsb = balance<Integer.valueOf("3000000")?Float.valueOf("0.001"):
				balance<Integer.valueOf("5000000")?Float.valueOf("0.002"):
				balance<Integer.valueOf("15000000")?Float.valueOf("0.003"):
				balance<Integer.valueOf("30000000")?Float.valueOf("0.004"):Float.valueOf("0.005");
	System.out.println("值:"+jsb.floatValue());
	
	
	NumberFormat numberFormat=NumberFormat.getPercentInstance();
	numberFormat.setMinimumFractionDigits(2);
	String formatPercent = numberFormat.format(0.05F);
	System.out.println(formatPercent);
}

private static void testSubList() {
	List<String> alis=new ArrayList<String>();
    alis.add("a");
    alis.add("b");
    alis.add("c");
    alis.add("d");
    alis.add("e");
    List<String> subs=alis.subList(1, 2);
    subs.add("h");
    for (String sub:subs) {
    	System.out.println(sub);
	}
    System.out.println("==========");
    for (String sub:alis) {
    	System.out.println(sub);
    }
}

@SuppressWarnings("test")
public void declaredField(){
	
}

private static void mapSort() {
	Map<String,Integer> payMentMap=new HashMap<String,Integer>();
	payMentMap.put("a", -1);
	payMentMap.put("b", 3);
	payMentMap.put("c", 2);
	payMentMap.put("d", 1);

	List<Map.Entry<String, Integer>> paymentList=new ArrayList<Map.Entry<String,Integer>>(payMentMap.entrySet());
	
	
	Collections.sort(paymentList, new Comparator<Entry<String, Integer>>(){
		@Override
		public int compare(Entry<String, Integer> paramT1,
				Entry<String, Integer> paramT2) {
			return paramT1.getValue().compareTo(paramT2.getValue());
		}
	});
	
	for(Entry<String, Integer> entry:paymentList){
		System.out.println(entry.getKey()+"==="+entry.getValue());
	}
}
}
