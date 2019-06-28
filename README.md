# financial-app-jsf

Objetivo

estudar a aplicação da camada view e controller usando o framework jsf

Este projeto tem como base o conceiro adquirido no projeto Engenharia III, 
na qual visa a implementação de alguns design patterns com o intuito de melhorar a performance da aplicação

com relação ao projeto base, nela foi feito uma Facade aplicando o patten singleton com o intuito de não criar várias insntancias 
dos DAOs

foi feito a mudança da AbstractDao, aonde foi implentado um método que cria uma instancia (Factory)
que recebe uma estratégia de criação de query

implementação de um singleton na criação do objeto do sessionFactory

Framework utilizado para a view JSF (primefaces)
