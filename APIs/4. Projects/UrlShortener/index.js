require("dotenv").config();
const express = require("express");
const cors = require("cors");
const { url } = require("inspector");
const app = express();

// Basic Configuration
const port = process.env.PORT || 3000;

// global setting for safety timeouts to handle possible
// wrong callbacks that will never be called
const TIMEOUT = 10000;

app.use(cors());

app.use(express.urlencoded({ extended: true }));

app.use("/public", express.static(`${process.cwd()}/public`));

app.get("/", function (req, res) {
    res.sendFile(process.cwd() + "/views/index.html");
});

// Your first API endpoint
app.get("/api/hello", function (req, res) {
    res.json({ greeting: "hello API" });
});

const createShortUrl = require("./UrlModel.js").createAndSaveUrl;

const findUrlById = require("./UrlModel.js").findUrlById;

app.post("/api/shorturl", function (req, res) {
    let original = req.body.url;
    console.log(original);
    let short = createShortUrl(original);
    console.log("num: ");
    console.log(short);
    res.json({ original_url: original, short_url: short });
});

app.get("/api/shorturl/:shorturl?", function (req, res) {
    let short = req.params.shorturl;
    let original = "";
    findUrlById(short)
        .then((orig) => {
            console.log("res: ");
            console.log(orig.original);
            original = orig.original;
            let msg = "redirect to: " + orig + "?";
            if (confirm(msg)) {
                res.writeHead(301, {
                    Location: original,
                }).end();
            }
        })
        .catch((err) => {
            console.log(err);
            res.json({ error: "Url does not exist" });
        });
});

app.listen(port, function () {
    console.log(`Listening on port ${port}`);
});
