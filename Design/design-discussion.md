# Design Discussion &mdash; Team 17

## Overview
This document showed the discussion and collaboration of team members to create the team design. The concise descriptions of individual pros and cons about the team design were shown in the respective section of each team member. The “Summary” section included the teamwork, process and learned lesson.

## Team Design  
![Team Design](teamdesign.jpg) 
  
## Joshua Kahn (jkahn31)
### Pros:
* Our design breaks apart the requirements into several logical chunks. There's the data itself (e.g. `User`), job ranking (e.g. `Ranker`), and offer selection (e.g. `JobComparer`) to name a few. Each of these serves a unique purpose and allows us to avoid sharing functionality across layers of the application. A separation of concerns allows us to reduce the code changes necessary to update the application.
* In the same vein, the `JobManager` and `JobComparer` are separated because they 'care' about different aspects of the application. The former cares about the high level job and user creation. One might think of this as 'main'.
* Our data classes also try to be as immutable as possible. While this can create some issues later (see cons), it's a useful development feature since it makes debugging easier. We don't have setters; instead the caller is expected to make a new copy with the modified parameters. This is particularly useful for the stored classes (e.g. `User`).
* The database layer is also a nice feature. As an interface, we can implement it in different ways and also have back it via SQLite or another means.

### Cons:
* The design as is is somewhat limiting because it doesn't provide strong mechanisms to extend it. For example, there we may want to add facets of a job that we care about (e.g. "has free food"). We could accomplish this by making a separate `Facet` interface (or abstract class) and make the system a bit more generic.
* Immutable data classes can be a bit of a double-edged-sword. On the one hand, they make debugging far easier; on the other, updates are performed by making a new copy of the original class. This includes actually writing that whole class back to the storage layer. The expense is low, but non-zero. This cost would grow with the complexity of those data objects.
* While robust, our system could be somewhat simplified, we really only expect to have a single user, but we've built out the ability to have many.

## Yu Chen (ychen3261)
### Pros: 
* Design includes classes, attribution, operations and relationships which fully address all requirements and is simple and easy to implement.
* A high-level `JobManager` class and `JobOffer` class for both current job and new job offers add flexibility for future implementation.
* Using the association relationships help to break down the classes and the code to make it more manageable and UI modules optimized.

### Cons:
* We ask the user to enter `userId` in `User` class in the design. I think It may be a potential cons. I worked in an audio company and my company launched an app, which asked users to create an account before connecting to speakers and headphones. After launch, the company received a lot of bad reviews about this feature because users didn’t want to create an account and didn’t share their information. It is an app to compare the job offers and is also a single system, which doesn’t share information with the server or other devices, so I think the `userId` is not necessary based on the user experience.  

## Matt Zhou (mzhou64)
### Pros:

* Our design aims to abstract much of the data storage and operations into object classes. Doing this abstracts our design by creating individual classes that are easy to maintain moving forward. For example changing the job ranking logic would not impact the JobOffer class because these implementations are abstracted away from each other.

* Using the class relationships allow not only the logic to be abstracted but also allows for concurrent development among all the team members across different parts of the application. For example, one team member can develop the ranking class which another handles the JobOffer class. Making smaller classes makes it easier to unit test each one.

* Having a job manager be a central point to read and write to the database storage allows for data integrity and allows for a management of the current state of the app since we allow multiple users.
  

### Cons:

* While we have created many classes to abstract code away from each other, it means our data is separated into many parts of the code. When writing or reading from persistent storage this may end up being more difficult to deconstruct to do a write operation to our database or recreating objects based on a read operation from the database. 
* Because our logic is abstracted there are certain pieces of data that are replicated across different classes. For example, a list of job offers is contained in both the User class and the JobComparer class. This duplication may have extraneous memory usage
* Our design objects have getters but setter. That means in order to edit a field an entirely new object would have to be created and the old one would have to be deleted. While this gets the job done it could be done more efficiently.



## Keenan Line (kline3)
### Pros:
* The design we chose has six classes (also referred to as objects). This separation of functionality into different classes makes the program easy to maintain. For example, if the algorithm for ranking ever changed, the only class that would have to be modified is the Ranker class.  Furthermore, all of the classes have very little coupling between each other, meaning that they depend on each other in a very minimal way. This makes the code more maintainable and testable. For example, the Ranker takes in a JobOffer as a parameter. Rather than needing to “know” about all of the job offers and all of the jobs’ attributes, the ranker just needs to “know” about the job and then the ranker can call on “getSalary”, “getSigningBonus”, etc. to get all of the necessary information for ranking. As a result, a change to the JobOffer class would likely not impact the Ranker class at all.
* Another advantage to our design is that the jobManager is separate from the jobComparer. Like mentioned before, this separation of responsibilities makes the code more easily maintainable. If the jobComparer ever needed to change, it would be easy to do without severely impacting the jobManager. Likewise, the userWeights are separated from the user. Everytime the user wants to update one of the weights, an entirely new userWeights object will be created. This makes the data more immutable and easier to handle.

### Cons:
* When creating this architecture design, as a group we debated using less than 6 classes and more than 6 classes. For example, we considered having only a jobManager class, a user class, and a jobOffer class. While this would have led to the jobManager class potentially being unwieldy and not easy to maintain, the simpler structure might have been easier to understand and write up initially. We also considered having more than 6 classes and including classes for things like company, and location. Despite the added complexity of this architecture,it would have made it easy for us to add additional attributes to a company or location. Additionally, separating the userWeights from the user class also has drawbacks. Whenever a user wants to update one weight, an entirely new userWeight object has to be instantiated. Depending on how the data is stored, this could potentially be quite memory intensive.

## Summary
* Team members had many different design aspects at the beginning. The deep discussion of the implementations and x-or-y comparisons helped to make the design more effective and also to iron out any misunderstandings of the requirements. There is no such thing as a perfect UML diagram but the collaboration involved in creating one helped the team members to wrap their heads around the project. After several discussions and meetings, we were in complete agreement on the final team design.
* A high level of the UML diagram at the beginning left room for interpretation during design and was easy to kick off the discussion. A highly detailed UML diagram can constrict the team members during the discussion and development.
* The importance of the UML diagram is to have an architecture plan to specify, visualize, construct and maintain the software systems of the final product.