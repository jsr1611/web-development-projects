## Configure Hibernate to always drop the database

In a different task, you had to configure the H2 embedded database to persist to a local file. By doing so, you’ll also need to ensure your database tables will always exist when your application starts up. Since you’re still in the process of coding up your app and your set of database tables may still be in-flux, you can configure your app to always auto-create the database tables based on your latest code when you run your app.

Hibernate, Spring Data JPA’s object/relational mapping (ORM) solution, has different options for recreating your database tables during your application’s startup.

Configure Hibernate to always drop the database and then recreate the database during your application startup by updating your project’s application properties.