# star-wars-planets
## API de para consulta de dados dos planetas do filme.

Esta API Rest foi desenvolvida utilizando Java com [Spring-boot](https://github.com/spring-projects/spring-boot), [CassandraDb](https://github.com/apache/cassandra)
 e o [Maven](https://github.com/apache/maven) para gerenciamento de dependencias.

## 1. Clone o projeto num diretorio local.

## 2. Configure o [CassandraDb](https://github.com/apache/cassandra)

a) Após instalar e iniciar o cassandradb, inicie o utilitário cqlsh (Cassandra Query Language);

b) Execute o script cql no console;

O script encontra-se no diretorio `src > cassandra > cql > load.cql`

## 3. Suba o [Spring-boot](https://github.com/spring-projects/spring-boot)

a) Rode a classe `StarWarsApplication` para subir o spring-boot;

## 4.Documentação e exemplos de requisição:

`https://app.swaggerhub.com/apis/augustocmleal/api-star-wars/1.0`
