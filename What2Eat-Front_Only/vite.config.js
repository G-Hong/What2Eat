// vite.config.js
import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 백엔드 서버 주소가 맞는지 확인
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''), // /api 경로를 제거하고 백엔드 서버로 요청을 전달
      },
    },
  },
});
