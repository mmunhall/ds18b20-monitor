data {
    // The node (file) containing the temperature data
    source = "/sys/bus/w1/devices/28-000004f20dba/w1_slave"
}

polling {
    // how often to query for the current temperature, in milliseconds. we use milliseconds because it is easier to test.
    // to convert milliseconds to minutes, multiply by 60000.
    interval = 180000 // 3 minutes
}

temps {
    // the minimum allowable temperature. a reading below this will generate an alert
    min = 225

    // the maximum allowable temperature. a reading above this will generate an alert
    max = 250
}

alerting {
    // alert type. one of "println" or "sms". println is useful for debugging.
    type = "sms"

    // the details of the sms post
    sms {

        // post info
        post {
            url = "https://api.twilio.com/2010-04-01/Accounts/ACc73f05977e845cae4841f0baf8134f6a/SMS/Messages.json"
            auth = "ACc73f05977e845cae4841f0baf8134f6a:718c427c3a41eedcd6fff40fb523a2de"
        }

        // who is sending the message
        sender = "13039639497"

        // who gets the text message
        recipient = "13035149144"
    }


    // after an alert is generated this many times, stop sending alerts.
    maxConsecutiveMessages = 12
}

