# golfClubPro - Manage your golf courts with ease (Education only)

This repository contains an example of a management app for golf courses for the Software Testing module (SWB 105 6043) at Esslingen University of Applied Sciences.

    Ausschlussklausel: Alle Inhalte dienen ausschließlich Bildungszwecken. Der Inhalt ist nicht für die professionelle Nutzung.
    Disclaimer: All content is for educational purposes only. I do not intend for the content to be a substitute for professional usage.

## Pre-requisits for development

To run the examples, you need to install the following components:

* Java Developer Kit 11 (or higher) - to run and develop Java applications
* Maven - tool to build Java applications and run tests
* JUnit 5 (via Maven) - library to develop and execute JUnit tests
* node.js and npm v18 (or higher) via Node Version Manager - to develop the frontend using vue.js
* OCI complient container runtime - e.g., Docker or Podman
* Container compose orchestration - e.g., docker-compose or podman-compose
* Git (optional) - to clone this repository.

### Linux

For Linux, you can run the following commands to install the pre-requisits:

```sh
$ sudo apt install openjdk-11-jdk maven git # to install (change version number for other Java versions), maven and git all in one
$ java -version # check if java installation was correct
$ maven -version # check if maven installation was correct
$ curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.3/install.sh | bash # to install nvm
$ source ~/.bashrc # source bashrc to use nvm
$ nvm install v18.13.0 # install node and npm using nvm
$ # (optional)
$ git --version # check if git installation was correct
```

### MacOS

For macOS, we assume you have already installed [Homebrew](https://brew.sh/). If not please do it before executing the followng commands.

```sh
$ brew -v   # check if homebrew is installed
$ brew install java maven git # to install latest java jdk, maven and git all in one
$ java -version # check if java installation was correct
$ maven -version # check if maven installation was correct
$ brew install node # to install node and npm
# (optional)
$ git --version # check if git installation was correct
```

## Build and Run in Docker Container Environment

The Vue.js **frontend** as well as the Java Spring-Boot **golfclub-management** components provides Dockerfiles to build containers to run.
The simplest way to build and run the applications is to use the provided **compose** file. The compose file do have the neccessary environmental
information for the containers to run in a "compose" setup even including testing credential information for the database

```sh
$ cd golfClubPro/docker-compose # go into the compose directory
$ # hint: use docker-compose (with '-') when using legacy version1
$ docker compose -f docker-compose.yml build    # builds you all the containers required
$ docker compose -f docker-compose.yml up       # to start all containers in a composed environment | use "down" to stop the containers properly
```

Afterwards, open a Web browser (e.g., Google Chrome, Mozilla Firefox or Microsoft Edge) and navigate to the local instance of the golfClubPro application on [http://localhost:8081/](http://localhost:8081/).