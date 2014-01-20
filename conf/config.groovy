data {
    // The node (file) containing the temperature data.
    source = "/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/test/data/28-test"
}

polling {
    // How often to query for the current temperature, in milliseconds. We use milliseconds because it is easier to test.
    // To convert milliseconds to minutes, multiply by 60000.
    interval = 180000 // 3 minutes
}

temps {
    // The minimum allowable temperature. A reading below this will generate an alert.
    min = 205

    // The maximum allowable temperature. A reading above this will generate an alert.
    max = 240
}

alerting {
    // Alert type. one of "println" or "sms". println is useful for debugging.
    type = "sms"

    // The details of the sms post. Required only if type = "sms".
    sms {

        // Post info
        post {
            url = "https://api.twilio.com/2010-04-01/Accounts/[account sid]/SMS/Messages.json"
            auth = "[auth token]"
        }

        // Who is sending the message.
        sender = "13030000000"

        // Who gets the text message.
        recipient = "13030000000"
    }


    // After an alert is generated this many times, stop sending alerts. The service must then be restarted.
    maxConsecutiveMessages = 12
}

