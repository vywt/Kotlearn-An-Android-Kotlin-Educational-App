package com.kotlearn.kotlearn

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import kotlinx.android.synthetic.*
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuizFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    var currentQuestionNumber : Int = 1
    var quizQuestions : QuizQuestions = QuizQuestions()
    var score : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_quiz, container, false)

        val radioGroup = rootView.findViewById<RadioGroup>(R.id.quizRadioGroup)
        var questionNumber = rootView.findViewById<TextView>(R.id.quizQuestionNumber)
        var quizQuestion = rootView.findViewById<TextView>(R.id.quizQuestion)
        val option1 = rootView.findViewById<RadioButton>(R.id.option1)
        val option2 = rootView.findViewById<RadioButton>(R.id.option2)
        val option3 = rootView.findViewById<RadioButton>(R.id.option3)
        val option4 = rootView.findViewById<RadioButton>(R.id.option4)
        val submit = rootView.findViewById<Button>(R.id.quizSubmit)
        var tv_score = rootView.findViewById<TextView>(R.id.tv_score)
        var selectedAnswer : Int = 0

        val bottomSheet : View = rootView.findViewById<View>(R.id.bottomSheet)
        val bottomSheetBehavior : BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffSet: Float) {
                Toast.makeText(getContext(), "Onslide function called", Toast.LENGTH_LONG).show()
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
//                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(getContext(), "Dragging", Toast.LENGTH_LONG).show()
//                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(getContext(), "expanded", Toast.LENGTH_LONG).show()
//                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(getContext(), "collapsed", Toast.LENGTH_LONG).show()
//                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(getContext(), "hidden", Toast.LENGTH_LONG).show()
//                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(getContext(), "settling", Toast.LENGTH_LONG).show()
                }
            }
        }
        )

        val wb = rootView.findViewById<WebView>(R.id.bottomSheet_webView)
        wb.loadUrl("file:///android_asset/explanation1.html");

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        questionNumber.setText("Question " + currentQuestionNumber + ":")
        quizQuestion.setText(quizQuestions.getQuestion(1))
        tv_score.setText("Score: " + score)
        option1.setText(quizQuestions.getChoice(1,1))
        option2.setText(quizQuestions.getChoice(1,2))
        option3.setText(quizQuestions.getChoice(1,3))
        option4.setText(quizQuestions.getChoice(1,4))

        submit.setOnClickListener{
            if (!option1.isChecked() && !option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
                Toast.makeText(getContext(), "Please select an option!", Toast.LENGTH_LONG).show()
            } else {
                if (option1.isChecked()) {
                    selectedAnswer = 1
                } else if (option2.isChecked()) {
                    selectedAnswer = 2
                } else if (option3.isChecked()) {
                    selectedAnswer = 3
                } else if (option4.isChecked()) {
                    selectedAnswer = 4
                }
                checkAnswer(selectedAnswer, quizQuestion, option1, option2, option3, option4, questionNumber, radioGroup, tv_score, submit, bottomSheetBehavior, wb)
            }
        }

        return rootView
    }

    fun checkAnswer(selectedAnswer : Int,
                       quizQuestion : TextView,
                       option1 : RadioButton,
                       option2 : RadioButton,
                       option3 : RadioButton,
                       option4 : RadioButton,
                       questionNumber : TextView,
                       radioGroup : RadioGroup,
                       tv_score : TextView,
                       submit : Button,
                    bottomSheetBehavior: BottomSheetBehavior<View>,
                    wb : WebView) {

        //Toast.makeText(getContext(), "placeholder", Toast.LENGTH_LONG).show()

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        if (selectedAnswer == quizQuestions.getCorrectAnswer(currentQuestionNumber)) {
            score++
            tv_score.setText("Score: " + score)
            //to add more stuff
            Toast.makeText(getContext(), "Correct", Toast.LENGTH_SHORT).show()
            if (selectedAnswer == 1) {
                option1.setTextColor(Color.GREEN)
            } else if (selectedAnswer == 2) {
                option2.setTextColor(Color.GREEN)
            } else if (selectedAnswer == 3) {
                option3.setTextColor(Color.GREEN)
            } else if (selectedAnswer == 4) {
                option4.setTextColor(Color.GREEN)
            }
        } else {
            if (selectedAnswer == 1) {
                option1.setTextColor(Color.RED)
            } else if (selectedAnswer == 2) {
                option2.setTextColor(Color.RED)
            } else if (selectedAnswer == 3) {
                option3.setTextColor(Color.RED)
            } else if (selectedAnswer == 4) {
                option4.setTextColor(Color.RED)
            }
            when (quizQuestions.getCorrectAnswer(currentQuestionNumber)) {
                1 -> option1.setTextColor(Color.GREEN)
                2 -> option2.setTextColor(Color.GREEN)
                3 -> option3.setTextColor(Color.GREEN)
                4 -> option4.setTextColor(Color.GREEN)
            }


        }

        submit.setText("Next Question")
        submit.setOnClickListener{
            changeQuestion(quizQuestion, option1, option2, option3, option4, questionNumber, radioGroup, tv_score, submit, bottomSheetBehavior, wb)
        }


    }

    fun changeQuestion(quizQuestion : TextView,
                          option1 : RadioButton,
                          option2 : RadioButton,
                          option3 : RadioButton,
                          option4 : RadioButton,
                          questionNumber : TextView,
                          radioGroup : RadioGroup,
                          tv_score : TextView,
                          submit : Button,
                       bottomSheetBehavior: BottomSheetBehavior<View>,
                       wb : WebView) {
        currentQuestionNumber++
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        if (currentQuestionNumber <= quizQuestions.getLength()) {
            questionNumber.setText("Question " + currentQuestionNumber + ":")
            quizQuestion.setText(quizQuestions.getQuestion(currentQuestionNumber))
            option1.setText(quizQuestions.getChoice(currentQuestionNumber,1))
            option1.setTextColor(Color.WHITE)
            option2.setText(quizQuestions.getChoice(currentQuestionNumber,2))
            option2.setTextColor(Color.WHITE)
            option3.setText(quizQuestions.getChoice(currentQuestionNumber,3))
            option3.setTextColor(Color.WHITE)
            option4.setText(quizQuestions.getChoice(currentQuestionNumber,4))
            option4.setTextColor(Color.WHITE)
//            option1.setTextColor(Color.BLACK)
//            option2.setTextColor(Color.BLACK)
//            option3.setTextColor(Color.BLACK)
//            option4.setTextColor(Color.BLACK)
            radioGroup.clearCheck()
            var newURL = "file:///android_asset/explanation" + currentQuestionNumber + ".html"
            wb.loadUrl(newURL);
            var selectedAnswer : Int = 0

            submit.setText("Submit")
            submit.setOnClickListener{
                if (!option1.isChecked() && !option2.isChecked() && !option3.isChecked() && !option4.isChecked()) {
                    Toast.makeText(getContext(), "Please select an option!", Toast.LENGTH_LONG).show()
                } else {
                    if (option1.isChecked()) {
                        selectedAnswer = 1
                    } else if (option2.isChecked()) {
                        selectedAnswer = 2
                    } else if (option3.isChecked()) {
                        selectedAnswer = 3
                    } else if (option4.isChecked()) {
                        selectedAnswer = 4
                    }
                    checkAnswer(selectedAnswer, quizQuestion, option1, option2, option3, option4, questionNumber, radioGroup, tv_score, submit, bottomSheetBehavior, wb)
                }
            }
        } else {
            //end of quiz
            val myIntent = Intent(getContext(), QuizCompletion::class.java)
            myIntent.putExtra("Score", score)
            score = 0
            currentQuestionNumber = 1
            questionNumber.setText("Question " + currentQuestionNumber + ":")
            quizQuestion.setText(quizQuestions.getQuestion(currentQuestionNumber))
            option1.setText(quizQuestions.getChoice(currentQuestionNumber,1))
            option1.setTextColor(Color.WHITE)
            option2.setText(quizQuestions.getChoice(currentQuestionNumber,2))
            option2.setTextColor(Color.WHITE)
            option3.setText(quizQuestions.getChoice(currentQuestionNumber,3))
            option3.setTextColor(Color.WHITE)
            option4.setText(quizQuestions.getChoice(currentQuestionNumber,4))
            option4.setTextColor(Color.WHITE)
            tv_score.setText("Score: 0")

            startActivity(myIntent)
        }


    }
}
