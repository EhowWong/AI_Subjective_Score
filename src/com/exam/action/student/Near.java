package com.exam.action.student;

/*
 * ta 老师的关键词
 * s 学生的答案
 * s_char 学生答案被截取的字符
 */
public class Near {
	
	private Near(){}
	private static Near instance=new Near();
	public static Near getInstance(){
		return instance;
	}

	public double near_t(String ta,String s){
		double n=0;
		int k=0,l=0,m=0,m1=0;
		String ta_char;
		ta=ta.trim();
		while(ta.length()>0){
			
			int ta_asc=ta.charAt(0);
			if(ta_asc>255){
				k=2;
			}else{
				k=1;
			}

//			k=ta.length();
			if(ta.length()<k){
				break;
			}else{
				ta_char=ta.substring(0, k);
			}
			
			if(ta.length()<ta_char.length()){
				continue;
			}else if(ta.length()>=ta_char.length()){
				ta=ta.substring(ta_char.length(), ta.length());
			}
//			System.out.println("老师的关键词>>>>>>>>>"+ta_char+"     "+"学生的答案>>>>>>>>>"+s);
			l=s.indexOf(ta_char);
//			System.out.println("是否匹配>>>>>>>>>"+l+"     "+"老师>>>>>>>>>"+ta);
			if(l>=0){
				m=m+1;
			}else{
				m1=m1+1;
			}
			n=(double)m/(m+m1);
		}
//		System.out.println("匹配上>>>>>>>>>"+m+"     "+"没有匹配上>>>>>>>>>"+m1+"     "+"得分>>"+n);
		System.out.println("========="+n);
		return n;
	}
	
}
