<template>
    <v-container class="d-flex align-center justify-center" style="height: 100vh;">
      <v-card class="pa-5" max-width="400px">
        <v-card-title class="text-center">Login to GolfClubPro</v-card-title>
  
        <v-form @submit.prevent="login">
          <v-text-field
            v-model="email"
            label="Email"
            type="email"
            required
          ></v-text-field>
  
          <v-text-field
            v-model="password"
            label="Password"
            type="password"
            required
          ></v-text-field>
  
          <v-btn color="primary" large block type="submit">
            Login
          </v-btn>
  
          <v-divider class="my-4"></v-divider>
  
          <p class="text-center">Don't have an account?</p>
          <v-btn color="secondary" outlined block @click="goToSignup">
            Sign Up
          </v-btn>
        </v-form>
      </v-card>
    </v-container>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: '',
        password: ''
      };
    },
    methods: {
      login() {
        // For now, just redirect to admin dashboard
        this.$router.push('/admin-dashboard');
      },
      goToSignup() {
        // Redirect to signup page
        this.$router.push('/signup');
      },
    },
  };
  </script>
  
  <style scoped>
  .text-center {
    text-align: center;
  }
  </style>