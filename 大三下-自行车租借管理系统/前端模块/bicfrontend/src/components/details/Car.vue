<template>
    <div class="car">      
        <CarInfo></CarInfo>
        <div class="footer">
            <BottomBar></BottomBar>
        </div>
    </div>
</template>

<script>
import CarInfo from './CarInfo.vue';
import BottomBar from './BottomBar.vue';

export default {
    name: 'Car',
    components: {
        CarInfo,
        BottomBar
    }
}
</script>

<style scoped>
.car{
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
}
.footer{
    width: 100%;
    position: fixed;
    bottom: 0;
}
</style>