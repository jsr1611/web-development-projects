var express = require('express');
var app = express();

var indexFilePath = __dirname + "/views/index.html";
var assetsPath = __dirname + "/public";

app.get("/", function(req, res){
    //res.send('Hello Express');
    res.sendFile(indexFilePath);
});


app.use("/public", express.static(assetsPath));




































 module.exports = app;
