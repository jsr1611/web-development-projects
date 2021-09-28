var express = require('express');
var app = express();
require('dotenv').config()

var indexFilePath = __dirname + "/views/index.html";
var assetsPath = __dirname + "/public";


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






































 module.exports = app;
