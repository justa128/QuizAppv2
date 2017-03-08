# QuizAppv2

The quiz is about Indusries of the Future.<br />
The app architecture is as follows:<br />
  1. The UI is organised in 5 screens: Home, Question 1, Question 2, Question 3, Question 4<br />
  2. For each screen there is a separate activity created. <br />
  3. A user can move between activites / questions by clicking next/previous buttons which are implemented as TextView fields.<br />
  4. In the Question 4 screen user click "Submit Answers" button. The score of the quiz is calculated and the result is displayed in a Toast message.<br />
  5. For each question user can receive 0 or 1 points. If the question is answered right a user gets 1 point, if not a user gets 0 points. Maximum score a user can get in the quiz is 4. Minimum is 0. The are no negative points.<br />
  6. The score for each question is passed between activities using intents.<br />
  7. The UI state of each question is saved using sharedPreferences.<br />
  8. Questions 2 and 4 are using a separate xml layout when the phone is in the landscape mode. The ScrollView is applied.<br />
  9. The app has a custom action bar style applied. Home screen has no action bar.<br />
  10. Question 3 has custom radiobutton styles applied.<br />


