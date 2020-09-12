module.exports = {
  configureWebpack: {
    alias: {
      'assets': '@/assets',
      'common': '@/common',
      'components': '@/components',
      'network': '@/network',
      'views': '@/views',
    }
  },
  devServer: {
    port:8181,
  }
}

