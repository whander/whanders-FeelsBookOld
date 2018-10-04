# whanders-FeelsBook

Used Resources:
https://stackoverflow.com/questions/15393899/how-to-close-activity-and-go-back-to-previous-activity-in-android  
https://stackoverflow.com/questions/15328324/java-lang-runtimeexception-failed-to-invoke-public-com-example-syncapp-messageb  
https://stackoverflow.com/questions/5821051/how-to-display-the-value-of-a-variable-on-the-screen  
https://stackoverflow.com/questions/6900437/android-app-unable-to-start-activity-componentinfo  
https://stackoverflow.com/questions/12288629/how-do-i-get-a-variable-in-another-activity
https://stackoverflow.com/questions/2592501/how-to-compare-dates-in-java
https://eclass.srv.ualberta.ca/mod/forum/discuss.php?d=1044559
https://mincong-h.github.io/2017/02/16/convert-date-to-string-in-java/
https://stackoverflow.com/questions/5153496/how-can-i-compare-two-strings-in-java-and-define-which-of-them-is-smaller-than-t

Code borrowed from https://github.com/joshua2ua/lonelyTwitter/tree/f15tuesday and edited. Code for LonelyTwitteActivity, onCreate, onStart, SaveInFile, LoadFromFile, ImportantPost, Post, NormalPost, PostTooLongException.

Issues: Date format is not properly enforced when updating the date on a post (the app assumes the user inputs the date in correctly). Also, history must be accessed before a post can be edited or deleted (not sure if this is an issue, but it's here for clarification on how the app works).
