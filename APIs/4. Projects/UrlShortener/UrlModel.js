const mongoose = require("mongoose");
require("dotenv").config();

mongoose.connect(process.env.MONGO_URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
});

const { Schema } = mongoose;
const urlSchema = new Schema({
    shortUrl: String,
    originalUrl: String,
});
let ShortUrl = mongoose.model("ShortUrl", urlSchema);

let counter = 0;

function counterFunc() {
    ShortUrl.countDocuments({})
        .then((count) => {
            counter = count + 1;
            console.log("counter: " + counter);
            return counter;
        })
        .catch((err) => {
            console.log(err);
        });
}

// Create and Save a Record of a Model
function createAndSaveUrl(url) {
    var new_url = "";
    let counter = counterFunc();
    new_url = new ShortUrl({ shortUrl: counter, originalUrl: url });
    const result = new_url.save();
    console.log("create result: ");
    console.log(result);
    return counter;
}

//Searching database for a person with a given id
const findUrlById = async (urlId, done) => {
    const result = await ShortUrl.findOne(
        { shortUrl: urlId },
        function (err, result) {
            console.log(result);
            return result;
        }
    );
};

/** **Well Done !!**
/* You completed these challenges, let's go celebrate !
 */

//----- **DO NOT EDIT BELOW THIS LINE** ----------------------------------

exports.UrlModel = ShortUrl;
exports.createAndSaveUrl = createAndSaveUrl;
exports.findUrlById = findUrlById;
