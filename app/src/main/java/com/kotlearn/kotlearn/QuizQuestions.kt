package com.kotlearn.kotlearn

import android.text.Html

class QuizQuestions {

    private val questions = arrayOf("What is the difference between val and var in Kotlin?",
            "What does a data class not offer?",
            "What does this code do? \n\n foo()()",
            "Which of these targets does Kotlin currently not support?",
            "What are Kotlin coroutines?",
            "What is to in the example below: \n\n val test = 33 to 42",
            "What is the correct way to declare a variable of integer type in Kotlin?",
            "Which is true for the following simple class declaration? \n\n class person (val name: String)",
            "What is the correct syntax to convert the string \"42\" to a Long in Kotlin?",
            "Does Kotlin have primitive data types, such as int, long, float?",
            "What does the following code print? \n\n val listA = mutableListOf(1, 2, 3)\n val listB = listA.add(4) \n print(listB)",
            "What is the difference between a and b? \n\n var a: String? = \"kotlinQuiz\" \n var b: String = \"KotlinQuiz\" ",
            "What about java interoperability?",
            "What is a valid function declaration in Kotlin?",
            "What does the !! operator do?",
            "What is the output of the following code? \n\n val list: List<Int> = listOf(1, 2, 3) \n list.add(4) \n print(list)",
            "What is the key difference between Iterable<T> and Sequence<T> in Kotlin?",
            "What is the type of arr in the following code? \n\n val arr = arrayOf(1, 2, 3)",
            "What is the equivalent of the following Java expression in Kotlin? \n\n int x = a ? b : c",
            "What would be the Kotlin equivalent to a static method in Java?",
            "Under which license is Kotlin available?",
            "What does the following code print? \n\n val a: String? = null \n val b: String = \"Hello World\" \n println(a==b)"
            )

    private val multipleChoice = arrayOf(
            arrayOf("Variables declared with var are final, those with val are not",
                    "Variables declared with val are final, those with var are not",
                    "var is scoped to the nearest function block and val is scoped to the nearest enclosing block",
                    "Variables declared with val can only access const members"),
            arrayOf("An auto-generated toString() method",
                    "A generated copy(...) method, to create copies of instances",
                    "Automatic conversion from/to JSON",
                    "Auto-generated hashCode() and equals() methods"),
            arrayOf("Creates a two-dimensional array",
                    "Calls a function which is returned by the call of foo",
                    "Calls foo asynchronously",
                    "Fails compilation"),
            arrayOf("LLVM",
                    "JVM",
                    "JavaScript",
                    ".NET CLR"),
            arrayOf("They provide asynchronous code without thread blocking",
                    "These are functions which accept other functions as arguments or return them",
                    "That's how the automatically generated methods hashCode() and equals() in data classes are called",
                    "It's kotlin's term for class methods"),
            arrayOf("A kotlin keyword to create a Range from 33 to 42",
                    "A infix extension function creating a Pair(33, 42)",
                    "A Kotlin keyword to create a Pair(33,42)",
                    "A syntax error"),
            arrayOf("var i : Int = 42",
                    "var i : int = 42",
                    "int i = 42",
                    "let i = 42"),
            arrayOf("It has a private property \"name\"",
                    "It is package-private",
                    "It can be extended by other classes",
                    "It is public"),
            arrayOf("val l: Long = Long.parseLong(\"42\")",
                    "val l: Long = \"42\".toLong()",
                    "val l: Long = (Long)\"42\"",
                    "val l: Long = <Long>\"42\""),
            arrayOf("No, Kotlin does not have nor use primitive data types",
                    "Yes, but Kotlin internally always converts them to their non-primitive counterparts",
                    "No, not at language level. But the kotlin compiler makes use of JVM primitives for best performance",
                    "Yes, Kotlin is similar to Java in this respect"),
            arrayOf("Nothing, there is a compile error",
                    "[1, 2, 3, 4]",
                    "true",
                    "Unit"),
            arrayOf("b can never become null",
                    "a is volatile as in Java",
                    "a is final and cannot be changed",
                    "b is final and cannot be changed"),
            arrayOf("Kotlin can easily call Java code and vice versa",
                    "While Kotlin runs on the JVM, it cannot interoperate with Java",
                    "Kotlin can easily call Java code while Java cannot access code written in Kotlin",
                    "Kotlin provides a compatibility layer for Java interoperability which comes with some cost at runtime"),
            arrayOf("int sum(int a, int b",
                    "int sum(a: Int, b: Int",
                    "function sum(a: Int, b: Int): Int",
                    "fun sum(a: Int, b: Int): Int"),
            arrayOf("It compares two values for identity rather than equality",
                    "It's the modulo operator in Kotlin, similar to Java's %",
                    "It returns the left-hand operand if the operand is not null; otherwise it returns the right hand operand",
                    "It converts any value to a non-null type and throws an exception if the value is in fact null"),
            arrayOf("It does not compile, as listOf is not known",
                    "[1, 2, 3, 4]",
                    "[5, 6, 7]",
                    "It does not compile as List has no add method"),
            arrayOf("Sequences are processed sequentially, Iterables in parallel (multithreaded",
                    "There is no difference, as Sequence<T> is Kotlin's term for Iterable<T>",
                    "Iterable<T> works only on an immutable collections, Sequence<T> is also applicable to mutable ones",
                    "Sequences are processed lazily, Iterables eagerly"),
            arrayOf("int[]",
                    "IntArray",
                    "Int[]",
                    "Array<Int>"),
            arrayOf("val x = a ? b : c",
                    "val x = if (a) b else c",
                    "val x = a ? b, c",
                    "val x = if (a) b : c"),
            arrayOf("class Foo {\n   companion object {\n      fun bar() : String = \"Kotlin\" \n   }\n } ",
                    "class Foo {\n   static fun bar() : String = \"Kotlin\"\n}",
                    "Class Foo {\n   @static fun bar() : String = \"Kotlin\"\n}",
                    "Class Foo {\n   sta fun bar() : String = \"Kotlin\"\n }"),
            arrayOf("Apache 2",
                    "GPL",
                    "Kotlin is closed source, commercial software",
                    "MIT"),
            arrayOf("Nothing, but throws NullPointerException",
                    "true",
                    "Does not compile",
                    "false")
    )

    private val mCorrectAnswers = arrayOf(2,
            3,
            2,
            4,
            1,
            2,
            1,
            4,
            2,
            3,
            3,
            1,
            1,
            4,
            4,
            4,
            4,
            4,
            //equivalent java expression//
            2,
            //static method//
    1,
            //licence
    1,
            //print
    4)

    // method returns number of questions
    fun getLength(): Int {
        return questions.size
    }

    // method returns question from array textQuestions[] based on array index
    fun getQuestion(n: Int): String {
        return questions[n - 1]
    }

    fun getChoice(index: Int, num: Int): String {
        return (multipleChoice[index -1])[num - 1]
    }

    //  method returns correct answer for the question based on array index
    fun getCorrectAnswer(n: Int): Int {
        return mCorrectAnswers[n - 1]
    }

}