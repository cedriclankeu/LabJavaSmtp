# LabJavaSmtp





###### Contributeurs : Cedric Lankeu , Olivier Djelezeck



### description

Dans le cadre du laboratoire de RES sur SMTP, nous avons eu a implementer une application cliente smtp qui permet  à un user de lancer des campagnes de mail e-mails falsifiés à une liste de victimes.
Pour tester le bon fonctionnement de cette application, nous nous sommes servi d'un serveur fictif appelé MockMock server. Il permet de simuler l'envoi de mail reel d'un emetteur (peu etre fictif) à des destinataire(fictif ou reel) et visualiser ces courrier à travers une interface.

Notre App contient trois fichiers : 

- config.properties :  qui contient les parametres utiles pour la connexion, le nombre de groupes qui sera crée et les adresses à qui les courriers falsifiés seront envoyés.
- messages.utf8 : qui contient une panoplie de message à vehiculer aux victimes
- victims.utf8 : definir la liste des victimes



### Instructions pour la configuration d'un serveur SMTP factice (avec Docker)

On commence d'abord par cloner le projet .

Pour le lancement de notre serveur smtp(MockMock), nous avons deux possibilités pour le faire :

- Soit  télécharger le fichier jar [ici](https://github.com/tweakers-dev/MockMock/blob/master/release/MockMock.jar?raw=true) .  Extraire  à un endroit de votre choix et lancer le serveur en  exécution: `java -jar MockMock.jar`.

-  Exécuter notre script `docker-mockmock.sh`

  Celui ci est un script qui contruit et lance un contenaire docker. 

  ##### Exigences

  - Docker doit etre lancé

Pour le lancement du client ,  nous avons deux possibilités pour le faire:

- Soit vous ouvre le projet maven avec un IDE , ensuite on compile et execute le code.
- Soit vous executez le script clientSmtp.sh

Note : Il est preferable de lancer le serveur avant de lancer le client.



 ### Instructions claires et simples pour configurer votre outil et lancer une campagne de farces



Pour pouvoir lancer une campagne de farces, il vous suffit :

- cloner notre projet

- Editer les fichiers  suivant : 

  Personnaliser la configuration du client. Pour ce faire,  trois fichiers de configuration sont situés dans le dossier /config . 

  Il faut modifiez ces fichiers pour configurer une campagne de farces.

  #### config.properties

  Le fichier `config.properties`contient les parametres de l'application. Modifiez la valeur des parametres suivantes pour l’adapter à vos besoins.

  - **smtpServerAdress** : adresse du serveur SMTP  dont on veut envoyer les courriers électroniques.
  - **smtpServerPort** :  numéro de port du serveur SMTP.
  - **numberOfGroups** : nombre de groupe des victimes à former pour la campagne.

  Exemple de configuration du fichier:

  ```
  smtpServerAdress=localhost
  smtpServerPort=25
  numberOfGroups=7
  witnessestoCC=cedric.lankeungassam@heig-vd.ch
  ```

  #### victims.utf8

  Le fichier `victims.utf8`permet de definir une liste d'adresses (une adresse par ligne)  de toutes les victimes.

  Exemple de liste de victimes:

  ```
  yan.rchod@heig-vd.ch
  cedric.lankeungassam@heig-vd.ch
  ristophe.yet@heig-vd.ch
  rentn.bler@heig-vd.ch
  dael.golezlo@heig-vd.ch
  face.mbinguema@heig-vd.ch
  ```

  #### messages.utf8

  Le fichier `messages.utf8`contient une liste de messages électroniques qui seront selectionné lors de de d'un envoi .

  Syntaxe de definition ds message

  - Subject: 
  - texte à envoyer à une victime
  - "=="  , qui est un separateur de message

  Exemple de syntaxe d'un message:

  ```
  Subject: Appendix D.  Scenarios
  
  This section presents complete scenarios of several types of SMTP
  sessions.  In the examples, "C:" indicates what is said by the SMTP
  client, and "S:" indicates what is said by the SMTP server.
  
  ==
  Subject: Appendix C.  Source Routes
  
  Historically, the <reverse-path> was a reverse source routing list of
  hosts and a source mailbox.  The first host in the <reverse-path> was
  historically the host sending the MAIL command; today, source routes
  SHOULD NOT appear in the reverse-path.
  ==
  ```

- Compiler le projet en se positionnant sur le repertoire racine  :  `maven clean install`

- Positionnez vous dans ce repertoire LabJavaSmtp\target, puis ouvrez le shell et executer "lab-java-smtp-1.0-SNAPSHOT-launcher" en executant la commande :  

  ```
  java -jar  lab-java-smtp-1.0-SNAPSHOT-launcher.jar
  ```

- [ ] Note :  Avant de lancer le client s'assurer que le serveur soit deja demarré.



Une fois que vous avez configuré ces fichiers,  vous pouvez lancer  votre navigateur et saisir :

<http://localhost:8282/>

Ceci vous permettra de voir l'interface du serveur MockMock qui affiche tous les messages envoyés en precisant l'emetteur et les destinataires.

