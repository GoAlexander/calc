
class Calc {

	private static String parse(String s) {
		String str = s.trim();
		/*if (str.contains("\\+")) {
			String a[]=str.split("\\+");
			str=a[0]+" "+"+"+" "+a[1];
		}*/
		
		/*for (int i=0; i < str.length(); i++) {
			
			
			if (a[i].equals("+") || a[i].equals("-") || a[i].equals("*") || a[i].equals("%")) {
				sign = a[i];
			}
			else {
				numbers[j]= new Fraction (a[i]);
				j++;
			}
			str=str+a[i];
			
		}*/
		
		return str;
	}

	static Fraction calculate(String s) {
		String[] expression_str_line;
		String a[] = s.split(" ");
		expression_str_line=new String[a.length];
		Fraction[] frac_number=new Fraction[a.length]; //make it smaller?
		for(int i=0;i<a.length;i++)
			expression_str_line[i]=a[i];
		
		int j=0;
		for(int i=0;i<a.length;i++) { //a.length -> may be potential mistake!
			//also make processing of /
			if( !expression_str_line[i].equals("+") && !expression_str_line[i].equals("-") && !expression_str_line[i].equals("*") && !expression_str_line[i].equals("%") ){ //also make processing of /
				frac_number[j]= new Fraction(expression_str_line[i]);
				j++;
				
			}
		}
		
		Fraction cache = new Fraction (0); //it saves result of last operation
		int index_of_first_sign=0;
		
		//for first 2 elements:
		for(int i=0;i<a.length;i++) {
			if (expression_str_line[i].equals("+")) {
				//f=Fraction.sum(new Fraction(frac_number[i-1]),new Fraction(frac_number[i+1]));
				cache=Fraction.sum(frac_number[0], frac_number[1]);
				index_of_first_sign=i;
				break;
			}
		}
		
		//TODO here make checking if string is long
		//for next elements:
		j=2;
		for(int i=index_of_first_sign+1;i<a.length;i++) {
			if (expression_str_line[i].equals("+")) {
				cache=Fraction.sum(cache, frac_number[j]);
				j++;
			}
		}	

		
		//Fraction f = Fraction.sum(new Fraction(a[0]),new Fraction(a[1]));

		// test
		// numbers[0].print();
		// numbers[1].print();

		//Fraction f;
		// f=new Fraction(Fraction.sum(new Fraction(a[0]),new Fraction(a[1])));
		// return Fraction.sum(numbers[0],numbers[1]);
		return cache;
	}
}
