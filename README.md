# Websocket
Pequeno chat para testar websocket com html5 + jquery + jetty.

Para testar basta compilar com maven: 

  mvn clean install eclipse:clean eclipse:eclipse -Dmaven.test.skip

Após, para subir a aplicação: 

  mvn jetty:run
  
Acessar: http://localhost:8080/chat-websocket

Obs.: Existe uma classe InitServlet, onde descomentando o código dentro do método init fica habilitado um teste de envio de mensagem por batch de tempo em tempo.



