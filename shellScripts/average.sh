#!/bin/bash

echo -n "Donnez moi votre nombre ? "; read a
sum=0
min=$a
max=$a
counter=0

while [ $a -ne 0 ]
do
    ((counter++))
    ((sum+=a))
    if (($a<min))
    then
        ((min=$a))
    fi
    if (($a>max))
    then
        ((max=$a))
    fi
    echo -n "Donnez moi votre nouveau nombre ? "; read a
done

echo "Votre boucle est terminée puisque vous avez saisi un 0 "
echo "La somme est de $sum"
echo "Le min est de $min"
echo "Le max est de $max"
echo "Il y a $counter nombres"
