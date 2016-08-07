# MetricaPistasTORCS

A ferramenta neste repositório analisa arquivos .xml de pistas do TORCS devidamente modificados (indicação da localização no computador dos arquivos "params.dtd", "surface.xml" e "objects.xml" nas linhas iniciais do arquivo, de acordo com a formatação do arquivo), extraindo informações de tais arquivos gerando métricas de avaliação para cada uma delas.

A utilização se dá em linha de comando com a versão presente na pasta "Prompt". As instruções de compilação para cada caso estão descritas abaixo.

# Métricas 

Dois tipos de métricas foram desenvolvidas, ambas buscam relacionar as características estruturais da pista as naturais com pré-classificações de dificuldades encontradas na comunidade do TORCS, que se tratam de características estruturais das pistas, conseguidas com a leitura do arquivo XML, e as realacionais, desenvolvidas a partir de medidas estatísticas de dispersão aplicadas aos dados adquiridos e também tendo como base outras métricas presentes em artigos de referência.

  Naturais: 
    Comprimento da pista, Número de retas, Comprimento de retas, Número de curvas e Comprimento de curvas.
    
  Relacionais:
    Somatório dos inversos dos raios e variâncias de  comprimentos de reta, de curva, dos raios e dos ângulos das curvas.

# Instruções de utilização

A utilização desta ferramenta se dá pelo terminal. Ao acessar a pasta Prompt do projeto, exetuar o comando "javac Java/*.java" para compilar e em seguida "java Java.testeSAX". De modo a selecionar a pista a ser analisada, é necessário modificar a linha 15 do arquivo "Prompt/Java/testeSAX.java", alterando o valor da variável "nomePista" para a localização no sistema da pista desejada. No arquivo da pista também é necessário alterar a localização dos arquvios "objects.xml", "params.dtd" e "surfaces.xml" para o devido funcionamento da ferramenta, sendo que, de modo a facilitar usos futuros e a análise de outras pistas, tais arquivos, presentes na distribuição padrão do TORCS, foram adicionados à pasta "Prompt/XML".
