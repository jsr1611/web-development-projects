var express = require('express');
var app = express();
require('dotenv').config()

var indexFilePath = __dirname + "/views/index.html";
var assetsPath = __dirname + "/public";


//Root-Level Req logger middleware
app.use("/", function(req, res, next){
    console.log(req.method + " " + req.path + " - " + "::ffff:" + req.ip);
    next();
})



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
    msg = "Hello json";

    if(process.env.MESSAGE_STYLE == "uppercase"){
        msg = msg.toUpperCase();
    }
    else{
        msg = "Hello json";
    }
    console.log("env var: " + process.env.MESSAGE_STYLE);
    
    res.json({"message":msg});
    
});


//chaining middleware 
app.get("/now", function(req, res, next){
    req.time = new Date().toString();
    next();
},
function(req, res){
    res.json({"time": req.time});
    //next();
});

//Get Route Parameter Input from the Client
app.get("/:word/echo", function(req, res){
    //req.params = {"echo": "word"};
    console.log("req word: " + req.params.word);
    res.json({"echo": req.params.word});
    
});

//Get Query Parameter Input from the Client
app.get("/name", function(req, res){
    nameStr = req.query.first + " " + req.query.last;
    res.json({name: nameStr});
});


































 module.exports = app;
