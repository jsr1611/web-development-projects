var express = require('express');
var app = express();

var indexFilePath = __dirname + "/views/index.html";
var assetsPath = __dirname + "/public";

app.get("/", function(req, res){
    //res.send('Hello Express');
    res.sendFile(indexFilePath);
});


/*
// Normal usage
app.use(express.static(__dirname + "/public"));

// Assets at the /public route
app.use("/public", express.static(__dirname + "/public"));
*/
app.use("/public", express.static(assetsPath));



//serve json data on a /json route

app.get("/json", function(req, res){
    res.json({"message":"Hello json"});
});






































 module.exports = app;
