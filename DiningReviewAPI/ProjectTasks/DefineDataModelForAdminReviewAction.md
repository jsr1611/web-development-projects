## Define a data model for an admin review action
In other tasks, you had to define POJO classes to represent a restaurant, a dining review, and a user. For this task, let’s provide you with more details about our scenario.

Once a user submits their review, an administrator – one who’s authorized to review and approve a dining review – will take action by either accepting or rejecting the dining review. Later in the project, you will define an API endpoint that will handle this administrator scenario. For this project scenario, you will take the specific approach of sending this action as part of the request body.

Define a plain ol’ Java object (POJO) that represents an “admin review action”. A representation can simply consist of:

- does the admin accept the dining review

Apply the Lombok annotations to save you from writing more code than necessary.