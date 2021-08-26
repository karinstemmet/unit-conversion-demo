# Unit Conversion Demo API

# Types Of Measurement and units of conversion
Length - "centimeter, meter, kilometer, inch, feet, mile"
Temperature - "celsius, fahrenheit, kelvin"
Speed - "kph, mph"
Volume - "milliliter, liter, fluidounce, gallon"
Weight - "gram, kilogram, ounce, pound"

# URI Examples
http://localhost:8080/length?value=1000&from=centimeter&to=inch
http://localhost:8080/temperature?value=19&from=celsius&to=fahrenheit
http://localhost:8080/speed?value=100&from=kph&to=mph
http://localhost:8080/volume?value=1000&from=milliliter&to=fluidounce
http://localhost:8080/weight?value=1000&from=gram&to=ounce

# running locally
mvn install
mvnw spring-boot:run

# running in Docker
docker build -t karin/mydemo .
docker run -p 8080:8080 -t karin/mydemo