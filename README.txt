Implementation of fraction calculator. University project (lab5, "OOP", HSE).

The main idea of this project: learn how to use Junit and tests overall.

Usage of this calculator:
	Just start it and enter all expressions you want.

This Calculator supports (for Calc.java):
	-Operations:
		+, -, *, %
	-Brackets
	-Priority of brackets, * and %
	-you can enter with or without spaces


Feature of this program is that there are two calculation classes(!) each has own algorithm (see below).


1) Main.java
	Launcher of console interface (calculation "engine" is Calc.java)

2) MainPoland.java
	Launcher of console interface (calculation "engine" is Poland.java)

3) Fraction.java
	Class of fraction (what is fraction + all operations). In our calculator all numbers are fraction!

4) Calc.java
	Here there is the code for calculation of expressions (our own algorithm)

5) CalcTest.java
	Tests of all program (with Calc.java "engine")

6) Poland.java
	Here there is the code for calculation of expressions. Algorithm of Reverse Poland Notation (RPN). The basis was taken from http://habrahabr.ru/sandbox/56187/ (thx :)) but with rewriting in Java, refactoring, fixes and out additions.

	Feature: the original RPN can not calculate such expressions: <-1 + 1> but with our program can calculate it!
	(Algorithm: <-1 + 1> -> <0 -1 + 1>)

7) PolandTest.java
	Tests of all program (with Calc.java "engine")


 ===========
|Milestone 2|
 ===========

Implementation of GUI.java, BigGUI.java and History.java.

Our calculator has GUI!
Its "engine" is Poland.java.

GUI.java is minimalistic interface.

BigGUI.java is serious calculator GUI.

In addition, calcs have undo/redo and history features.
