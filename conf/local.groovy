data {
    // The node (file) containing the temperature data
    source = "/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/test/data/28-test"
}

polling {
    // how often to query for the current temperature, in milliseconds. we use milliseconds because it is easier to test.
    // to convert milliseconds to minutes, multiply by 60000.
    interval = 5000
}

temps {
    // the minimum allowable temperature. a reading below this will generate an alert
    min = 60

    // the maximum allowable temperature. a reading above this will generate an alert
    max = 70
}

messaging {
    // the number to send SMS alerts to
    sms = "3035149144"

    // after an alert is generated this many times, stop sending alerts.
    maxConsecutiveMessages = 12
}