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
var unixTime = date.getTime() / 1000;

app.get("/api", function (req, res) {
    date = new Date();
    unixTime = date.getTime() / 1000;
    req.time = date.toUTCString();
    console.log(unixTime + " " + req.time);
    res.json({ unix: unixTime, utc: req.time });
});

app.get("/api/:date?", function (req, res) {
    console.log("req date: " + req.params.date);
    var dateParam = req.params.date;

    if (dateParam.includes("-")) {
        date = new Date(dateParam);
        var testDate = date.toString();
        if (testDate == "Invalid Date") {
            res.json({ error: testDate });
        } else {
            unixTime = date.getTime() / 1000;
            req.time = date.toUTCString();
            res.json({ unix: Number(unixTime), utc: req.time });
        }
    } else {
        date = new Date(Number(dateParam) / 1000);
        testDate = date.toString();
        if (testDate == "Invalid Date") {
            res.json({ error: testDate });
        } else {
            console.log("unix Num: " + dateParam);
            unixTime = Number(dateParam);
            req.time = new Date(Number(dateParam) / 1000).toUTCString();
            res.json({ unix: Number(unixTime), utc: req.time });
        }
    }

    //     console.log(unixTime + " " + req.time);
    //     unixTime = new Date().getTime() / 1000;
    //     req.time = new Date().toUTCString();
    //     res.json({ unix: unixTime, utc: req.time });
    // }
});

var port = process.env.PORT || 3000;

// listen for requests :)
var listener = app.listen(port, function () {
    // process.env.PORT
    console.log("Your app is listening on port " + listener.address().port);
});
