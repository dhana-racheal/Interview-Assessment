Feature: Kynhood Home page Validation


Scenario: Validate the location details of the home feed contents
Given User is on the Home page "https://kynhood.com"
When User scroll through the Home feed contents
And User verify the location mapped to these contents is either "Anna Nagar" or "Mylapore" or "T Nagar"


Scenario: Validate the contents of the first two klips
Given User is on the Home page "https://kynhood.com"
When User switch to the klips screen
Then User validate the title and user profile name of the first two or three klips


