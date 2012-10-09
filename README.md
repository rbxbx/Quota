# quota

An Online Quoteboard

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running
To populate the schema

    sqlite3 quotes_development.db < schema.sql

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2012
