def configFilePath = args[0]
def config = new ConfigSlurper().parse(URI.create("file://${configFilePath}").toURL())
def alertHistory = []

while (true) {
    // read data
    def data = new File(config.data.source).text

    // parse temp
    def cTemp = (data.readLines()[1].split("=")[1]) as float
    def fTemp = ((cTemp / 1000) * 9 / 5) + 32

    // if temp is out of range, send an alert and log the event
    if (fTemp < config.temps.min || fTemp > config.temps.max) {
        def now = new Date()
        println "$now Alert: $fTemp"
        alertHistory << now
    } else {
        alertHistory.clear() // if all is good, then clear history
    }

    // if we've exceeded the max messages, quit. this is a spam-be-gone mechanism
    if (alertHistory.size() > config.messaging.maxConsecutiveMessages) {
        System.exit(0)
    }

    sleep config.polling.interval
}