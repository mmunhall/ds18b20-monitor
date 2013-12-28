def config = new ConfigSlurper().parse(new File('/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/conf/local.groovy').toURL())

def data = new File(config.data.source).text

println data