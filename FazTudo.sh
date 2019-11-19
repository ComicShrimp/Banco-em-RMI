#!/bin/bash

# Compila todos os arquivos
javac src/*.java -d Executaveis

# Compila rmic
rmic Executaveis/*Service.class

# Faz o registro
rmiregistry

# Aviso
echo "Executar o servidor e cliente manualmente"