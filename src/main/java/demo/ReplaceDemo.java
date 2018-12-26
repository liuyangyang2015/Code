package demo;

import java.util.regex.Pattern;

/**
 * @author liuyangyang
 * @date 2018/12/14 13:05
 * description:
 */

public class ReplaceDemo {
	public static void main2(String[] args) {
		// 替换不是数字的 字符为空 ^ 匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合
		String s = "wang...test4.jpg".replaceAll("[^\\d]", "");
		System.out.println(s);
	}

	private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

//	public static void main(String[] args) {
//		String  s=NUMBER_PATTERN.matcher("wang...test4.jpg").e();
//		System.out.println(s);
//	}
}
