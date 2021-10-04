const express = require('express');
const bodyParser = require('body-parser');

const app = express();

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());



indexFilePath = __dirname + "/views/index.html";
assetsPath = __dirname + "/public";

app.get("/", function(req, res){
    res.sendFile(indexFilePath);
});
app.use("/public", express.static(assetsPath));

app.get("/api", function(req, res){
    req.time = new Date().toString();
    //req.time = new Date().toUTCString;
    //unixDate = unix.Date().toString();
    //res.json({"unix":unixDate, "utc":date});
    res.json({"utc":req.time});
});






module.exports = app;
