const path = require('path')
const BASE_TARGET_DIR = "main/resources/static"

module.exports = {
    outputDir: path.resolve(__dirname, "../" + BASE_TARGET_DIR),
    devServer: {
        port: 9090,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    }
}