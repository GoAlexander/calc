
class A {
	/*
	 * static String sign; static int n=2; static Fraction numbers[]=new
	 * Fraction[n];
	 */

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
		String[] arr;
		String a[] = s.split(" ");
		arr=new String[a.length];
		Fraction[] arr2=new Fraction[a.length]; //make it smaller?
		for(int i=0;i<a.length;i++)
			arr[i]=a[i];
		
		int j=0;
		for(int i=0;i<a.length;i++) { //a.length -> may be potential mistake!
			//if((arr[i]!="+")&&(arr[i]!="-")&&(arr[i]!="*")&&(arr[i]!="%")){ //also make processing of /
			if( !arr[i].equals("+") && !arr[i].equals("-") && !arr[i].equals("*") && !arr[i].equals("%") ){ //also make processing of /
				arr2[j]= new Fraction(arr[i]);
				j++;
				
			}
		}
		
		Fraction cache = new Fraction (0); //it saves result of last operation
		//Fraction f = new Fraction (0);
		int index_of_first_sign=0;

		/*
		System.out.println("Internal test: ");
		arr2[0].print();
		arr2[1].print();
		arr2[2].print();
		*/
		
		//for first 2 elements:
		for(int i=0;i<a.length;i++) {
			if (arr[i].equals("+")) {
				//f=Fraction.sum(new Fraction(arr2[i-1]),new Fraction(arr2[i+1]));
				cache=Fraction.sum(arr2[0], arr2[1]);
				index_of_first_sign=i;
				break;
			}
		}
		
		/*
		System.out.println("!!! ->" + index_of_first_sign);
		cache.print();
		for(int i=0;i<a.length;i++) {
			System.out.println(i + ": " + arr[i]);
		}
		*/
		
		//TODO here make checking if string is long
		//for next elements:
		j=2;
		for(int i=index_of_first_sign+1;i<a.length;i++) {
			if (arr[i].equals("+")) {
				cache=Fraction.sum(cache, arr2[j]);
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
