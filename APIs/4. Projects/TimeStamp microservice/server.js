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

app.get("/api/:date?", function (req, res) {
    const date = req.params.date;
    let unixD = "";
    let utcD = "";
    if (date.includes("-")) {
        unixD = Math.floor(new Date(date).getTime() / 1000);
        utcD = new Date(date).toUTCString();
    } else {
        unixD = date;
        utcD = new Date(Number(date) * 1000).toUTCString();
    }

    res.json({
        unix: unixD,
        utc: utcD,
    });
});

var port = process.env.PORT || 3000;

// listen for requests :)
var listener = app.listen(port, function () {
    // process.env.PORT
    console.log("Your app is listening on port " + listener.address().port);
});
