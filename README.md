# Application Tondeuse Automatique

## Architecture

Cette application utilise l'Architecture Hexagonale. Cette architecture permet de séparer clairement les logiques métier de l'application des détails techniques comme la base de données, le système de fichiers, et les interfaces utilisateurs.

### Organisation des Modules

Le projet est divisé en plusieurs modules, chacun ayant un rôle spécifique :

- **tondeuse-domain**: Contient la logique métier et les modèles de données.
- **tondeuse-application**: Module où réside la classe principale `TondeuseApplication` et les cas d'utilisation.
- **tondeuse-infrastructure**: Gère toutes les communications externes, comme la base de données et les interfaces web.

## Classe Principale

La classe principale de l'application, `TondeuseApplication`, se trouve dans le module `tondeuse-application`. Cette classe est le point d'entrée de l'application, configurant et lançant le framework Spring Boot.

## Packaging et DevOps
Organisation des Fichiers DevOps
Le projet adopte une stratégie de déploiement avancée utilisant Docker, Jenkins pour l'intégration continue, et Kubernetes pour l'orchestration des conteneurs. Les fichiers relatifs à ces configurations sont organisés dans le dossier devops, facilitant ainsi une distinction nette entre le code de l'application et les outils de gestion de son déploiement.

#### Détails des Fichiers dans le Dossier devops
- **Dockerfile**: Construit l'image Docker de l'application. Ce fichier prépare l'environnement nécessaire pour exécuter l'application, installe les dépendances, configure les variables d'environnement et définit la commande pour démarrer l'application.

- **Jenkinsfile**: Configure le pipeline d'intégration continue avec Jenkins. Ce fichier définit les phases de construction, de test et de déploiement de l'application, garantissant que chaque modification subit des tests et des validations avant d'être déployée.

- **deployment.yml**: Fichier de configuration pour le déploiement sur Kubernetes. Il définit les ressources nécessaires, comme les déploiements, les services et les volumes, pour assurer le bon fonctionnement de l'application dans le cluster Kubernetes.


