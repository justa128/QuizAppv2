# QuizAppv2

The quiz is about Indusries of the Future.<br />
The app architecture is as follows:<br />
  1. The UI is organised into 5 screens: Home, Question 1, Question 2, Question 3, Question 4.<br />
  2. For each screen there is a separate activity created. <br />
  3. A user can move between activites / questions by clicking next/previous buttons which are implemented as TextView fields.<br />
  4. In the Question 4 a user clicks "Submit Answers" button. The score of the quiz is calculated and the result is displayed in the Toast message.<br />
  5. For each question user can receive 0 or 1 points. If the question is answered correctly a user gets 1 point, if not a user gets 0 points. Maximum score a user can get in the quiz is 4. Minimum is 0. The are no negative points.<br />
  6. The score for each question is passed between activities using intents.<br />
  7. The UI state of each question is saved using sharedPreferences.<br />
  8. Questions 2 and 4 are using separate xml layouts when the phone is in the landscape mode. The ScrollView is applied.<br />
  9. The app has a custom action bar style applied. Home screen has no action bar.<br />
  10. Question 3 has custom radiobutton styles applied. Refer to xml files under res/drawable folder.
  
## Screenshots

**Home**<br />
![image](https://cloud.githubusercontent.com/assets/9053854/23696969/530b8a8a-03ff-11e7-9732-8ed97e453b3b.png)

**Question 1**<br />
![image](https://cloud.githubusercontent.com/assets/9053854/23697560/a5f58ff0-0401-11e7-8c28-a5551f1ffa0d.png)

**Question 2**<br />
![image](https://cloud.githubusercontent.com/assets/9053854/23700147/676d1fdc-040b-11e7-9415-c68b49d08588.png)

**Question 3**<br />
![image](https://cloud.githubusercontent.com/assets/9053854/23700177/7b04fd4e-040b-11e7-86ac-28428f3fda76.png)

**Question 4**<br />
![image](https://cloud.githubusercontent.com/assets/9053854/23700391/10aa871a-040c-11e7-9add-c09d14b6ea45.png)

I did not want to spoil the fun, so the answers in the above screenshots are not necessary correct :wink:


