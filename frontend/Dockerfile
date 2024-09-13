# Copyright (c) 2024. All rights reserved.
# docker file for the vue.js frontend container
# author: Dennis Grewe

# Use an official Node.js runtime as the base image
FROM node:18-slim

# Set the working directory inside the container
WORKDIR /app

# Copy only package.json and package-lock.json for efficient caching
COPY package.json ./

# Install npm dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Expose the Vue.js development server port
EXPOSE 8081

# Command to run the Vue.js development server with hot reloading
CMD ["npm", "run", "serve"]

