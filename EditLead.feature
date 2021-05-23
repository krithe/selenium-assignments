Feature: Login to the Leaftaps Application to Edit Lead

Background:

Given Launch Chrome browser
When Load URL 'http://leaftaps.com/opentaps/control/login'
When Type username as 'Demosalesmanager'
And Type Password as 'crmsfa'
And Click Login Button
And Click CRMSFA
And Click Leads Tab

Scenario Outline: Edit the Lead with mandatory fields

When Click Find Leads Link
When Click Phone Tab
And Type Phone Number as <phonenumber>
And Click Find Leads Button
And Click on the First Resulting Lead
And Click on Edit Tab
And Clear Company name  
And Type Company name as <companyname>
And Click on update button



Examples:
|phonenumber|companyname|
|99|HCL|
|98|Ford|