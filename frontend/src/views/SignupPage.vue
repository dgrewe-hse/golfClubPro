<template>
    <v-container class="d-flex align-center justify-center" style="height: 100vh;">
      <v-card class="pa-5" max-width="400px">
        <v-card-title class="text-center">Sign Up for GolfClubPro</v-card-title>
  
        <v-form @submit.prevent="signup">
          <v-text-field
            v-model="name"
            label="Name"
            required
          ></v-text-field>
  
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
  
          <v-text-field
            v-model="confirmPassword"
            label="Confirm Password"
            type="password"
            required
          ></v-text-field>
  
          <v-select
            v-model="role"
            :items="roles"
            label="Select Role"
            required
          ></v-select>
  
          <v-btn color="primary" large block type="submit">
            Sign Up
          </v-btn>
  
          <v-divider class="my-4"></v-divider>
  
          <p class="text-center">Already have an account?</p>
          <v-btn color="secondary" outlined block @click="goToLogin">
            Login
          </v-btn>
        </v-form>
      </v-card>
    </v-container>
  </template>
  
  <script>
  export default {
    data() {
      return {
        name: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: null,
        roles: ['Administrator', 'Member'], // Role selection options
      };
    },
    methods: {
      signup() {
        if (this.password !== this.confirmPassword) {
          alert("Passwords do not match!");
          return;
        }
  
        // Your signup logic (e.g., API call to create a new user)
        // for now logging to console
  
        console.log({
          name: this.name,
          email: this.email,
          password: this.password,
          role: this.role,
        });
  
        // Redirect to the Admin Dashboard after successful signup
        this.$router.push('/admin-dashboard');
      },
      goToLogin() {
        // Redirect to login page
        this.$router.push('/login');
      },
    },
  };
  </script>
  
  <style scoped>
  .text-center {
    text-align: center;
  }
  </style>