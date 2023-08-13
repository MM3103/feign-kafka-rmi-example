# Feign, kafka, rmi example project
Это учебный проект, который представляет из себя простой пример взаимодействия 
двух микросервисов через Feign clients, Kafka и Java RMI.
Также в нем преведены простые примеры использования некоторых
паттернов программирования, таких как: интерпретатор, строитель, 
компановщик, декоратор, итератор и шаблонный метод.


## Запуск проекта
* **В начале необходимо запустить docker-compose файл, 
  который запустит Keycloak, Kafka, Zookeeper и Kafdrop**
  
       docker-compose up -d --build

* **Затем необходимо собрать common-module, first-app и 
  second-app**
  
       mvn clean install
* **Далее запустить first-app и second-app**