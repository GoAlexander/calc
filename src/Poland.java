import java.util.Stack;

public class Poland {
	// РњРµС‚РѕРґ Calculate РїСЂРёРЅРёРјР°РµС‚ РІС‹СЂР°Р¶РµРЅРёРµ РІ РІРёРґРµ СЃС‚СЂРѕРєРё Рё РІРѕР·РІСЂР°С‰Р°РµС‚ СЂРµР·СѓР»СЊС‚Р°С‚,
	// РІ СЃРІРѕРµР№ СЂР°Р±РѕС‚Рµ РёСЃРїРѕР»СЊР·СѓРµС‚ РґСЂСѓРіРёРµ РјРµС‚РѕРґС‹ РєР»Р°СЃСЃР°
	static public Fraction Calculate(String input) {
		if(input.startsWith("-"))
			input = "0" + input;
		String output = GetExpression(input); // РџСЂРµРѕР±СЂР°Р·РѕРІС‹РІР°РµРј РІС‹СЂР°Р¶РµРЅРёРµ РІ
												// РїРѕСЃС‚С„РёРєСЃРЅСѓСЋ Р·Р°РїРёСЃСЊ
		Fraction result = Counting(output); // Р РµС€Р°РµРј РїРѕР»СѓС‡РµРЅРЅРѕРµ РІС‹СЂР°Р¶РµРЅРёРµ
		return result; // Р’РѕР·РІСЂР°С‰Р°РµРј СЂРµР·СѓР»СЊС‚Р°С‚
	}

	// РњРµС‚РѕРґ, РїСЂРµРѕР±СЂР°Р·СѓСЋС‰РёР№ РІС…РѕРґРЅСѓСЋ СЃС‚СЂРѕРєСѓ СЃ РІС‹СЂР°Р¶РµРЅРёРµРј РІ РїРѕСЃС‚С„РёРєСЃРЅСѓСЋ Р·Р°РїРёСЃСЊ
	static private String GetExpression(String input) {
		// String output = String.Empty; //РЎС‚СЂРѕРєР° РґР»СЏ С…СЂР°РЅРµРЅРёСЏ РІС‹СЂР°Р¶РµРЅРёСЏ
		String output = "";
		// Stack<char> operStack = new Stack<char>(); //РЎС‚РµРє РґР»СЏ С…СЂР°РЅРµРЅРёСЏ
		// РѕРїРµСЂР°С‚РѕСЂРѕРІ
		Stack<Character> operStack = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) // Р”Р»СЏ РєР°Р¶РґРѕРіРѕ СЃРёРјРІРѕР»Р° РІ
													// РІС…РѕРґРЅРѕР№ СЃС‚СЂРѕРєРµ
		{
			// Р Р°Р·РґРµР»РёС‚РµР»Рё РїСЂРѕРїСѓСЃРєР°РµРј
			if (IsDelimeter(input.charAt(i)))
				continue; // РџРµСЂРµС…РѕРґРёРј Рє СЃР»РµРґСѓСЋС‰РµРјСѓ СЃРёРјРІРѕР»Сѓ

			// Р•СЃР»Рё СЃРёРјРІРѕР» - С†РёС„СЂР°, С‚Рѕ СЃС‡РёС‚С‹РІР°РµРј РІСЃРµ С‡РёСЃР»Рѕ
			if (Character.isDigit(input.charAt(i))) // Р•СЃР»Рё С†РёС„СЂР°
			{
				// Р§РёС‚Р°РµРј РґРѕ СЂР°Р·РґРµР»РёС‚РµР»СЏ РёР»Рё РѕРїРµСЂР°С‚РѕСЂР°, С‡С‚Рѕ Р±С‹ РїРѕР»СѓС‡РёС‚СЊ С‡РёСЃР»Рѕ
				while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) {
					output += input.charAt(i); // Р”РѕР±Р°РІР»СЏРµРј РєР°Р¶РґСѓСЋ С†РёС„СЂСѓ С‡РёСЃР»Р° Рє
												// РЅР°С€РµР№ СЃС‚СЂРѕРєРµ
					i++; // РџРµСЂРµС…РѕРґРёРј Рє СЃР»РµРґСѓСЋС‰РµРјСѓ СЃРёРјРІРѕР»Сѓ

					if (i == input.length())
						break; // Р•СЃР»Рё СЃРёРјРІРѕР» - РїРѕСЃР»РµРґРЅРёР№, С‚Рѕ РІС‹С…РѕРґРёРј РёР· С†РёРєР»Р°
				}

				output += " "; // Р”РѕРїРёСЃС‹РІР°РµРј РїРѕСЃР»Рµ С‡РёСЃР»Р° РїСЂРѕР±РµР» РІ СЃС‚СЂРѕРєСѓ СЃ
								// РІС‹СЂР°Р¶РµРЅРёРµРј
				i--; // Р’РѕР·РІСЂР°С‰Р°РµРјСЃСЏ РЅР° РѕРґРёРЅ СЃРёРјРІРѕР» РЅР°Р·Р°Рґ, Рє СЃРёРјРІРѕР»Сѓ РїРµСЂРµРґ
						// СЂР°Р·РґРµР»РёС‚РµР»РµРј
			}

			// Р•СЃР»Рё СЃРёРјРІРѕР» - РѕРїРµСЂР°С‚РѕСЂ
			if (IsOperator(input.charAt(i))) // Р•СЃР»Рё РѕРїРµСЂР°С‚РѕСЂ
			{
				if (input.charAt(i) == '(') // Р•СЃР»Рё СЃРёРјРІРѕР» - РѕС‚РєСЂС‹РІР°СЋС‰Р°СЏ СЃРєРѕР±РєР°
					operStack.push(input.charAt(i)); // Р—Р°РїРёСЃС‹РІР°РµРј РµС‘ РІ СЃС‚РµРє
				else if (input.charAt(i) == ')') // Р•СЃР»Рё СЃРёРјРІРѕР» - Р·Р°РєСЂС‹РІР°СЋС‰Р°СЏ
													// СЃРєРѕР±РєР°
				{
					// Р’С‹РїРёСЃС‹РІР°РµРј РІСЃРµ РѕРїРµСЂР°С‚РѕСЂС‹ РґРѕ РѕС‚РєСЂС‹РІР°СЋС‰РµР№ СЃРєРѕР±РєРё РІ СЃС‚СЂРѕРєСѓ
					Character s = operStack.pop();

					while (s != '(') {
						output += s.toString() + ' ';
						s = operStack.pop();
					}
				} else // Р•СЃР»Рё Р»СЋР±РѕР№ РґСЂСѓРіРѕР№ РѕРїРµСЂР°С‚РѕСЂ
				{
					// C# -> Count СЏРІР»СЏРµС‚СЃСЏ РєРѕР»РёС‡РµСЃС‚РІРѕРј СЌР»РµРјРµРЅС‚РѕРІ, РєРѕС‚РѕСЂС‹Рµ
					// С„Р°РєС‚РёС‡РµСЃРєРё СЃРѕРґРµСЂР¶Р°С‚СЃСЏ РІ Stack.
					// if (operStack.Count > 0) //Р•СЃР»Рё РІ СЃС‚РµРєРµ РµСЃС‚СЊ СЌР»РµРјРµРЅС‚С‹
					if (operStack.size() > 0) // Р•СЃР»Рё РІ СЃС‚РµРєРµ РµСЃС‚СЊ СЌР»РµРјРµРЅС‚С‹
						if (GetPriority(input.charAt(i)) <= GetPriority(operStack.peek())) // Р�
																							// РµСЃР»Рё
																							// РїСЂРёРѕСЂРёС‚РµС‚
																							// РЅР°С€РµРіРѕ
																							// РѕРїРµСЂР°С‚РѕСЂР°
																							// РјРµРЅСЊС€Рµ
																							// РёР»Рё
																							// СЂР°РІРµРЅ
																							// РїСЂРёРѕСЂРёС‚РµС‚Сѓ
																							// РѕРїРµСЂР°С‚РѕСЂР°
																							// РЅР°
																							// РІРµСЂС€РёРЅРµ
																							// СЃС‚РµРєР°
							output += operStack.pop().toString() + " "; // РўРѕ
																		// РґРѕР±Р°РІР»СЏРµРј
																		// РїРѕСЃР»РµРґРЅРёР№
																		// РѕРїРµСЂР°С‚РѕСЂ
																		// РёР·
																		// СЃС‚РµРєР°
																		// РІ
																		// СЃС‚СЂРѕРєСѓ
																		// СЃ
																		// РІС‹СЂР°Р¶РµРЅРёРµРј

					//operStack.Push(Character.Parse(input.charAt(i).toString())); 
					operStack.push(input.charAt(i));// Р•СЃР»Рё
																					// СЃС‚РµРє
																					// РїСѓСЃС‚,
																					// РёР»Рё
																					// Р¶Рµ
																					// РїСЂРёРѕСЂРёС‚РµС‚
																					// РѕРїРµСЂР°С‚РѕСЂР°
																					// РІС‹С€Рµ
																					// -
																					// РґРѕР±Р°РІР»СЏРµРј
																					// РѕРїРµСЂР°С‚РѕСЂРѕРІ
																					// РЅР°
																					// РІРµСЂС€РёРЅСѓ
																					// СЃС‚РµРєР°

				}
			}
		}

		// РљРѕРіРґР° РїСЂРѕС€Р»Рё РїРѕ РІСЃРµРј СЃРёРјРІРѕР»Р°Рј, РІС‹РєРёРґС‹РІР°РµРј РёР· СЃС‚РµРєР° РІСЃРµ РѕСЃС‚Р°РІС€РёРµСЃСЏ С‚Р°Рј
		// РѕРїРµСЂР°С‚РѕСЂС‹ РІ СЃС‚СЂРѕРєСѓ
		while (operStack.size() > 0)
			output += operStack.pop() + " ";

		return output; // Р’РѕР·РІСЂР°С‰Р°РµРј РІС‹СЂР°Р¶РµРЅРёРµ РІ РїРѕСЃС‚С„РёРєСЃРЅРѕР№ Р·Р°РїРёСЃРё
	}

	// РњРµС‚РѕРґ, РІС‹С‡РёСЃР»СЏСЋС‰РёР№ Р·РЅР°С‡РµРЅРёРµ РІС‹СЂР°Р¶РµРЅРёСЏ, СѓР¶Рµ РїСЂРµРѕР±СЂР°Р·РѕРІР°РЅРЅРѕРіРѕ РІ РїРѕСЃС‚С„РёРєСЃРЅСѓСЋ
	// Р·Р°РїРёСЃСЊ
	static private Fraction Counting(String input) {
		Fraction result = new Fraction(0);
		//double result = 0; // Р РµР·СѓР»СЊС‚Р°С‚
		//Stack<Double> temp = new Stack<Double>(); // Dhtvtyysq СЃС‚РµРє РґР»СЏ СЂРµС€РµРЅРёСЏ
		Stack<Fraction> temp = new Stack<Fraction>();
		for (int i = 0; i < input.length(); i++) // Р”Р»СЏ РєР°Р¶РґРѕРіРѕ СЃРёРјРІРѕР»Р° РІ СЃС‚СЂРѕРєРµ
		{
			// Р•СЃР»Рё СЃРёРјРІРѕР» - С†РёС„СЂР°, С‚Рѕ С‡РёС‚Р°РµРј РІСЃРµ С‡РёСЃР»Рѕ Рё Р·Р°РїРёСЃС‹РІР°РµРј РЅР° РІРµСЂС€РёРЅСѓ
			// СЃС‚РµРєР°
			if (Character.isDigit(input.charAt(i))) {
				String a = "";

				while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) // РџРѕРєР°
																						// РЅРµ
																						// СЂР°Р·РґРµР»РёС‚РµР»СЊ
				{
					a += input.charAt(i); // Р”РѕР±Р°РІР»СЏРµРј
					i++;
					if (i == input.length())
						break;
				}
				temp.push(new Fraction(a));
				//temp.push(Double.parseDouble(a)); // Р—Р°РїРёСЃС‹РІР°РµРј РІ СЃС‚РµРє
				i--;
			} else if (IsOperator(input.charAt(i))) // Р•СЃР»Рё СЃРёРјРІРѕР» - РѕРїРµСЂР°С‚РѕСЂ
			{
				// Р‘РµСЂРµРј РґРІР° РїРѕСЃР»РµРґРЅРёС… Р·РЅР°С‡РµРЅРёСЏ РёР· СЃС‚РµРєР°
				//Double a = temp.pop();
				//Double b = temp.pop();
				Fraction a = temp.pop();
				Fraction b = temp.pop();
				switch (input.charAt(i)) // Р� РїСЂРѕРёР·РІРѕРґРёРј РЅР°Рґ РЅРёРјРё РґРµР№СЃС‚РІРёРµ,
											// СЃРѕРіР»Р°СЃРЅРѕ РѕРїРµСЂР°С‚РѕСЂСѓ
				{
				case '+':
					result = Fraction.sum(b,a);
					break;
				case '-':
					result = Fraction.dif(b,a);
					break;
				case '*':
					result = Fraction.mult(b,a);
					break;
				case '/':
					result = Fraction.div(b,a);;
					break;
				/*case '^':
					//result = Double.parseDouble(Math.pow(Double.parseDouble(b.toString()), Double.parseDouble(a.toString())).toString());
					result = Math.pow(Double.parseDouble(b.toString()), Double.parseDouble(a.toString()));
					result = Double.parseDouble(Double.toString(result));
					break;*/
				}
				temp.push(result); // Р РµР·СѓР»СЊС‚Р°С‚ РІС‹С‡РёСЃР»РµРЅРёСЏ Р·Р°РїРёСЃС‹РІР°РµРј РѕР±СЂР°С‚РЅРѕ РІ
									// СЃС‚РµРє
			}
		}
		return temp.peek(); // Р—Р°Р±РёСЂР°РµРј СЂРµР·СѓР»СЊС‚Р°С‚ РІСЃРµС… РІС‹С‡РёСЃР»РµРЅРёР№ РёР· СЃС‚РµРєР° Рё
							// РІРѕР·РІСЂР°С‰Р°РµРј РµРіРѕ
	}

	// small functions:
	// РњРµС‚РѕРґ РІРѕР·РІСЂР°С‰Р°РµС‚ true, РµСЃР»Рё РїСЂРѕРІРµСЂСЏРµРјС‹Р№ СЃРёРјРІРѕР» - СЂР°Р·РґРµР»РёС‚РµР»СЊ ("РїСЂРѕР±РµР»"
	// РёР»Рё "СЂР°РІРЅРѕ")
	static private boolean IsDelimeter(char c) {
		if ((" =".indexOf(c) != -1))
			return true;
		return false;
	}

	// РњРµС‚РѕРґ РІРѕР·РІСЂР°С‰Р°РµС‚ true, РµСЃР»Рё РїСЂРѕРІРµСЂСЏРµРјС‹Р№ СЃРёРјРІРѕР» - РѕРїРµСЂР°С‚РѕСЂ
	static private boolean IsOperator(char СЃ) {
		if (("+-/*^()".indexOf(СЃ) != -1))
			return true;
		return false;
	}

	// РњРµС‚РѕРґ РІРѕР·РІСЂР°С‰Р°РµС‚ РїСЂРёРѕСЂРёС‚РµС‚ РѕРїРµСЂР°С‚РѕСЂР°
	static private byte GetPriority(char s) {
		switch (s) {
		case '(':
			return 0;
		case ')':
			return 1;
		case '+':
			return 2;
		case '-':
			return 3;
		case '*':
			return 4;
		case '/':
			return 4;
		/*case '^':
			return 5;*/
		default:
			return 6;
		}
	}
}