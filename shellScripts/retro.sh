#!/bin/bash

#Ecrivez un script retro qui demande à l'utilisateur de taper des mots, l'un
# après l'autre. La saisie s'arrête lorsque l'utilisateur entre un mot vide.
# Après cela, le script affiche la suite des mots saisis, séparés par des
# espaces, mais dans l'ordre inverse de saisie et chaque mot à l'envers.
# Par exemple, si l'utilisateur a tapé les mots : bonjour ca va, le script
# affiche : av ac ruojnob

# Définition de la fonction verlan qui prend en argument un mot
# et renvoie ce mot à l'envers
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
    # Renvoi du mot inversé
    echo $inverse
}

# Initialisation d'un tableau vide qui stockera les mots saisis
mots=()

# Boucle infinie qui demande à l'utilisateur de saisir un mot
while true; do
  # Demande de saisie d'un mot à l'utilisateur
  read -p "Entrez un mot (la saisie s'arrête si vous entrez un mot vide) : " mot

  # Si le mot saisi est vide, la boucle se termine
  if [ -z "$mot" ]; then
    break
  fi

  # Ajout du mot saisi au tableau mots
  mots=("${mots[@]}" "$mot")
done

# Affichage des mots saisis dans l'ordre inverse,
# chaque mot étant affiché à l'envers
for ((i=${#mots[@]}-1; i>=0; i--)); do
  # Affichage du mot courant à l'envers
  echo -n $(verlan "${mots[i]}")" "
done

# Retour à la ligne
echo
