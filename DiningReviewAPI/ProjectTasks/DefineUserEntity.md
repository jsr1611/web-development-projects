## Define the user entity

In other tasks, you had to define POJO classes to represent a restaurant and a dining review. For this task, let’s provide you with more details about our scenario.

A user consists of the following info:

- their display name, one that’s unique to only that user
- city
- state
- zipcode
- whether they’re interested in peanut allergies
- whether they’re interested in egg allergies
- whether they’re interested in dairy allergies

Define a plain ol’ Java object (POJO) class to represent a user. Be sure to include the property that represents the unique database ```id```, which you can define as type ```Long```. Apply the Lombok annotations to save you from writing more code than necessary.