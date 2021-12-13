# Test Plan

**Author**: Team 17

| Version | Description |
|---------------|----------------|
| V3 | 1. Final Testing Results 2. Update Test Cases |

This document includes various test cases that are created and executed to verify the functionality and usability of the `Job Offer Comparison` app developed by Team 17. The testing will be done manually and automated testing will be possibly performed. Any error and issue from testing results will be provided to developers to resolve.

## Testing Strategy

### 1.1 Overall Strategy
We will implement self-testing strategies at the **Unit-**, **Integration-**, **System-** and **Regression-** testing level using _JUnit_. A set of test cases are developed for the contracts specified for each of our files and ensure high levels of line coverage, so unit tests and regression tests will have some overlap. Integration tests will test the interaction between components to ensure that they behave correctly. At system testing level, we will perform a set of black box tests to ensure the behavior between service layer and controller layer.

* **Unit Testing** <br>
Unit testing is to test the smallest testable parts of the application, especially the individual class and its methods, in order to get the proper operations. <br>
Automated unit (white box) testing is developed from the `Design Document` and `Class Diagram` to test classes of `User`, `JobOffer`, `JobManager`, `UserWeights`, `JobComparer`, `Ranker` and their related methods.

* **Integraton Testing** <br>
Integration testing is to detect any inconsistencies within the individual software modules that are integrated together as a group. <br>
Integration testing is derived from the `Component Diagram` and `Deployment Diagram`. Each test has to ensure the group of combined components work properly.

* **System Testing** <br>
System testing takes the software components that have passed integration testing as the input, and seeks to detect defects within the system. <br>
System testing includes black-box tests which are derived from `Use Case Diagrams` to mak sure the system satisfies all the system requirements. 

* **Regression Testing** <br>
Regression testing is to test changes to the programs to make sure that the older programming still works with the new changes. <br>
When changes are made, all related system tests will be applied to regression testing.

### 1.2 Test Selection

* Unit testing is developed from the classes and their related methods using white-box approach.

* Integration testing for components and interfaces is developed from `Component Diagram` and `Deployment Diagram` using white-box approach.

* System testing and regression testing are developed from `Use Case Diagrams` using black-box approach.

### 1.3 Adequacy Criterion

To ensure the quality of unit, integration, system and regression tests, we will rely on code coverage, key boundary conditions and all system requirements. We will test app manually, record process and feedback the results.

* Unit testing should cover all critical and non-trivial classes and methods. 

* Integration testing should cover all critical integration cases.

* System and regression testing should cover all use cases.
   * User &rarr; createUser &rarr; deleteUser
   * User &rarr; updateUser &rarr; updateSalaryWeight &rarr; updateSigningBonusWeight &rarr; updateRetirementBenefitsWeight &rarr; updatePTOWeight
   * User &rarr; createJobOffer &rarr; deleteJobOffer
   * User &rarr; modifyJobOffer &rarr; updateCompany &rarr; updateSalary &rarr; updateSigningBonus &rarr; updateYearlyBonus &rarr; updateRetirementPcgMatch &rarr; updatePtoDays &rarr; updateLocation &rarr; updateTitle
   * User &rarr; selectJob &rarr; rankSelectedJobs

### 1.4 Bug Tracking
We will develop a bug list to track each bug linked to a specific test case, for the time being. 

* Unit testing: each class and method are tested. Error message will indicate which functions or parts need to be fixed.

* Integration testing: interactions between components are evaluated after passing Unit tests. Any error in this stage will point to the failed connection.

* System and Regression testing: run the whole system after passing Unit and Integration testing. Error messages will show the failed parts need to be fixed.

### 1.5 Technology

Unit and integration testing cases will be developed using _JUnit_ when possible. System and regression testing are performed manually.

## Test Cases

Test cases are executed to verify functionality and usability of the `Job Offer Comparison` app that should return expected results if the app works correctly.

| Test Case | Testing Steps | Expected Result | Actual Result | Pass/Fail | 
|-----------|--------------|-----------------|---------------|-----------|
| Starting app and enter main menu | click on app | show main menu | show main menus | Pass |
| Open user menu | click "+" button | show user and user weights menu | show user and user weights menu | Pass |
| Check default weights in user weights | 1. click "+" button 2. no input | show Salary weight = 1, Signing bonus weight = 1, Bonus weight = 1, Retirement weight = 1, PTO weight = 1 | show Salary weight = 1, Signing bonus weight = 1, Bonus weight = 1, Retirement weight = 1, PTO weight = 1 | Pass |
| Add user with empty user name | 1. click "+" button 2. don't entry anything into user name field 3. click Add | Error message "Please enter a username" | show Error message "Please enter a username" | Pass |
| Check weights setting in user weights | 1. click "+" button 2. enter SW = "5", SBW = "2", YBW = "1", RBW = "1", PW = "1" | return Salary weight = 5, Signing bonus weight = 2, Bonus weight = 1, Retirement weight = 1, PTO weight = 1 | show Salary weight = 5, Signing bonus weight = 2, Bonus weight = 1, Retirement weight = 1, PTO weight = 1 | Pass |
| Open select job menu | open select job | show job overview menu | show job overview menu | Pass |
| Add job offer with empty title | 1. click "+" button 2. don't entry anything into title field 3. click Add | Error message "Please enter a Job Title" | show Error message "Please enter a Job Title" | Pass |
| Add job offer with empty company | 1. click "+" button 2. don't entry anything into company field 3. click Add | Error message "Please enter a Company" | show Error message "Please enter a Company" | Pass |
| Add job offer with empty salary | 1. click "+" button 2. don't entry anything into salary field 3. click Add | use 0 for salary | use 0 for salary | Pass |
| Add job offer with empty signing bonus | 1. click "+" button 2. don't entry anything into signing bonus field 3. click Add | use 0 for signing bonus | use 0 for signing bonus | Pass |
| Add job offer with empty yearly bonus | 1. click "+" button 2. don't entry anything into yearly bonus field 3. click Add | use 0 for yearly bonus | use 0 for yearly bonus | Pass |
| Add job offer with empty retirement benefit | 1. click "+" button 2. don't entry anything into retirement benefit field 3. click Add | use 0 for retirement benefit | use 0 for retirement benefit | Pass |
| Add job offer with empty leave time | 1. click "+" button 2. don't entry anything into leave time field 3. click Add | use 0 for leave time | use 0 for leave time | Pass |
| Check location and cost of living | 1. click "+" button 2. choose "Boston, MA" from drop down 2. click Add | return CoL = "80.46" | CoL is 80.46 | Pass |
| Check location and cost of living | 1. click "+" button 2. choose "New York, NY" from drop down 2. click Add | return CoL = "100" | CoL is 100 | Pass |
| Check location and cost of living | 1. click "+" button 2. choose "Tampa, FL" from drop down 2. click Add | return CoL = "68.61" | CoL is 68.61 | Pass |
| Check location and cost of living | 1. click "+" button 2. choose "San Francisco, CA" from drop down 2. click Add | return CoL = "96.88" | CoL is 96.88 | Pass |
| Check location and cost of living | 1. click "+" button 2. choose "Los Angeles, CA" from drop down 2. click Add | return CoL = "77.66" | CoL is 77.66 | Pass |
| Check AddJob with All Inputs | 1. Title = "Software Engineer", Company = "Foo, Inc.", L = "Boston, MA", S = "100000", SB = "20000", B = "15000", RB = "3", P = "15" 2. click ADD | return Title = "Software Engineer", Company = "Foo, Inc.", L = "Boston, MA, United States", S = "100000", SB = "20000", B = "15000", RB = "3", P = "15", CoL = "80.46" | show Title = "Software Engineer", Company = "Foo, Inc.", L = "Boston, MA, United States", S = "100000", SB = "20000", B = "15000", RB = "3", P = "15", CoL = "80.46" | Pass |
| Delete job offer | 1. select JobOffer1 2. click "X" button | JobOffer1 is deleted | JobOffer1 is deleted | Pass |
| Test JobComparer and Ranker with Example1 | 1. Weights: SW = "5", SBW = "2", YBW = "1", RBW = "1", PW = "1"; 2. JobOffer1: L = "Boston, MA", S = "120000", SB = "10000", B = "12000", RB = "5", P = "15"; 3. JobOffer2: L = "New York, NY", S = "150000", SB = "20000", B = "20000", RB = "5", P = "15" | return JobOffer2 &rarr; JobOffer1 | show JobOffer2 &rarr; JobOffer1 | Pass |
| Test JobComparer and Ranker with Example2 | 1. Weights: SW = "5", SBW = "3", YBW = "2", RBW = "1", PW = "1"; 2. JobOffer1: L = "San Francisco, CA", S = "150000", SB = "10000", B = "12000", RB = "5", P = "15"; 3. JobOffer2: L = "New York, NY", S = "150000", SB = "20000", B = "20000", RB = "5", P = "15" | return JobOffer2 &rarr; JobOffer1 | show JobOffer2 &rarr; JobOffer1 | Pass |
| Test JobComparer and Ranker with Example3 | 1. Weights: SW = "5", SBW = "2", YBW = "1", RBW = "1", PW = "1"; 2. JobOffer1: L = "Boston, MA", S = "120000", SB = "10000", B = "12000", RB = "10", P = "15"; 3. JobOffer2: L = "New York, NY", S = "150000", SB = "20000", B = "20000", RB = "5", P = "15" | return JobOffer2 &rarr; JobOffer1 | show JobOffer2 &rarr; JobOffer1 | Pass |
| Test JobComparer and Ranker with Example4 | 1. Weights: SW = "5", SBW = "4", YBW = "3", RBW = "2", PW = "1"; 2. JobOffer1: L = "Los Angeles, CA", S = "120000", SB = "10000", B = "12000", RB = "10", P = "20"; 3. JobOffer2: L = "New York, NY", S = "150000", SB = "20000", B = "20000", RB = "5", P = "15" | return JobOffer2 &rarr; JobOffer1 | show JobOffer2 &rarr; JobOffer1 | Pass |
| Test Compute Score with Example1 | 1. Weights: SW = "5", SBW = "3", YBW = "2", RBW = "1", PW = "1"; 2. JobOffer1: L = "San Francisco, CA", S = "150000", SB = "10000", B = "12000", RB = "5", P = "15" | return score is 70547.22 | show show score is 70547.22 | Pass |
| Test Compute Score with Example2 | 1. Weights: SW = "5", SBW = "3", YBW = "2", RBW = "1", PW = "1"; 2. JobOffer1: L = "New York, NY", S = "150000", SB = "10000", B = "12000", RB = "5", P = "15" | return score is 68346.15 | show show score is 68346.15 | Pass |

* Notation: <br> 
L = Location, S = Salary, SB = Signing Bonus, B = Bonus, RB = Retirement Benefits, P = leave time or PTO, SW = Salary Weight, SBW = Signing Bonus Weight, YBW = Yearly Bonus Weight, RBW = retirement benefit weight, PW = PTO weight, CoL = Cost of Living.
* To adjust cost of living, we simply use (salary / cost of living * 100).
* To update the job offer, user needs to delete the job offer first and then add a new job offer again.


