package com.exam.Ik;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class keyword {

	private keyword(){}
	private static keyword word=new keyword();
	public static keyword getKeyWord(){
		return word;
	}
	
	public Map getTextDef(String text) throws IOException {
		Map<String, Integer> wordsFren = new HashMap<String, Integer>();
		IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(text), true);
		Lexeme lexeme;
		while ((lexeme = ikSegmenter.next()) != null) {
			if (lexeme.getLexemeText().length() > 1) {
				if (wordsFren.containsKey(lexeme.getLexemeText())) {
					wordsFren.put(lexeme.getLexemeText(),
							wordsFren.get(lexeme.getLexemeText()) + 1);
				} else {
					wordsFren.put(lexeme.getLexemeText(), 1);
				}
			}
		}
		return wordsFren;
	}

	private String sortSegmentResult(Map<String, Integer> wordsFrenMaps,
			int topWordsCount) {
		String returnstr = "";
		System.out.println("=========�ִʽ��=======");
		Iterator<Map.Entry<String, Integer>> wordsFrenMapsIterator = wordsFrenMaps
				.entrySet().iterator();
		while (wordsFrenMapsIterator.hasNext()) {
			Map.Entry<String, Integer> wordsFrenEntry = wordsFrenMapsIterator
					.next();
			System.out.println(wordsFrenEntry.getKey() + "\t[���ִ���Ϊ"
					+ wordsFrenEntry.getValue() + "]");
		}

		List<Map.Entry<String, Integer>> wordFrenList = new ArrayList<Map.Entry<String, Integer>>(
				wordsFrenMaps.entrySet());
		Collections.sort(wordFrenList,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> obj1,
							Map.Entry<String, Integer> obj2) {
						return obj2.getValue() - obj1.getValue();
					}
				});
		System.out.println("\n");
		System.out.println("=========�ؼ���========");
		for (int i = 0; i < topWordsCount && i < wordFrenList.size(); i++) {
			Map.Entry<String, Integer> wordFrenEntry = wordFrenList.get(i);
			if (wordFrenEntry.getValue() > 1) {
				System.out.println(wordFrenEntry.getKey() + "\t[���ִ���Ϊ"
						+ wordFrenEntry.getValue() + "]");
					returnstr += wordFrenEntry.getKey() + ",";
			}
		}
		return returnstr;
	}
   
	/**
    * 
    * @param text ��ε����֣�֧������
    * @param topWordsCount ���عؼ��ʵĸ���
    * @return �ؼ���
    * @throws IOException
    */
	public String getKeyword(String text, int topWordsCount) throws IOException {
		String returnstr = "";
		Map<String, Integer> wordsFrenMaps = getTextDef(text);
		returnstr =sortSegmentResult(wordsFrenMaps, topWordsCount);
		return returnstr;
	}
	

	public static void main(String args[]) throws IOException {
		
		String text2 = "��װ��ָ���ض�������Լ�ʵ��ϸ�ڣ�������ṩ�ӿڿɼ�����װʵ������Ϣ���أ�������������á�"
				+ "���ּ��������ĺô��Ǵﵽ��ģ�黯�ı�׼���Ӷ�����˴���ĸ��ó̶ȡ�"
				+ "��ĳ�̶ֳ��ϣ���װҲ����������������Ŀ�ά���ԣ������˹����������ϵͳ�ķ��ա�"
				+ "��JAVA�����У���������Ժͷ��������Խ��з��ʿ��ơ�"
				+ "ʹ�÷��ʿ��Ʒ� public protected private default ����ʵ�ֲ�ͬ�̶ȵ���Ϣ��װ��";
		
		keyword kw=new keyword();
		System.out.print("\n\n�ؼ��ʣ�"+kw.getKeyword(text2,10));
	}

	
}
