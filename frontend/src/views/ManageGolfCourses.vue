<template>
  <v-app>
      <!-- Header Section -->
      <v-app-bar app color="primary" dark>
          <v-toolbar-title>
              <span class="ml-3">GolfClubPro</span>
          </v-toolbar-title>
          <v-spacer></v-spacer>
          <button class="logout-btn" @click="logout">Logout</button>
      </v-app-bar>

    <!-- Navigation Drawer (copied from AdminDashboard) -->
    <v-navigation-drawer app permanent>
      <v-list>
        <v-list-item-group>
          <v-list-item @click="navigateTo('manageGolfCourses')">
            <v-list-item-icon>
              <v-icon>mdi-golf</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Manage Golf Courses</v-list-item-title>
          </v-list-item>

          <v-list-item @click="navigateTo('manageMembers')">
            <v-list-item-icon>
              <v-icon>mdi-account-group</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Manage Members</v-list-item-title>
          </v-list-item>

          <v-list-item @click="navigateTo('manageTournaments')">
            <v-list-item-icon>
              <v-icon>mdi-trophy-variant</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Manage Tournaments</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>

    <!-- Main Content Section -->
    <v-main>
      <v-container fluid>
        <v-btn color="primary" @click="createGolfCourse">Create New Golf Course</v-btn>
        <v-data-table :headers="headers" :items="golfCourses" class="elevation-1">
          <template v-slot:item.actions="{ item }">
            <v-btn color="red" @click="deleteGolfCourse(item.id)">Delete</v-btn>
          </template>
        </v-data-table>
        <!-- No Golf Courses Available Alert -->
        <v-alert
          v-if="golfCourses.length === 0"
          type="info"
          class="text-center"
        >
          No golf courses available at the moment.
        </v-alert>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      headers: [
        { text: 'Course Name', value: 'name' },
        { text: 'Location', value: 'location' },
        { text: 'Actions', value: 'actions', sortable: false },
      ],
      golfCourses: [],
    };
  },
  created() {
    this.fetchGolfCourses();
  },
  methods: {
    fetchGolfCourses() {
      axios.get('http://localhost:8080/api/v1/golfcourses')
        .then(response => {
          this.golfCourses = response.data;
        });
    },
    createGolfCourse() {
      // Logic for creating a golf course (use POST request)
    },
    deleteGolfCourse(id) {
      axios.delete(`http://localhost:8080/api/v1/golfcourses/${id}`)
        .then(() => {
          this.fetchGolfCourses(); // Refresh the table after deletion
        });
    },
    navigateTo(routeName) {
      this.$router.push({ name: routeName });
    },
    logout() {
      this.$router.push('/');
    },
  },
};
</script>

<style scoped>
.v-navigation-drawer {
  width: 200px;
}

.v-app-bar {
  z-index: 2;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #f1f1f1; /* Same color as footer */
  color: #1976d2; /* Changed to match the primary theme */
}

.logout-btn {
  background-color: #1976d2;
  color: white;
  border: none;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  border-radius: 5px;
}

.logout-btn:hover {
  background-color: #1565c0;
}
</style>