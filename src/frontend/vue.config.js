const path = require('path')
const BASE_TARGET_DIR = "main/resources/static"

module.exports = {
    outputDir: path.resolve(__dirname, "../" + BASE_TARGET_DIR),
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:9000',
                ws: true,
                changeOrigin: true
            }
        }
    }
}