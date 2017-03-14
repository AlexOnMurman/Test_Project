CRUD-приложение для управления пользователями.

Скрипт TestTask_SQL_Script.sql пересоздает таблицу Test.User (база данных Test должна существовать).
В настройках приложения (mvc-dispatcher-servlet.xml) для работы с MySQL установлены пользователь root с паролем root.

Для деплоя в Tomcat используется tomcat7-maven-plugin (указан в конце pom-файла), скорректировать название сервера (у меня называется TomcatServer) из настроек maven.
После деплоя приложение будет доступно по адресу http://localhost:8080/TestProject/
  
