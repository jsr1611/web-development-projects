## Define the data repositories

At this point, you should have defined your various entities that comprise our restaurant dining review app scenario. For this task, let’s provide you with more details about the different scenarios. This will help you identify the kind of queries you may need to make.

_User entity-related scenarios:_

- As an unregistered user, I want to create my user profile using a display name that’s unique only to me.
- As a registered user, I want to update my user profile. I cannot modify my unique display name.
- As an application experience, I want to fetch the user profile belonging to a given display name.
- As part of the backend process that validates a user-submitted dining review, I want to verify that the user exists, based on the user display name associated with the dining review.

_Dining review entity-related scenarios:_

- As a registered user, I want to submit a dining review.
- As an admin, I want to get the list of all dining reviews that are pending approval.
- As an admin, I want to approve or reject a given dining review.
- As part of the backend process that updates a restaurant’s set of scores, I want to fetch the set of all approved dining reviews belonging to this restaurant.

_Restaurant entity-related scenarios:_

- As an application experience, I want to submit a new restaurant entry. Should a restaurant with the same name and with the same zip code already exist, I will see a failure.
- As an application experience, I want to fetch the details of a restaurant, given its unique Id.
- As an application experience, I want to fetch restaurants that match a given zip code and that also have at least one user-submitted score for a given allergy. I want to see them sorted in descending order.