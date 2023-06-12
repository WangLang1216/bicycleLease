import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'



// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  lintOnSave: false,
  proxy:{
    '/api':{
      target:'http://localhost:8080',
      changOrigin: true,
      pathRewrite:{
        '^/api':''
      }
    }
  }
});


