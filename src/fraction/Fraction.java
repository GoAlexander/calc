package fraction;

public class Fraction {
	private int nom, denom;

	public Fraction(int nom, int denom) {
		setFraction(nom, denom);
	}

	public Fraction() {
		this(0, 1);
	}

	public Fraction(int nom) {
		this(nom, 1);
	}

	public Fraction(String s) throws NumberFormatException {
		if (s.contains("/")) {
			String[] parts = s.split("/");
			int part1 = Integer.parseInt(parts[0]);
			int part2 = Integer.parseInt(parts[1]);
			for (int i = 2; i < parts.length; i++)
				part2 *= Integer.parseInt(parts[i]);
			setFraction(part1, part2);
		} else
			setFraction(Integer.parseInt(s));
	}

	public void setFraction(int nom, int denom) {
		this.nom = nom;
		this.denom = denom;
		fractionStandartization();
	}

	public void setFraction(int nom) {
		setFraction(nom, 1);
	}

	public int getNom() {
		return nom;
	}

	public int getDenom() {
		return denom;
	}

	public void print() { // print + checking (+processing_of_exeptions)
		if (nom == 0 && denom != 0)
			System.out.println(0);
		else if (denom == 1)
			System.out.println(nom);
		else
			System.out.println(nom + "/" + denom);
	}

	public String getString() { // print + checking (+processing_of_exeptions)
		String result;
		if (nom == 0 && denom != 0)
			result = "0";
		else if (denom == 1)
			result = Integer.toString(nom);
		else
			result = Integer.toString(nom) + "/" + Integer.toString(denom);

		return result;
	}

	@Override
	public String toString() {
		if ((nom == 0) || (denom == 1))
			return Integer.toString(nom);
		else
			return Integer.toString(nom) + "/" + Integer.toString(denom);
	}

	private void reduction() { // сокращение дроби (Но!
								// если число на вход
		// отрицательное, то знак "вынуть")
		int tmp = 1;
		if (nom < 0) {
			tmp = -1;
			nom *= -1;
		}
		for (int i = nom; i > 1; i--) {
			if (nom % i == 0 && denom % i == 0) {
				nom /= i;
				denom /= i;
			}
		}
		nom *= tmp; // проверить (я решил сделать без
					// проверки!!!)
	}

	private void sign() { // проверка на знак + выводим
							// знак только (при вводе
		// интегрировать проверку!!!)
		if (nom < 0 && denom < 0 || nom > 0 && denom < 0) {
			nom *= -1;
			denom *= -1;
		}
	}

	private void fractionStandartization() throws ArithmeticException{
		if(denom==0)
			throw new ArithmeticException();
		sign();
		reduction();
	}

	public void addition(Fraction f2) throws ArithmeticException {
		addition(this, f2);
		fractionStandartization();
	}

	public void addition(Fraction f1, Fraction f2) {
		nom = f1.nom * f2.denom + f1.denom * f2.nom;
		denom = f1.denom * f2.denom;
		fractionStandartization();
	}

	public static Fraction sum(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		f3.addition(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	public void subtract(Fraction f1, Fraction f2) {
		nom = f1.nom * f2.denom - f2.nom * f1.denom;
		denom = f1.denom * f2.denom;
		fractionStandartization();
	}

	public void subtract(Fraction f) {
		subtract(this, f);
		fractionStandartization();
	}

	public void multiply(Fraction f1, Fraction f2) {
		nom = f1.nom * f2.nom;
		denom = f1.denom * f2.denom;
		fractionStandartization();
	}

	public static Fraction dif(Fraction f1, Fraction f2) { // ???!!!
		Fraction f3 = new Fraction();
		f3.subtract(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	public void multiply(Fraction f) {
		multiply(this, f);
		fractionStandartization();
	}

	public static Fraction mult(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		f3.multiply(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	public void divide(Fraction f1, Fraction f2) throws ArithmeticException {
		if (f1.denom == 0 || f2.denom == 0)
			throw new ArithmeticException();
		nom = f1.nom * f2.denom;
		denom = f1.denom * f2.nom;
		fractionStandartization();
	}

	public void divide(Fraction f) throws ArithmeticException {
		divide(this, f);
		fractionStandartization();
	}

	public static Fraction div(Fraction f1, Fraction f2) throws ArithmeticException {
		Fraction f3 = new Fraction();
		f3.divide(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	public boolean compare(Fraction f1, Fraction f2, boolean comparing_var) {
		f1.reduction();
		f2.reduction();
		if (f1.nom == f2.nom && f1.denom == f2.denom)
			comparing_var = true;
		else if (f1.nom != f2.nom || f1.denom != f2.denom)
			comparing_var = false;
		return comparing_var;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Fraction))
			return false;
		Fraction f = (Fraction) o;
		return nom == f.getNom() && denom == f.getDenom();
	}
}
