# CustomAnnotation-Interceptor

 It is the project where custom notations are used with interceptors.
 
 ### Annotion and Interceptor Content
 
Interceptions specific to these notations were written.

- BasicAuthentication - @BscAuth
- Write Authorization - @Write
- Logging - @Logging

## Using 
```sh
make run
```
#### Or DockerFile
```sh
chmod +x ./buildScript
./buildScript

docker build ./ -t java
docker run -p 8081:8081 java --detach
```
## Testing

Verify the deployment by going to your server address.Can be tested with browser or Postman.

```sh
127.0.0.1:8081/user
```
