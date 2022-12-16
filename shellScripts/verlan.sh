#!/bin/bash

# Ecrivez une fonction verlan (dans un script éponyme) qui admet un paramètre et
# retourne son inverse lexicographique. Par exemple, si un argument vaut bonjour
# , le script affichera ruojnob

# Définition de la fonction verlan qui prend en argument un mot
function verlan() {
    # Affectation de l'argument de la fonction à la variable mot
    local mot=$1
    # Initialisation de la variable inverse à une chaîne vide
    local inverse=""
    # Initialisation de la variable i à 0
    local i=0
    # Boucle while qui parcourt chaque lettre du mot
    while ((i < ${#mot})) ; do
        # Ajout de la lettre courante à la variable inverse
        # en utilisant l'opérateur de découpage de chaîne :
        inverse=${mot:$i:1}${inverse}
        # Incrémentation de i
        ((i++))
    done
    # Affichage du mot inversé à l'aide de la commande echo
    echo $inverse
}

# Affichage du mot passé en argument du script
# en utilisant la fonction verlan
echo `verlan $1`
