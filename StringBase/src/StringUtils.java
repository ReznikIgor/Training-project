import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String reversStr(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static boolean palindrome(String str) {
		String first = str.replace(" ", "");
		return first.equalsIgnoreCase(new StringBuilder(first).reverse().toString());
	}

	public static String checkLenght(String str) {
		if (str.length() > 10) {
			return str.substring(0, 6);
		} else {
			StringBuilder sb = new StringBuilder(str);
			while (sb.length() < 12) {
				sb.append("o");
			}
			return sb.toString();
		}
	}

	public static String FirstToLast(String str) {
		String[] arrStr = str.split(" ");
		String wordBuff = arrStr[0];
		int k = arrStr.length - 1;
		arrStr[0] = arrStr[k];
		arrStr[k] = wordBuff;
		StringBuilder sb = new StringBuilder();
		for (String s1 : arrStr) {
			sb.append(s1 + " ");
		}
		return sb.toString().trim();
	}

	public static String FirstToLastInSent(String str) {
		String[] arrStr = str.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (String s1 : arrStr) {
			sb.append(FirstToLast(s1) + ".");
		}
		return sb.toString();
	}

	public static boolean containsABC(String str) {
		Pattern pattern = Pattern.compile("[abc]+");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean containsDate(String str) {
		Pattern pattern = Pattern.compile("([0-9]{2})\\.([0-9]{2})\\.([0-9]{4})");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static String[] findPhone(String str) {
		Pattern pattern = Pattern.compile("(\\+[0-9]{1}\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2})+");
		Matcher matcher = pattern.matcher(str);
		int i = 0;
		while (matcher.find()) {
			i++;
		}
		String[] phones = new String[i];
		int counter = 0;
		matcher.reset();
		while (matcher.find()) {
			phones[counter] = matcher.group(1);
			counter++;
		}
		return phones;
	}

}
