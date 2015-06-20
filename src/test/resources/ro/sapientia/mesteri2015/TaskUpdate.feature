Feature: Check if the scrum update works
	As Sapientia scrum tool user I want to be able to update a task

   Scenario: UpdateFirst
   Given I edit the scrum list's first task
   When I enter "newtitle" in  the title textbox and I push the update button
   Then I should get result "newtitle" in new tasks list