// server.js
// where your node app starts

// init project
var express = require("express");
var app = express();

// enable CORS (https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
// so that your API is remotely testable by FCC
var cors = require("cors");
app.use(cors({ optionsSuccessStatus: 200 })); // some legacy browsers choke on 204

// http://expressjs.com/en/starter/static-files.html
app.use(express.static("public"));

// http://expressjs.com/en/starter/basic-routing.html
app.get("/", function (req, res) {
    res.sendFile(__dirname + "/views/index.html");
});

// your first API endpoint...
app.get("/api/hello", function (req, res) {
    res.json({ greeting: "hello API" });
});

var date = new Date();
var unixTime = date.getTime();

app.get("/api", function (req, res) {
    date = new Date();
    unixTime = date.getTime();
    req.time = date.toUTCString();
    res.json({ unix: unixTime, utc: req.time });
});

app.get("/api/:date?", function (req, res) {
    var dateParam = req.params.date;

    // check if the number has less than 5 [consecutive] numbers, which means dates, opposite would be unix time
    if (!/\d{5,}/.test(dateParam)) {
        date = new Date(req.params.date);
        var testDate = date.toString();
        if (testDate == "Invalid Date") {
            res.json({ error: testDate });
        } else {
            unixTime = date.getTime();
            req.time = date.toUTCString();
            res.json({ unix: Number(unixTime), utc: req.time });
        }
    } else {
        date = new Date(Number(dateParam));
        testDate = date.toString();
        if (testDate == "Invalid Date") {
            res.json({ error: testDate });
        } else {
            unixTime = Number(dateParam);
            req.time = new Date(Number(dateParam)).toUTCString();
            res.json({ unix: Number(unixTime), utc: req.time });
        }
    }
});

var port = process.env.PORT || 3000;

// listen for requests :)
var listener = app.listen(port, function () {
    // process.env.PORT
    console.log("Your app is listening on port " + listener.address().port);
});
