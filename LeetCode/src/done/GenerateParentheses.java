package done;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	// Keep master list of all possibilities
	public static List<String> generateParenthesis(int n) {
		List<String> l = new ArrayList<String>();
		go(l, "", 0, 0, n);
		return l;
	}

	public static void go(List<String> l, String s, int open, int closed, int max) {
		// Full, balanced set of parentheses
		if (s.length() == max * 2){
			l.add(s);
			return;
		}

		// Maybe make it a bit better with stringbuilder
		// Open a new one
		if (open < max && closed < max)
			go(l, s + "(", open + 1, closed, max);
		// Close an open one
		if (closed < max && closed < open)
			go(l, s + ")", open, closed + 1, max);
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

}
