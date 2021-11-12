## Configure the H2 database to persist locally
In contrast to configuring H2 to be in-memory where the data is lost when the process shutdown, you’ll configure H2 to persist to a file, which you can later inspect with the H2 Console if you wish.

Configure the H2 embedded database to persist to a local file by updating your project’s application properties. See the [“Embedded” examples found here](http://www.h2database.com/html/cheatSheet.html).