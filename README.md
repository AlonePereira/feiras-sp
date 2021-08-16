# Feiras-sp

feiras-sp foi construído com Spring Boot Versão 2.5.3, Java 11 e Gradle 7.1.1

## Estrutura do Projeto

No projeto dentro de src há 3 Sources Folder. Um para testes de integração, outro para a aplicação e outro para testes de unidade

## Estrutura de Pacote

dentro de br.gov.sp.feiras foi criado 3 pacotes: application, entity e interfaces.

### Application 
Nesse pacote contém toda regra de negócio da applicação.

### Entity
Contém toda classe que é o mapeamento do Banco de Dados e os Repositories

### Interfaces
É Toda entrada do mundo externo com a aplicação

## Detalhes da Aplicação
Para fazer a criação da base de dados e inserção das feiras, foi utilizado o Flyway para fazer a migração. Os arquivos estão localizados em <b>main/resources/db/migration</b> para a aplicação.
Para os testes de integração estão localizados em <b>integrationTest/resources/db/integrationTests</b>
Arquivo que de configuração de logs está em <b>main/resources/logback.xml</b>. Está configurado para gerar os logs na raiz do projeto na pasta logs.

## Libs
Para gerar o coverage de test da applicação foi utilizado o Jacoco.
O Jacoco é executado após executar com os testes de integração. O Relatório é gerado em <b>build/reports/jacoco/test/html/index.html</b>
Foi utilizado para fazer mapeamentos de objetos o MapStruct.

## Executar Aplicação
Para executar a aplicação terá que ter um Mysql. Caso tenha Docker instalado na Máquina é só rodar o seguinte comando para criar um container do Mysql. <b>docker run -d --name my_sql -e MYSQL_ROOT_PASSWORD=feiras-sp -e MYSQL_DATABASE=feiras-sp -p 3306:3306 mysql</b>
Esse comando já cria a base de dados configurada.

Após ter o Mysql, Executar o main FeirasSpApplication. A aplicação irá subir na porta 8080

### Exemplo de request para Busca de Feira

É obrigatório passar ao menos os seguintes parametros:
- nomeFeira
- distrito
- bairro
- regiao5
<b>Para buscar por nome da feira: </b> http://localhost:8080/feiras?nomeFeira=LAURA
<b>Para buscar por bairro: </b> http://localhost:8080/feiras?bairro=VILA
<b>Para buscar por distrito: </b> http://localhost:8080/feiras?distrito=PENHA
<b>Para buscar por regiao5: </b> http://localhost:8080/feiras?regiao5=Leste

Terá que utilizar o verbo GET

### Exemplo de request para Alteração de Feira

Abaixo um exemplo de request com o body abaixo:

{
    "lat": -23589826,
    "setcens": "355030872000001",
    "distrito": "SAO BERNARDO DO CAMPO",
    "regiao5": "Sul",
    "regiao8": "Sul 1",
    "registro": "1881-7",
    "logradouro": "RUA DA FEIRA",
    "bairro": "CENTRO",
    "long": -46544394,
    "areap": "3550308005158",
    "coddist": 74,
    "codsubpref": 29,
    "subprefe": "SBC",
    "nome_feira": "SBC FEIRA CENTRO"
}

<b>PUT</b> http://localhost:8080/feiras/35

Não é obrigatório passar <b>numero e referencia</b> os demais campos são todos obrigatórios
Caso o id da Feira seja de uma feira inexistente, será lançando um erro de feira não encontrada.


### Exemplo de request para Criação de Feira

Abaixo um exemplo de request com o body abaixo:

{
"lat": -23589826,
"setcens": "355030872000001",
"distrito": "SAO BERNARDO DO CAMPO",
"regiao5": "Sul",
"regiao8": "Sul 1",
"registro": "1881-7",
"logradouro": "RUA DA FEIRA",
"bairro": "CENTRO",
"long": -46544394,
"areap": "3550308005158",
"coddist": 74,
"codsubpref": 29,
"subprefe": "SBC",
"nome_feira": "SBC FEIRA CENTRO"
}

<b>POST</b> http://localhost:8080/feiras

Não é obrigatório passar <b>numero e referencia</b> os demais campos são todos obrigatórios

### Exemplo de request para deleção de feira

<b>DELETE</b> http://localhost:8080/feiras/35

Caso a feira com o ID passado não existe na base de dados será retornado um erro de feira não encontrada.
Em Caso de sucesso, será retornado o Status HTTP 200.