#!/bin/bash

# Compila todos os arquivos
javac src/*.java -d Executaveis

# Aviso
echo "Executar o rmic no arquivos necessarios e rodar rmiregistry"
echo "Executar o servidor e cliente manualmente"