data {
    // The node (file) containing the temperature data
    source = "/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/test/data/28-test"
}

polling {
    // how often to query for the current temperature, in milliseconds. we use milliseconds because it is easier to test.
    // to convert milliseconds to minutes, multiply by 60000.
    interval = 5000 // 5 seconds
}

temps {
    // the minimum allowable temperature. a reading below this will generate an alert
    min = 60

    // the maximum allowable temperature. a reading above this will generate an alert
    max = 70
}

alerting {
    // alert type. one of "println" or "sms". println is useful for debugging.
    type = "println"

    // the details of the sms post. required only if type = "sms"
    sms {

        // post info
        post {
            url = ""
            auth = ""
        }

        // who is sending the message
        sender = ""

        // who gets the text message
        recipient = ""
    }


    // after an alert is generated this many times, stop sending alerts.
    maxConsecutiveMessages = 12
}

