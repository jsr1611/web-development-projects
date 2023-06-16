# MongoDB Fundamentals

### Inserting documents in a MongoDB Collection

1. insertOne() - inserting one document

    - Use insertOne() to insert a document into a collection. Within the parentheses of insertOne(), include an object that contains the document data. Here's an example:

        ```
            db.grades.insertOne({
                student_id: 654321,
                products: [
                    {
                    type: "exam",
                    score: 90,
                    },
                    {
                    type: "homework",
                    score: 59,
                    },
                    {
                    type: "quiz",
                    score: 75,
                    },
                ],
                class_id: 550,
                })
        ```

2. insertMany() - inserting multiple documents as an array and separated by a comma (,)

    - Use insertMany() to insert multiple documents at once. Within insertMany(), include the documents within an array. Each document should be separated by a comma. Here's an example:

        ```
        `     db.grades.insertMany([
          {
              student_id: 546789,
              products: [
              {
                  type: "quiz",
                  score: 50,
              },
              {
                  type: "homework",
                  score: 70,
              },
              {
                  type: "quiz",
                  score: 66,
              },
              {
                  type: "exam",
                  score: 70,
              },
              ],
              class_id: 551,
          },
          {
              student_id: 777777,
              products: [
              {
                  type: "exam",
                  score: 83,
              },
              {
                  type: "quiz",
                  score: 59,
              },
              {
                  type: "quiz",
                  score: 72,
              },
              {
                  type: "quiz",
                  score: 67,
              },
              ],
              class_id: 550,
          },
          {
              student_id: 223344,
              products: [
              {
                  type: "exam",
                  score: 45,
              },
              {
                  type: "homework",
                  score: 39,
              },
              {
                  type: "quiz",
                  score: 40,
              },
              {
                  type: "homework",
                  score: 88,
              },
              ],
              class_id: 551,
          },
          ])`
        ```

3. \_id is provided automatically if user doesn't provide one which must be unique.

### Finding documents in a MongoDB COllection

1. find()

    - Use the $eq operator to find documents with a field and value
    - When given equality with an \_id field, the find() command will return the specified document that matches the \_id. Here's an example:

    ```
    db.zips.find({ _id: ObjectId("5c8eccc1caa187d17ca6ed16") })
    ```

2. $in operator

    - Use the $in operator to select documents equal to the values specified in the array
    - Use the $in operator to select documents where the value of a field equals any value in the specified array. Here's an example:

    ```
    db.zips.find({ city: { $in: ["PHOENIX", "CHICAGO"] } })
    ```

3. $gt, $gte, $lt and $lte - greater/less than, greater/less than or equal

    - Use the $gt operator to match documents with a field greater than the given value. For example:

    ```
    db.sales.find({ "items.price": { $gt: 50}})
    ```

    - Use the $lt operator to match documents with a field less than the given value. For example:

    ```
    db.sales.find({ "items.price": { $lt: 50}})

    ```

    - Use the $lte operator to match documents with a field less than or equal to the given value. For example:

    ```
    db.sales.find({ "customer.age": { $lte: 65}})
    ```

    - Use the $gte operator to match documents with a field greater than or equal to the given value. For example:

    ```
    db.sales.find({ "customer.age": { $gte: 65}})
    ```

### Querying on Array Elements in MongoDB

1. In the following example, "InvestmentFund" is not enclosed in square brackets, so MongoDB returns all documents within the products array that contain the specified value.
    ```
    db.accounts.find({ products: "InvestmentFund"})
    ```
2. $elemMatch
    - Use the $elemMatch operator to find all documents that contain the specified subdocument. For example:
    ```
    db.sales.find({
        items: {
            $elemMatch: { name: "laptop", price: { $gt: 800 }, quantity: { $gte: 1 } },
        },
        })
    ```

### Finding documents using Logical Operators

1. $and
    - Use implicit $and to select documents that match multiple expressions. For example:
    ```
    db.routes.find({ "airline.name": "Southwest Airlines", stops: { $gte: 1 } })
    ```
2. $or
    - Use the $or operator to select documents that match at least one of the included expressions. For example:
    ```
    db.routes.find({
        $or: [{ dst_airport: "SEA" }, { src_airport: "SEA" }],
        })
    ```
3. $and with $or
    - Use the $and operator to use multiple $or expressions in your query.
    ```
    db.routes.find({
        $and: [
            { $or: [{ dst_airport: "SEA" }, { src_airport: "SEA" }] },
            { $or: [{ "airline.name": "American Airlines" }, { airplane: 320 }] },
        ]
        })
    ```
