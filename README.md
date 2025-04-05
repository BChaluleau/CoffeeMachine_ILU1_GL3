# CoffeeMachine_ILU1_GL3 printemps 2025
Exemple de code préexistant pour illustrer la vérification d'exigences

Les diverses etapes essaient d'illustrer les besoins d'amélioration du code, d'identification de cas d'erreur et de définition de scénarios de tests.


## Mise en place
- créer une branche depuis ctd_2024_automne : ctd_2025_printemps
```
git clone https://github.com/BChaluleau/CoffeeMachine_ILU1_GL3
git branch -r
git checkout ctd_2025_printemps
```
- Brancher Eclipse : nouveau projet, pointer sur le repo

## Tests fonctionnels
- Trouver le main : `CTRL+H` main
- Lancer le main : tester achat d'un café
- Descendre jusqu'à coffeeMaker.makeCoffee
- https://github.com/BChaluleau/CoffeeMachine_ILU1_GL3
- Observer diagramme des classes, observer la méthode -> wooclap est-ce lisible ?
- pistes d'améliorations : recipeNumber, complexité, niveau d'imbrication
- avant de se lancer dans un refactor, il faut pouvoir tester pour éviter les non régressions
- analyse du code : 
* choisir une recette qui n'existe pas
* choisir une recette qui existe mais on a pas assez d'argent
* choisir une recette qui existe, on a pas assez d'argent, pas assez d'ingrédients
* choisir une recette qui existe, on a pas assez d'argent, assez d'ingrédients

- réaliser le refactor

- formalisme given/when/then
