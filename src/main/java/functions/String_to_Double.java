package functions;

public class String_to_Double {
	public double convert(String s) {
		s = s.substring(1);
		double d = Double.parseDouble(s);
		return d;
	}

}
