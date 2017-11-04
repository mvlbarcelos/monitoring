# monitoring

Tracing microservice using Sleuth and Zipkin.

## Endpoints

* [Zipkin](http://127.0.0.1:9411)

### Prerequisites
To run this project you need:

```
java8
maven
docker
docker-compose
httpie (https://httpie.org/)

```

### Build

To build docker images
```
$./build_projects.sh
```

### Prepare Application

Load data into applications
```
$./prepare_app.sh
```

### Trace requests between services

```
http -v GET http://127.0.0.1:8080/movies/ Username:marcus
http -v GET http://127.0.0.1:8080/movies/ Username:paul
```
