play-starter
============

Starter templates for Play Framework apps

Overview
--------

This starter app is designed to run in both a local development environment (Windows or Linux) as well as one or more Heroku deployments for dev/test/prod.

Database configuration
----------------------------
If you deploy this code to Heroku and want to use postgres, Heroku automatically deploys a free Postgres server with new Play apps.  But the way database connection info is specified in a local dev environment conflicts with Heroku, and there are multiple solutions to that problem.  The solution this codebase uses is described below.

Normally, Play looks for db connection settings in conf/application.conf.  If you're only going to run this code in local dev, that would work fine.  But Heroku *also* gets its db connection info from /Procfile, and Heroku gets confused when these settings are provided in two places.

Heroku's database configuration is provided in /Procfile, which tells Heroku the command used to start the Play server on a web dyno.  Here's an example:

  web: target/start -Dhttp.port=$PORT  -DapplyEvolutions.default=true -Ddb.default.driver=org.postgresql.Driver -Ddb.default.url=$DATABASE_URL $JAVA_OPTS

This tells Heroku to start a web dyno, using environment variables provided by Heroku to set the DB connection settings.  

However, in a local dev environment, starting the play server with the usual "play run" will fail because it doesn't find the db settings in conf/application.conf.

So instead we keep the db settings for local development in a file:  /dev.application.conf.  To start the Play server or run the tests, we provide the following scripts which pass the '-Dconfig.file=dev.application.conf' paramater:

- Windows: run.bat, test.bat
- Linux: run.sh, test.sh

Developers should edit this file to match their local database configuration.  dev.application.conf is in .gitignore to help prevent individual developers from checking in changes to this file.



