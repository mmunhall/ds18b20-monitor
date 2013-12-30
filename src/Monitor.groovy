

def configFilePath = args[0]
def config = new ConfigSlurper().parse(URI.create("file://${configFilePath}").toURL())
def alertHistory = []

while (true) {
    // read data
    def data = new File(config.data.source).text

    // parse temp
    def cTemp = (data.readLines()[1].split("=")[1]) as float
    def fTemp = ((cTemp / 1000) * 9 / 5) + 32

    def now = new Date()

    // if temp is out of range, send an alert and log the event
    if (fTemp < config.temps.min || fTemp > config.temps.max) {
        def message = "$now Alert: $fTemp"
        if (config.alerting.type == "println") {
            println message
        } else if (config.alerting.type == "sms") {
            sendSms(message)
        }
        alertHistory << now
    } else {
        if (config.alerting.type == "println") {
            println "$now OK: $fTemp"
        }
        alertHistory.clear() // if all is good, then clear history
    }

    // if we've exceeded the max number of alerts, quit. this is a spam-be-gone mechanism
    if (alertHistory.size() > config.alerting.maxConsecutiveMessages) {
        System.exit(0)
    }

    sleep config.polling.interval
}

def sendSms(message) {
    final HttpURLConnection connection = new URL('http://www.FreeSMSGateway.com/api_send').openConnection()
    connection.setDoOutput(true)
    connection.outputStream.withWriter { Writer writer ->
        writer << "access_token=fba32abf499ab2c834f33a719fa0967f&message=${message}&send_to=post_contacts&post_contacts=3035149144"
        println writer
    }

    String response = connection.inputStream.withReader { Reader reader -> reader.text }
    println response

}