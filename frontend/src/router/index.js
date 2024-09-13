import Vue from 'vue';
import Router from 'vue-router';

// Import the views
import LandingPage from '../views/LandingPage.vue'; // Import LandingPage
import LoginPage from '../views/LoginPage.vue'; // Import LoginPage
import SignupPage from '../views/SignupPage.vue'; // Import SignupPage
import AdminDashboard from '../views/AdminDashboard.vue'; // Import AdminDashboard
import ManageGolfCourses from '../views/ManageGolfCourses.vue'; // Import ManageGolfCourses
// import ManageMembers from '../views/ManageMembers.vue'; // Import ManageMembers
// import ManageTournaments from '../views/ManageTournaments.vue'; // Import ManageTournaments

Vue.use(Router);

const router = new Router({
  mode: 'history', // Use history mode to remove the hash (#) from URLs
  routes: [
    {
      path: '/',
      name: 'LandingPage',
      component: LandingPage,
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginPage, // Add the Login route
    },
    {
      path: '/signup',
      name: 'Signup',
      component: SignupPage, // Add the Signup route
    },
    {
      path: '/admin-dashboard',
      name: 'AdminDashboard',
      component: AdminDashboard, // Add the AdminDashboard route
      // meta: { requiresAuth: true }, // Optionally, protect this route for authenticated users
    },
    {
      path: '/manageGolfCourses',
      name: 'ManageGolfCourses',
      component: ManageGolfCourses, // Manage golf courses view
    },
    // {
    //   path: '/manageMembers',
    //   name: 'ManageMembers',
    //   component: ManageMembers, // Manage members view
    // },
    // {
    //   path: '/manageTournaments',
    //   name: 'ManageTournaments',
    //   component: ManageTournaments, // Manage tournaments view
    // }
  ]
});

// Navigation Guard to check for logged-in users
// router.beforeEach((to, from, next) => {
//   const loggedIn = true; // Replace with your actual logic for checking authentication
//
//   if (to.matched.some(record => record.meta.requiresAuth) && !loggedIn) {
//     next('/login'); // Redirect to login if not authenticated
//   } else {
//     next(); // Allow to proceed if authenticated
//   }
// });

export default router;