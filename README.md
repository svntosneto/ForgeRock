# Filter API

Filter API is a JAVA Maven Project that can be used to determine whether or not a resource matches a given set of criteria. The criteria are:

- boolean literals (constants): “true” and “false”
- logical operators which can be used to combine the results of other filters: AND, OR, and NOT
- comparison operators (care should be taken to deal with missing properties):
   1. property is present
   2. property is equal to some value
   3. property is less than some value. 
   4. property is greater than some value
   5. property matches a regular expression.

It also has ability to programmatically construct arbitrarily complex filters.

## Requirements

It requires:
- Java 8
- Maven
- JDK

## Usage

To build the project Unzip the file and navigate to \app\forgerock-exercise and run:

```bash
mvn package
```
To run the App run the following command in the same directory:

```bash
java -cp target/forgerock-exercise-1.0-SNAPSHOT.jar com.forgerock.app.App
```

To run the tests of the different Filters run the following command in the same directory:

```bash
mvn test
```

## Grammar

A simple grammar file can be found in the initial directory as a TXT-file grammar.file

## License
MIT License

Copyright (c) 2021 Ricardo Neto

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
