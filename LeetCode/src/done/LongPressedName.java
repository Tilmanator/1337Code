package done;

public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
		int og = 1, idx = 1;
		if (name.length() > typed.length()) {
			return false;
		}
		if (name.equals(typed)) {
			return true;
		}
		if (name.length() == 0)
			return true;

		if (name.charAt(0) != typed.charAt(0))
			return false;
		if (name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1))
			return false;

		while (og < name.length()) {
			if (idx == typed.length())
				return false;
			if (name.charAt(og) == typed.charAt(idx)) {
				++og;
				++idx;
				continue;
			} else if (typed.charAt(idx) == name.charAt(og - 1)) {
				++idx;
				continue;
			}
			return false;
		}

		return true;

	}
}
