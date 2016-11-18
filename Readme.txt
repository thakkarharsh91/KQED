The application is a simple webpage consisting of four different fields as Name, Email, Subject and Body.

Each of these fields has different validations as :
1. The Name field should be of minimum length of 3 characters
2. The email field should contain the email address value in the proper email format.
3. The Subject should be of minimum length of 3 characters and
4. The Body shou;d be of minimum length of 10 characters

Unless and until all the above conditions are met, the Submit button won't be enable and user won't be able to send the email.

Abstraction in send Email functionality:

I have used two API's as MailGun and SendGrid for send email functionality.

1. Now there is a random boolean flag used to pick any of the API at a time. This is simply done to make sure that there is not enough load on just one API.
2. If the MailGun Api is being selected at random, then 3 attempts are being made to send the email using MailGun API if each attempt to send email is not successfull. Now even if the mail is not being sent after the third attempt, then the application sends the email using the SendGrid API. This is true for other case also where the SendGrid API is being selected first at random.

Code Repository:
