import Vue from 'vue';
import App from './App.vue';
import Vuetify from 'vuetify'; // Import Vuetify for styling
import 'vuetify/dist/vuetify.min.css'; // Import Vuetify CSS
import router from './router'; // Import router configuration

Vue.config.productionTip = false;

Vue.use(Vuetify);

new Vue({
  vuetify: new Vuetify(),
  router, // Inject the router into the Vue instance
  render: (h) => h(App), // Render the App component
}).$mount('#app');
