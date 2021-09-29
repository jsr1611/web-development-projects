const mongoose = require("mongoose");
require('dotenv').config();

mongoose.connect(process.env.MONGO_URI, { useNewUrlParser: true, useUnifiedTopology: true });


const { Schema } = mongoose;
const personSchema = new Schema({
  name : String,
  age :  Number,
  favoriteFoods : [String]
});
let Person = mongoose.model('Person', personSchema);


// Create and Save a Record of a Model
const createAndSavePerson = (done) => {
  var jimmy = new Person({name: "Jimmy", age:30, favoriteFoods:["seafood", "dumplings", "kebab"]});
  
  jimmy.save(function(err, data){
    if(err) return console.error(err);
    done(null , data);
  });
};


//Create many records with model.create()
arrayOfPeople = [{name:'John', age:35, favoriteFoods:['sushi', 'kebab', 'beef']}, {name:'Kerim', age:32, favoriteFoods:['kebab', 'dumplings']}, {name:'Fahad', age:28, favoriteFoods:['seafood', 'beef']}];

const createManyPeople = function(arrayOfPeople, done) {
  Person.create(arrayOfPeople, function(err, people){
    if(err) return console.error(err)
    done(null, people);
  });
};


//Searching database for people with name
const findPeopleByName = (personName, done) => {
  Person.find({name:personName}, function(err, people){
    if(err) return console.error(err)
    done(null, people);
  }).exec();
  
};


//Searching database for a person with specific favourite food
const findOneByFood = (food, done) => {
  Person.findOne({favoriteFoods:food}, function(err, onePerson){
    if(err) return console.error(err)
    done(null, onePerson);
  });
  
};

//Searching database for a person with a given id
const findPersonById = (personId, done) => {
  Person.findById({_id:personId}, function(err, person){
    if(err) return console.error(err);
    done(null, person);
  });
};

const findEditThenSave = (personId, done) => {
  const foodToAdd = "hamburger";

  done(null /*, data*/);
};

const findAndUpdate = (personName, done) => {
  const ageToSet = 20;

  done(null /*, data*/);
};

const removeById = (personId, done) => {
  done(null /*, data*/);
};

const removeManyPeople = (done) => {
  const nameToRemove = "Mary";

  done(null /*, data*/);
};

const queryChain = (done) => {
  const foodToSearch = "burrito";

  done(null /*, data*/);
};

/** **Well Done !!**
/* You completed these challenges, let's go celebrate !
 */

//----- **DO NOT EDIT BELOW THIS LINE** ----------------------------------

exports.PersonModel = Person;
exports.createAndSavePerson = createAndSavePerson;
exports.findPeopleByName = findPeopleByName;
exports.findOneByFood = findOneByFood;
exports.findPersonById = findPersonById;
exports.findEditThenSave = findEditThenSave;
exports.findAndUpdate = findAndUpdate;
exports.createManyPeople = createManyPeople;
exports.removeById = removeById;
exports.removeManyPeople = removeManyPeople;
exports.queryChain = queryChain;
