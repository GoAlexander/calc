
public class Fraction { // rename -> FractionOperations???
	int nom, denom;

	Fraction(int nom, int denom) {
		setFraction(nom, denom);
	}

	Fraction() {
		this(0, 1);
	}

	Fraction(int nom) {
		this(nom, 1);
	}

	Fraction(String s) {
		try {
			if (s.contains("/")) {
				String[] parts = s.split("/");
				int part1 = Integer.parseInt(parts[0]);
				int part2 = Integer.parseInt(parts[1]);
				for (int i = 2; i < parts.length; i++)
					part2 *= Integer.parseInt(parts[i]);
				setFraction(part1, part2);
			} else
				setFraction(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			System.out.println("Wrong format!");
			setFraction(0);
		}
	}

	void setFraction(int nom, int denom) {
		this.nom = nom;
		this.denom = denom;
		fractionStandartization();
	}

	void setFraction(int nom) {
		setFraction(nom, 1);
	}

	int getNom() {
		return nom;
	}

	int getDenom() {
		return denom;
	}

	void print() { // print + checking (+processing_of_exeptions)
		if (nom == 0 && denom != 0)
			System.out.println(0);
		else if (denom == 1)
			System.out.println(nom);
		else if (denom == 0)
			System.out.println("Error! Your denom =0, start new program!");
		else
			System.out.println(nom + "/" + denom);
	}

	void reduction() { // сокращение дроби (Но! если число на вход
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
		nom *= tmp; // проверить (я решил сделать без проверки!!!)
	}

	void sign() { // проверка на знак + выводим знак только (при вводе
					// интегрировать проверку!!!)
		if (nom < 0 && denom < 0 || nom > 0 && denom < 0) {
			nom *= -1;
			denom *= -1;
		}
	}

	void fractionStandartization() {
		sign();
		reduction();
	}

	// CДЕЛАТЬ ЧЕРЕЗ RETURN!!! //проверить на отрицательные числа!
	void addition(Fraction f2) { // сложение двух дробей
		if (denom != f2.denom) {
			nom = nom * f2.denom + denom * f2.nom;
			denom = denom * f2.denom;
		} else { // Не безопасно???
			nom = nom + f2.nom;
		}
		fractionStandartization();
	}

	Fraction addition(Fraction f1, Fraction f2) { // сложение двух дробей
		if (f1.denom != f2.denom) {
			this.nom = f1.nom * f2.denom + f1.denom * f2.nom;
			this.denom = f1.denom * f2.denom;
		} else { // Не безопасно???
			this.nom = f1.nom + f2.nom;
		}
		// reduction();
		return this;
	}

	public static Fraction sum(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		f3.addition(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	void subtract(Fraction f1, Fraction f2) {
		nom = f1.nom * f2.denom - f2.nom * f1.denom;
		denom = f1.denom * f2.denom;
		fractionStandartization();
	}

	void subtract(Fraction f) {
		subtract(this, f);
		fractionStandartization();
	}

	void multiply(Fraction f1, Fraction f2) {
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

	void multiply(Fraction f) {
		multiply(this, f);
		fractionStandartization();
	}

	public static Fraction mult(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		f3.multiply(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	void divide(Fraction f1, Fraction f2) {
		nom = f1.nom * f2.denom;
		denom = f1.denom * f2.nom;
		fractionStandartization();
	}

	void divide(Fraction f) {
		divide(this, f);
		fractionStandartization();
	}

	public static Fraction div(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		f3.divide(f1, f2);
		f3.fractionStandartization();
		return f3;
	}

	
	boolean compare(Fraction f1, Fraction f2, boolean comparing_var) {
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
