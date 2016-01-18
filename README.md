## X M L - Without DocBuilder

XML Homework - CSV to XML without DocBuilder

## How does it work?
You can simply convert a CSV File to a XML File. (without DocBuilder)

> The CSV File gets converted into an 2D Array.

[Wikipedia](https://en.wikipedia.org/wiki/XML)

#### Examaple:

```
//CSV File: Johannes, Christler; Benjamin, Hackstock;

String[][] csvToArray(String s){
  ...
}

// The Array will look like that: a[0][0] = Johannes
                                  a[1][1] = Hackstock

void arrayToXML(String [][] array){
  ...
}

//XML = <Perosn><Vorname>Johanns</Vorname><Nachn...
```

Copyright Christler Johannes, 2016
