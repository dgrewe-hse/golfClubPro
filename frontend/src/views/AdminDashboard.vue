<template>
    <v-app>
        <!-- Header Section -->
        <v-app-bar app color="primary" dark>
            <!-- Highlighted Change: Application icon and name -->
            <v-toolbar-title>
                <span class="ml-3">GolfClubPro</span>
            </v-toolbar-title>

            <!-- Highlighted Change: Logout Button -->
            <v-spacer></v-spacer>
            <button class="logout-btn" @click="logout">Logout</button> <!-- Styled Button -->
        </v-app-bar>

        <!-- Navigation Drawer (below the header) -->
        <v-navigation-drawer app permanent>
        <v-list>
            <v-list-item-group>
            <v-list-item @click="navigateTo('/manageGolfCourses')"> <!-- Route to golfcourse management -->
                <v-list-item-icon>
                <v-icon>mdi-golf</v-icon> <!-- Management icon for golf courses -->
                </v-list-item-icon>
                <v-list-item-title>Manage Golf Courses</v-list-item-title>
            </v-list-item>

            <v-list-item @click="navigateTo('/manageMembers')"> <!-- Route to members management -->
                <v-list-item-icon>
                <v-icon>mdi-account-group</v-icon> <!-- Management icon for members -->
                </v-list-item-icon>
                <v-list-item-title>Manage Members</v-list-item-title>
            </v-list-item>

            <v-list-item @click="navigateTo('/manageTournaments')"> <!-- Route to tournaments management -->
                <v-list-item-icon>
                <v-icon>mdi-trophy-variant</v-icon> <!-- Management icon for tournaments -->
                </v-list-item-icon>
                <v-list-item-title>Manage Tournaments</v-list-item-title>
            </v-list-item>
            </v-list-item-group>
        </v-list>
        </v-navigation-drawer>
  
      <!-- Main Content -->
      <v-main>
        <v-container fluid>
          <v-row>
            <!-- Golf Courses Card -->
            <v-col cols="12" md="4">
              <v-card>
                <v-card-title>Total Golf Courses</v-card-title>
                <v-card-text>
                  {{ totalGolfCourses }} courses
                </v-card-text>
              </v-card>
            </v-col>
  
            <!-- Members Card -->
            <v-col cols="12" md="4">
              <v-card>
                <v-card-title>Total Members</v-card-title>
                <v-card-text>
                  {{ totalMembers }} members
                </v-card-text>
              </v-card>
            </v-col>
  
            <!-- Tournaments Calendar Card -->
            <v-col cols="12" md="4">
              <v-card>
                <v-card-title>Scheduled Tournaments</v-card-title>
                <v-card-text>
                  <v-calendar
                    v-model="tournamentDates"
                    type="month"
                    :events="tournamentEvents"
                  ></v-calendar>
                </v-card-text>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
  
        <!-- Dynamic View -->
        <router-view></router-view>
      </v-main>
    </v-app>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        totalGolfCourses: 0,
        totalMembers: 0,
        tournamentDates: new Date().toISOString().substr(0, 10),
        tournamentEvents: [],
      };
    },
    methods: {
      navigateTo(routeName) {
        this.$router.push(routeName);
      },
      fetchGolfCourses() {
        axios
          .get('http://localhost:8080/api/v1/golfcourses')
          .then(response => {
            this.totalGolfCourses = response.data.length;
          })
          .catch(error => {
            console.error('Error fetching golf courses:', error);
          });
      },
      fetchMembers() {
        axios
          .get('http://localhost:8080/api/v1/members')
          .then(response => {
            this.totalMembers = response.data.length;
          })
          .catch(error => {
            console.error('Error fetching members:', error);
          });
      },
      fetchTournaments() {
        axios
          .get('http://localhost:8080/api/v1/tournaments')
          .then(response => {
            this.tournamentEvents = response.data.map(tournament => ({
              name: tournament.name,
              start: tournament.date,
              end: tournament.date,
            }));
          })
          .catch(error => {
            console.error('Error fetching tournaments:', error);
          });
      },
      logout() {
        // Redirect to the landing page
        this.$router.push('/');
      },
    },
    created() {
      this.fetchGolfCourses();
      this.fetchMembers();
      this.fetchTournaments();
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
    background-color: #1976d2; /* Same color as footer */
    color: #f1f1f1; /* Changed to match the primary theme */
  }

.logout-btn {
  position: absolute;
  top: 10px;
  right: 20px;
  background-color: #f1f1f1; /* Vuetify primary color */
  color: #1976d2;
  border: none;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  border-radius: 5px;
}

.logout-btn:hover {
  background-color: #1565c0; /* Darker shade on hover */
}
</style>