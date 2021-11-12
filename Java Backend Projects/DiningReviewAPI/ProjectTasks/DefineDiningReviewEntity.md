## Define the dining review entity

In a different task, you had to define a POJO class to represent a restaurant. For this task, let’s provide you with more details about our scenario.

A dining review consists of the following info:

- who submitted, represented by their unique display name (String)
- the restaurant, represented by its Id (Long)
- an optional peanut score, on a scale of 1-5
- an optional egg score, on a scale of 1-5
- an optional dairy score, on a scale of 1-5
- an optional commentary

Define a plain ol’ Java object (POJO) class to represent a dining review. Be sure to include the property that represents the unique database ```id```, which you can define as type ```Long```. Apply the Lombok annotations to save you from writing more code than necessary.