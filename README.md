🧾 API Recettes de Cuisine
Application RESTful pour gérer des recettes de cuisine avec leurs catégories, ingrédients, quantités et unités. Développée avec Spring Boot et Docker, connectée à une base de données MariaDB.

🔧 Technologies utilisées
. Java 21

. Spring Boot

. Spring Data JPA

. MariaDB

. Docker / Docker Compose

. Adminer (interface DB)

. Postman (tests)

📦 Lancer le projet avec Docker :
docker compose up --build 

. http://localhost:8080 → API

. http://localhost:8091 → Adminer (interface DB)

. Login : springuser

. Password : ThePassword

. DB : recettes_db

📁 Structure du projet
src/
├── controller
├── service
├── repository
├── entity
├── dto
└── ApiRecettesApplication.java

. entity : classes JPA (Recette, Ingrédient, etc.)

. dto : objets pour exposer les données formatées

. repository : interfaces JPA

. service : logique métier

. controller : routes REST

🔗 Endpoints principaux
📌 Catégories (/api/categories)
GET / → Liste des catégories

POST / → Ajouter une catégorie

📌 Ingrédients (/api/ingredients)
GET / → Liste des ingrédients

POST / → Ajouter un ingrédient

📌 Recettes (/api/recettes)
GET / → Liste des recettes

POST / → Créer une recette

POST /complete → Créer une recette avec ses ingrédients

GET /{id}/ingredients → Détail des ingrédients d’une recette

🔍 Recherche
GET /search?categorie=Déssert

GET /search?ingredient=Beurre

🧪 Tester avec Postman
Pour tester facilement toutes les routes, utilisez cette [collection Postman](./recettes-api.postman_collection.json).
Tester tous les crud + recherche

💡 Bonus
. Utilisation de @RequestParam pour filtrer dynamiquement les recettes.

. DTO RecetteDetailDTO pour exposer proprement les données (nom, description, catégorie, liste d’ingrédients).

