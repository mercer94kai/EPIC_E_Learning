Feature: Successfully register into E Learning website
				& send a mail using compose option

  @Registration_validation
  Scenario Outline: Validate registration process
  Given user is on Homepage <Befor login> using <browser>
  When clicked on Sign_up option 
  Then redirected to user Registration page
  And user enters <firstName>,<lastName>,<email>,<userId>,<password> & <confirmPasssword> details
  Then clicked on Registration button
  And validate acknowlefgement message and clicked on the icon on top right corner & validate the dropdown with <username>
  Then clicked on Homepage button and log out
   
  Examples:
  |browser  | firstName  |lastName |email |userId |password |confirmPasssword | username |
  |  "Chrome"	|"Aomine"	 | "Daiki"|"akadk@tou.com"|"Akaace"|"touhou@2020"|"touhou@2020"|"Aomine Daiki"|
   
  @Compose_mail_functionality_validation
  Scenario Outline: Validate Compose mail functionality
  Given Verify user logi credentials on Homepage using <userId>,<password>& <username> using <browser>
  When clicked on Compose option
  And user enters <send_to>,<subject> & <message> details
  Then clicked on Send Message button
  And user gets the confirmation message
  Then clicked on top right corner
  And clicked on Logout option
  
  Examples:
    |browser|userId |password|username|send_to  |subject |message |
  	|	"Chrome"|	"AkaEmpr"|"rakuzan@2020"|"Akashi Seijuro"|"naveen"|"Test1"|"Something"|
   
   