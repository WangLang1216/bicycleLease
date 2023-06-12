<script setup>
import HelloWorld from './components/HelloWorld.vue';
import Home from './components/Home.vue';
</script>

<template>
  <div class="app">
    <Home></Home>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
    Home
  }
}
</script>

<style scoped>
  .app{
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
  }
</style>
