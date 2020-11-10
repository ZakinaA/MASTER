# 1. INTRODUCTION
```bash
git clone https://github.com/ZakinaA/MASTER
```
## 1.1 Présentation
Créée en 2006, Equida est une société spécialisée dans la vente aux enchères de chevaux de course. Avec un effectif de vingt-sept personnes, la société a réalisé en 2012 un chiffre d’affaires de 87 millions d’euros. Ses clients sont des vendeurs de chevaux, principalement des haras, des entraîneurs et de grands propriétaires de chevaux, situés en France et à l’étranger. Pour être plus proche de sa clientèle étrangère, elle s’appuie sur une quinzaine de correspondants répartis dans de nombreux pays comme l’Irlande, la Turquie, ou encore le Japon.

## 1.2 Documents de référence
[Cahier des charges](ftp://sio2@nas.sio.bts/PARTAGE_SIO2/MATIERES/SLAM/SLAM45/JEE_Equida/Documentation/Equida_CDC.odt)

## 1.3 Spécifications générales
L'application MASTER, permet de gerer la vente aux enchères de chevaux de manière (plus ou moins) automatique.

## 1.4 Contraintes d'évolution
Aucune évolution de l'application n'est prévue.

# 2. SPECIFICATIONS FONCTIONNELLES
## 2.1 Définition des acteurs
4 Rôles : Admin, Employee, Vendeur, Acheteur.

## 2.2 Cas d’utilisation

# 3. SPECIFICATIONS D’INTERFACES
## 3.1 Structure des pages
- Page d'accueil et de présentation du site commun à tout les nouveaux visiteurs
- Page de connexion pour les utilisateurs
- Entête, pied de page et menu de navigation commun à tout les utilisateurs en fonctions de leurs permissions

## 3.2 Liste des pages
| Interface        | Fichier           | Accès  | Fonction |
| :---------------:|:-----------------:| :-----:| :-------:|
| Accueil     | index.html | /MASTER | Page d'accueil |
| Pied de page | footer.html | | Pied de page |
| Connexion | login.jsp | /MASTER/login |  Connexion à l'application |
| Vue Acheteur | Acheteur.jsp | Par la connexion | Accueil d'un acheteur |
| Vue Acheteur | listerLesVentesParCateg.jsp | Par la navigation | liste des Ventes en fonction de la catégorie séléctionnée |
| Vue Acheteur | listerLesLots.jsp | Par la navigation | liste les lots en fonction d'une vente |
| Vue Acheteur | ficheCheval.jsp | Par la navigation | Affiche les informations de vente d'un cheval |
| Vue Acheteur | enchereRecap.jsp | Par la navigation | Redirige l'acheteur après une enchère |
| Vue Admin | Admin.jsp | Par la connexion | Accueil de l'admin |
| Vue Admin | liserLesVentesParCateg.jsp | Par la navigation | L'admin dispose d'outils pour administrer les ventes |
| Vue Admin | listerLesLots.jsp | Par la navigation | L'admin dispose d'outils pour administrer les lots |
| Vue Admin | ficheCheval.jsp | Par la navigation | L'admin dispose d'outils pour administrer les chevaux |
| Vue Admin | chevalAjouter.jsp | Par la navigation | L'admin dispose d'outils pour administrer les chevaux |
| Vue Admin | chevalLister.jsp | Par la navigation | L'admin dispose d'outils pour administrer les chevaux |
| Vue Admin | clientAjouter.jsp | Par la navigation | L'admin dispose d'outils pour administrer les clients |
| Vue Admin | clientConsulter.jsp | Par la navigation | L'admin dispose d'outils pour administrer les clients |
| Vue Admin | listerLesCourriels.jsp | Par la navigation | L'admin dispose d'outils pour administrer les courriels |

## 3.3 Cinématique
- vue Accueil => Si Connexion => vue Accueil en fonction du rôle => Sinon => Vue de Connexion
- Accueil Acheteur => vue ListeDesCategVentes => vue lise des ventes => vue des lots => vue des informations du cheval => vue recapEnchere => Redirecection vers l'accueil
- Accueil Admin => Barre de navigation avec les outils d'administrations

## 3.4 Interfaces utilisateurs
- Barre de navigation avec l'option de connexion/deconnexion et de retour à l'accueil (si admin ou employee => Outils d'administrations)
- Contenu de la page en fonction de la vue
- Pied de pages avec les auteurs + Lycée

## 3.6 interfaces avec des fichiers
- Bootsrap, JQuery, JS CDN

# 4. SPECIFICATIONS TECHNIQUES
## 4.1 Environnement de production
### 4.1.1 Environnement matériel
### 4.1.2 Environnement logiciel
## 4.2 Environnement de développement
### 4.2.1 Environnement matériel
### 4.2.2 Environnement logiciel
## 4.3 Mise en œuvre
## 4.4 Exigences de programmation
# 5. MODELISATION
## 5.1 Modèle relationnel et base de données
## 5.2 Diagramme de classes
# ARCHITECTURE APPLICATIVE
# QUALIFICATION DU LOGICIEL
