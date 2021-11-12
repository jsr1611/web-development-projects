## Define the restaurant entity

Before you can plan out your models, let’s first provide you some more details about our scenario.

Our restaurant dining review app scenario revolves around the following basic concepts:

- a restaurant
- a dining review
- a user

A restaurant will have a set of review scores based on those submitted by users. On a scale of 1 to 5, with 5 being the best, a restaurant will have individual scores for the following food allergies:

- peanut
- egg
- dairy

Each individual score will be the average across all the submitted scores for that given category. In the absence of any submitted score, an individual category score will have a null value.

A restaurant will also have an overall score, which will be the average across all the submitted scores across all the categories. A user can later search for restaurants based on these scores.

Define a plain ol’ Java object (POJO) class to represent a restaurant. Be sure to include the property that represents the unique database ```id```, which you can define as type ```Long```.