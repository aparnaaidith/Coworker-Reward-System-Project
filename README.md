# Coworker-Reward-System-Project
A website was created that allowed all employees to thank each other using a system of points and rewards. And also employees could use points they have been given to turn them into gift cards.

## Task: 
Create an Oracle database and website to accomplish the goal. 

## Requirements:
The following is required the database:
*	As mentioned above, users:
  1. One administrator – they can see reports but cannot give or receive points
  2. Five individual users – they cannot see reports; they can only give and redeem points
* At least one stored procedure using a transaction to handle the giving of points from one user to another
*	At least one view that simplifies how the admin gets raw report data for all users of the system. This could be used to power a report below or for some other purpose
*	At least one sequence must be used for a primary key
*	All passwords must be encrypted somehow
*	At least one trigger must be used
*	Foreign keys are required on your tables as appropriate
*	Sample data for the two previous months – you will need to create a way to insert random but valid data into your tables (part of building a system is figuring out how to test it)
*	Three reports (these should show up on the website but do not need to be fancy, the data can be raw on the page)
  1. One that shows the aggregate usage of points on a monthly basis – both rewards given out and rewards cashed in, as well as broken down by user, ranked in order of most points received to least
  2. One that shows who isn’t giving out all of their points for the most recent month only (including those that haven’t used any) 
  3. One that shows all redemptions, by month by user, for the previous two months
  
## Technology Requirements:
* ORACLE SQL Developer
* Java servlets
* JSP

