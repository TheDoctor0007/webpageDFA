/* DFA Machine for reading Web Pages
 * 
 * Author: Parth Mistry
 * 
 */

import java.util.Scanner;

public class webpageDFA {
	static String web;
	static int i = 0;
	static char c;
	static String ret = "Accepted";
	
	//Letters must always be lowercase so all functions check that
	//All functions return a string, "Accepted", or "Rejected", which chains back through all functions to the call to q1 in main
	//All non-final / non-ending functions / states return "Rejected" if it has reached end of input string
	//All non-trap functions call qTrap if it reads an unexpected input
	
	/* q1 is the Start state, it reads in a character to see where it should be forwarded:
	 * q2 if first character is 'w'
	 * q14 if it is any other letter
	 */
	public static String q1() {
		System.out.println("q1");
		c = web.charAt(i);
		if (c == 'w') {
			if (i < web.length()) {
				i++;
				ret = q2();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q14();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q2 reads in a character to see where it should be forwarded:
	 * q3 if it is 'w'
	 * q15 if it is '.'
	 * q14 if it is any other letter
	 */
	public static String q2() {
		System.out.println(c + "\nq2");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'w') {
			if (i < web.length()) {
				i++;
				ret = q3();
			} else {
				ret = "Rejected";
			}
		} else if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q15();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q14();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q3 reads in a character to see where it should be forwarded:
	 * q4 if it is 'w'
	 * q15 if it is '.'
	 * q14 if it is any other letter
	 */
	public static String q3() {
		System.out.println(c + "\nq3");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'w') {
			if (i < web.length()) {
				i++;
				ret = q4();
			} else {
				ret = "Rejected";
			}
		} else if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q15();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q14();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q4 reads in a character to see where it should be forwarded:
	 * q5 if it is '.'
	 * q14 if it is a letter
	 */
	public static String q4() {
		System.out.println(c + "\nq4");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q5();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q14();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q5 reads in a character to see where it should be forwarded:
	 * q16 if it is 'c'
	 * q6 if it is any other letter
	 */
	public static String q5() {
		System.out.println(c + "\nq5");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'c') {
			if (i < web.length()) {
				i++;
				ret = q16();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q6();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q6 reads in a character to see where it should be forwarded:
	 * q7 if it is '.'
	 * q6 if it is a letter (recursively calls itself)
	 */
	public static String q6() {
		System.out.println(c + "\nq6");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q7();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q6();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q7 reads in a character to see where it should be forwarded:
	 * q8 if it is 'c'
	 */
	public static String q7() {
		System.out.println(c + "\nq7");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'c') {
			if (i < web.length()) {
				i++;
				ret = q8();
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q8 reads in a character to see where it should be forwarded:
	 * q9 if it is 'o'
	 */
	public static String q8() {
		System.out.println(c + "\nq8");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'o') {
			if (i < web.length()) {
				i++;
				ret = q9();
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q9 reads in a character to see where it should be forwarded:
	 * q10 if it is 'm'
	 * if reaches end of input string, it is "Accepted"
	 */
	public static String q9() {
		System.out.println(c + "\nq9");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Accepted";
		}
		if (c == 'm') {
			//System.out.println("read m");
			if (i < web.length()) {
				//System.out.println("could increment");
				i++;
				ret = q10();
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q10 reads in a character to see where it should be forwarded:
	 * q11 if it is '.'
	 * if reaches end of input string, it is "Accepted"
	 */
	public static String q10() {
		System.out.println(c + "\nq10");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Accepted";
		}
		if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q11();
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q11 reads in a character to see where it should be forwarded:
	 * q12 if it is 'c'
	 */
	public static String q11() {
		System.out.println(c + "\nq11");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'c') {
			if (i < web.length()) {
				i++;
				ret = q12();
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q12 reads in a character to see where it should be forwarded:
	 * q13 if it is 'o'
	 */
	public static String q12() {
		System.out.println(c + "\nq12");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'o') {
			if (i < web.length()) {
				i++;
				ret = q13();
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q13 is the final end state and accepts if it correctly reaches end of input here,
	 * otherwise, it calls qTrap
	 */
	public static String q13() {
		System.out.println(c + "\nq13");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Accepted";
		}
		if (i != web.length()) {
			ret = qTrap();
		}
		return ret;
	}
	
	/* q14 reads in a character to see where it should be forwarded:
	 * q15 if it is '.'
	 * q14 if it is a letter (recursively calls itself)
	 */
	public static String q14() {
		System.out.println(c + "\nq14");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q15();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q14();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q15 reads in a character to see where it should be forwarded:
	 * q8 if it is 'c'
	 */
	public static String q15() {
		System.out.println(c + "\nq15");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'c') {
			if (i < web.length()) {
				i++;
				ret = q8();
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q16 reads in a character to see where it should be forwarded:
	 * q17 if it is 'o'
	 * q6 if it is any other letter
	 */
	public static String q16() {
		System.out.println(c + "\nq16");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (c == 'o') {
			if (i < web.length()) {
				i++;
				ret = q17();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q6();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q17 reads in a character to see where it should be forwarded:
	 * q18 if it is 'm'
	 * q7 if it is '.'
	 * q6 if it is any other letter
	 * if reaches end of input string, it is "Accepted"
	 */
	public static String q17() {
		System.out.println(c + "\nq17");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Accepted";
		}
		if (c == 'm') {
			if (i < web.length()) {
				i++;
				ret = q18();
			} else {
				ret = "Rejected";
			}
		} else if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q7();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q6();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* q18 reads in a character to see where it should be forwarded:
	 * q7 if it is '.'
	 * q6 if it is any letter
	 * if reaches end of input string, it is "Accepted"
	 */
	public static String q18() {
		System.out.println(c + "\nq18");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Accepted";
		}
		if (c == '.') {
			if (i < web.length()) {
				i++;
				ret = q7();
			} else {
				ret = "Rejected";
			}
		} else if (Character.isLetter(c)) {
			if (i < web.length()) {
				i++;
				if (Character.isUpperCase(c)) {
					ret = qTrap();
				} else {
					ret = q6();
				}
			} else {
				ret = "Rejected";
			}
		} else {
			if (i < web.length()) {
				i++;
				ret = qTrap();
			} else {
				ret = "Rejected";
			}
		}
		return ret;
	}
	
	/* qTrap is the trap state
	 * it recursively calls itself until it reaches the end of the input string
	 * it will reject the string because trap is always a reject state
	 */
	public static String qTrap() {
		System.out.println(c + "\nqTrap");
		if (i < web.length()) {
			c = web.charAt(i);
		} else {
			return "Rejected";
		}
		if (i < web.length()) {
			i++;
			ret = qTrap();
		} else {
			ret = "Rejected";
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(
				"Project 1 for CS 341\n" +
				"Written by: Parth Mistry, prm46\n" +
				"Instructor: Marvin Nakayama, marvin@njit.edu\n");
		String confirm;
		//program runs until user says 'n' or no to inputing another web address
		//any web addresses entered are then tested by calling q1, which in turn will call the appropriate states as described above
		//if it successfully reaches an end state, it is "Accepted", otherwise, it is "Rejected"
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to input a web address? (y/n)");
			String run = sc.next().toLowerCase();
			if (!run.equals("n") && !run.equals("y")) {
				System.err.println("Unrecognized Input: Please try again.");
				continue;
			}
			else if (run.equals("n")) {
				System.out.println("Goodbye.");
				sc.close();
				System.exit(0);
			}
			else if (run.equals("y")) {
				i = 0;
				System.out.println("Please enter a web address:");
				web = sc.next();
				confirm = q1();
				System.out.println(confirm);
			}
		}
	}

}
