package done;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		String openPar = "([{";
		String closePar = ")]}";
		char[] c = s.toCharArray();

		Stack<Character> open = new Stack<>();

		for (int i = 0; i < c.length; ++i) {
			int op = openPar.indexOf(c[i]);
			if (op >= 0) {
				open.push(c[i]);
			} else {
				if (open.size() == 0 || openPar.indexOf(open.pop()) != closePar.indexOf(c[i]))
					return false;
			}
		}
		if (open.size() > 0)
			return false;
		return true;
	}
}
