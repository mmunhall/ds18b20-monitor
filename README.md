ds18b20-monitor
===============

Overview
--------

![Overview](doc/overview.jpg "The assembled device")

ds18b20-monitor is a personal electronics project used to monitor temperature and send SMS notifications when the temperature falls below a lower limit or reaches an upper limit. I am personally using the device to monitor the temperature of my smoker and to alert me when the temperature inside the smoker goes below 225 degrees F or above 250 - the ideal temperature range to smoke a beef brisket. My briskets take about 16 hours, so I can start the brisket when I go to bed and let my phone tell me if I need to get up to adjust the temperature of the smoker.

The hardware device consists of a Raspberry Pi model B with a miniature Wifi module and a breadboard with a circuit containing the temperature sensor, the ds18b20. The circuit is connected to the Pi's GPIO.

The software on the Pi is a simple Groovy script with a configuration file for setting properties such as upper and lower temperature limits and SMS account information. (I chose Groovy because I'm a Java and Groovy developer by day and it's a language that I'm comfortable with.) The script could easily be ported to Python, bash or any other language.) The SMS notifications are delegated to [Twilio](http://www.twilio.com) via HTTP post, so a Twilio account is also needed to build and use this project. A Twilio account is free and can be upgraded to remove Twilio's marketing message from the SMS messages.

Keep in mind that this project is in its infancy and is therefore very crude and just about all of the setup is a manual process. I may or may not continue to tinker with the project depending on how useful it is to me in its current state.

Building And Configuring the Device
-----------------------------------

This section addresses all the steps needed to build and configure the device, and install and configure the monitoring software.

First, here is the complete list of Pi and circuit parts needed to assemble the project. I have included links to the items on Adafruit or Radio Shack for reference and convenience, but you can find all of the items at any local electronics store, too.

* Raspberry Pi Model B ([http://www.adafruit.com/products/998](http://www.adafruit.com/products/998))
* Power Cable and SD Card for Pi (or a nice [starter kit](http://www.adafruit.com/products/955))
* Miniature WiFi (802.11b/g/n) Module ([http://www.adafruit.com/products/814](http://www.adafruit.com/products/814))
* Pi Cobbler Breakout and Cable ([http://www.adafruit.com/products/914](http://www.adafruit.com/products/914))
* Half-Size Breadboard ([http://www.adafruit.com/products/64](http://www.adafruit.com/products/64))
* Jumper Wire ([http://www.adafruit.com/products/153](http://www.adafruit.com/products/153))
* One 4.7K or 10K Ohm Resistor ([http://www.radioshack.com/product/index.jsp?productId=2062347](http://www.radioshack.com/product/index.jsp?productId=2062347))
* One DS18B20 Temperature Sensor (The ones linked below come with the resistor listed above.)
	* Basic ([http://www.adafruit.com/products/374](http://www.adafruit.com/products/374))
	* Waterproof ([http://www.adafruit.com/products/381](http://www.adafruit.com/products/381))
	* High Temperature and Waterproof ([http://www.adafruit.com/products/642](http://www.adafruit.com/products/642))

###Pi Assembly and Configuration###

###Circuit Assembly###

###Create a Twilio Account###

###Monitor Software Installation and Configuration###



