# Design Description -- Team 17

## Overview
This document provided the explanation of assumptions and rationale behind the design for each requirement listed in “GroupProjectD1”.

## Requirements and Explanation
1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).
   * To realize this requirement, we added a class of `User` several methods to address 1-4.
   * We accomplish (3) by adding a `UserWeights` object. In addition to other fields, a `User` has a `UserWeights` which will help personalize the results.
   * There is still a high-level `JobManager` class whose job is to orchestrate the `User` creation and also manage other requirements, such as 5-6
2. When choosing to _enter current job details_, a user will (1) Be shown a user interface to enter all of the details of the current job, (2) Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.
   * To realize this requirement, we added a class of `JobOffer`. In essence the user's current job is itself a `JobOffer`, it's just one they already took. Though we have broken this apart from the new offers.
3. When choosing to _enter job offers_, a user will be (1) Be shown a user interface to enter all of the details of the offer, (2) Be able to either save the job offer details or cancel, (3) Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer with the current job details (if present).
   * To realize this requirement, we continued to use the `JobOffer` class.
   * When a job offer is saved an instance of the `JobOffer` class is created and saved to database storage 
4. When _adjusting the comparison settings_, the user can assign integer weights. If no weights are assigned, all factors are considered equal.
   * These are captured by the aforementioned `UserWeights` class.
5. When choosing to _compare job offers_, a user will (1) Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated, (2) Select two jobs to compare and trigger the comparison, (3) Be shown a table comparing the two jobs, (4) Be offered to perform another comparison or go back to the main menu.
   * We accomplish this by creating a `JobComparer` class. The role of this class is to keep tabs on all selected `JobOffer`s and rank those offers through a `Ranker` class (see below).
6. When ranking jobs, a job’s score is computed as the **weighted** sum.
   * The `Ranker` class takes the `UserWeights` and all selected `JobOffer`s into account and orders the JobOffers based on the formula score
7. The user interface must be intuitive and responsive.
   * This is not represented in UML design, as it will be handled entirely within the GUI implementation.
8. The performance of the app should be such that users do not experience any considerable lag between their actions and the response of the app.
   * To improve the performance on the actions and the response of the app, we will refine the algorithm on the implementation and improve it through testing.
9. For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).
   * This is the assumption we used to create our design. The `User` class is the entry point to our system and allows a single system only.
   * It is assumed that the data that this application will consume will be able to fit on the device running the application so we can use local storage as our persistent storage