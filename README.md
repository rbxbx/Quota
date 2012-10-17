# quota

An Online Quoteboard

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running
To populate the schema

    psql quotes < schema.sql

Set the database url in the environment

    export DATABASE_URL=postgresql://localhost:5432/quota

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2012
