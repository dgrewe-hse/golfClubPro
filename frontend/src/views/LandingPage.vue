<template>
  <v-container fluid>
    <!-- Hero Section -->
    <v-row class="hero" justify="center" align="center">
      <v-col cols="12" class="text-center">
        <h1>Welcome to GolfClubPro</h1>
        <p>Your solution for managing golf courses, members, and tournaments.</p>
        <v-btn color="primary" dark large @click="goToLogin">
          Login / Sign up
        </v-btn>
      </v-col>
    </v-row>

    <!-- Features Section -->
    <v-row class="features" justify="center">
      <v-col cols="12" md="4" class="text-center">
        <v-card class="mx-auto text-center" max-width="350" height="300">
          <v-img
            src="/images/golf-course-card.webp"
            height="150px"
            alt="Golf Courses"
          ></v-img>
          <v-card-title class="text-center">Manage Golf Courses</v-card-title>
          <v-card-text>
            Easily manage and organize your golf courses, track statistics, and ensure the best experience for golfers.
          </v-card-text>
        </v-card>
      </v-col>

      <v-col cols="12" md="4" class="text-center">
        <v-card class="mx-auto text-center" max-width="350" height="300">
          <v-img
            src="/images/members-card.webp"
            height="150px"
            alt="Members"
          ></v-img>
          <v-card-title class="text-center">Manage Members</v-card-title>
          <v-card-text>
            Keep track of your club members, their activities, and streamline communication with them.
          </v-card-text>
        </v-card>
      </v-col>

      <v-col cols="12" md="4" class="text-center">
        <v-card class="mx-auto text-center" max-width="350" height="300">
          <v-img
            src="/images/tournaments-card.webp"
            height="150px"
            alt="Tournaments"
          ></v-img>
          <v-card-title class="text-center">Manage Tournaments</v-card-title>
          <v-card-text>
            Create and manage golf tournaments, track participants, and generate results with ease.
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  methods: {
    goToLogin() {
      this.$router.push({ path: '/login' });
    }
  }
};
</script>

<style scoped>
.text-center {
  text-align: center;
}
.mx-auto {
  margin-left: auto;
  margin-right: auto;
}
.features {
  padding-bottom: 20px; /* Reduced padding */
}
.hero {
  height: 30vh; /* Reduced height */
  background-color: #f5f5f5; /* Optional background color */
  padding-top: 50px;
}
.v-card {
  text-align: center; /* Center text in cards */
}
.v-card-actions {
  justify-content: center; /* Center button in cards */
}
.v-application--wrap {
  min-height: auto !important; /* Remove the min-height setting */
  padding: 0 !important;       /* Remove unnecessary padding */
}
</style>