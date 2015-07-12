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
		System.out.println("=========分词结果=======");
		Iterator<Map.Entry<String, Integer>> wordsFrenMapsIterator = wordsFrenMaps
				.entrySet().iterator();
		while (wordsFrenMapsIterator.hasNext()) {
			Map.Entry<String, Integer> wordsFrenEntry = wordsFrenMapsIterator
					.next();
			System.out.println(wordsFrenEntry.getKey() + "\t[出现次数为"
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
		System.out.println("=========关键词========");
		for (int i = 0; i < topWordsCount && i < wordFrenList.size(); i++) {
			Map.Entry<String, Integer> wordFrenEntry = wordFrenList.get(i);
			if (wordFrenEntry.getValue() > 1) {
				System.out.println(wordFrenEntry.getKey() + "\t[出现次数为"
						+ wordFrenEntry.getValue() + "]");
					returnstr += wordFrenEntry.getKey() + ",";
			}
		}
		return returnstr;
	}
   
	/**
    * 
    * @param text 大段的文字，支持中文
    * @param topWordsCount 返回关键词的个数
    * @return 关键词
    * @throws IOException
    */
	public String getKeyword(String text, int topWordsCount) throws IOException {
		String returnstr = "";
		Map<String, Integer> wordsFrenMaps = getTextDef(text);
		returnstr =sortSegmentResult(wordsFrenMaps, topWordsCount);
		return returnstr;
	}
	

	public static void main(String args[]) throws IOException {
		
		String text2 = "封装是指隐藏对象的属性及实现细节，对外仅提供接口可见。封装实现了信息隐藏，有利于软件复用。"
				+ "这种技术带来的好处是达到了模块化的标准，从而提高了代码的复用程度。"
				+ "在某种程度上，封装也大大改善了软件开发的可维护性，降低了构建复杂软件系统的风险。"
				+ "在JAVA语言中，对象的属性和方法均可以进行访问控制。"
				+ "使用访问控制符 public protected private default 可以实现不同程度的信息封装。";
		
		keyword kw=new keyword();
		System.out.print("\n\n关键词："+kw.getKeyword(text2,10));
	}

	
}
