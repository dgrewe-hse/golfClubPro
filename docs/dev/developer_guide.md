# Developer Guide

Welcome to the developer guide for this repository. As you might have noticed, we are developing the code
using the concept of [Development Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) in Microsoft Visual Studio Code. 
Main target of this structure is the reduction of side-effects due to mismatching versions in execution runtimes, build tools, etc. If you are curious what deve

## DevContainer Setup

Please do the following preparations to develop within this repositories:

* Install Microsoft Visual Studio Code: [Download Visual Studio Code - Mac, Linux, Windows](https://code.visualstudio.com/Download)
* Install a container runtime of your choice, e.g., Docker Desktop, Podman, etc.
  * Podman desktop: [Podman Desktop - Containers and Kubernetes | Podman Desktop (podman-desktop.io)](https://podman-desktop.io/)
  * Docker Desktop: [Docker Desktop: The #1 Containerization Tool for Developers | Docker](https://www.docker.com/products/docker-desktop/)
  * **Hint: Make sure you provide to your container runtime at least 2 GB RAM, better 4GB of RAM**
* Install Devcontainer Extension for VS Code: [Dev Containers - Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

## DevContainer Project Setup

All project related environment instructions and aspects such as the right Java, node.js runtimes and build toolchains are part of the DevContainer environment configuration. 
You can find the configuration and installation scripts in the **.devcontainer** directory within this project. Be patient during the first time installation, if you are 
starting the DevContainer of this repository the first time. Afterwards, you can start to build or implement new components within this repository. 
Instructions on how to build the project are available on the main README file of the project.