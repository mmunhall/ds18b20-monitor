def config = new ConfigSlurper().parse(new File('/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/conf/local.groovy').toURL())

def data = new File(config.data.source).text
def cTemp = data.readLines()[1].split("=")[1] as float
def fTemp = ((cTemp / 1000) * 9 / 5) + 32

println fTemp