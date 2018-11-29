RUN ON SERVER
curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' https://messagesapi.herokuapp.com/messages

RUN LOCALLY
*Open app in Intellij or ide of your choice*
curl -X POST -H "Content-Type: application/json" -d '{"message": "foo"}' http://localhost:8080/messages



Some bottlenecks of my implementation is one I don't have a persistent ORM such as H2 or Hibernate. Another thing I'd like to for when more users get added is use a Zuul gateway proxy and Eureka as a Discovery service.
