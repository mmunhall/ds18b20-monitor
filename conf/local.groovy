data {
    source = "/Users/michaelmunhall/Documents/workspace/ds18b20-monitor/test/data/28-test"
}

temps {
    min = 60
    max = 70
}

messaging {
    sms = "3035149144"
    maxFrequency = 5
    maxConsecutiveMessages = 12
}