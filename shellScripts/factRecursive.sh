#!/bin/bash

echo -n "Donnez moi votre nombre à factoriser ? "; read a
 
function factRecursive() {
    local n=$1
    if [[ $n -eq 0 ]]; then
        echo 1
    else
        echo $((n*$(f $n-1)))
    fi
}
 
echo "Votre nombre factorisé est égal à $(f $a)";
