# Zenaclean Mobile System Test

This is the System Test Suite for [Zenaclean Mobile App](https://github.com/DavidePonzini/zenaclean-mobile), using Appium - Selenium - TestNG - JUnit.

## Setting up

To download the repo:

```
git clone https://github.com/riki95/zenaclean-mobile-systemtest
```

* Install [IntelliJ IDEA](https://www.jetbrains.com/idea/).
* Install Android SDK & AVD
* Install [ZenaClean Mobile](https://github.com/DavidePonzini/zenaclean-mobile) on your emulator/smartphone.
* Install [Appium](http://appium.io/)

## Getting started


Open ZenaClean Mobile with WebStorm or another IDE, compile and run the app.
Once it is done, you can close the app but leave opened the react-native-cli with Metro Bundler listening on port 8081 and the emulator opened.

Now open the test project with IntelliJ IDEA.
There is no need to install or import crazy plugins because I have already imported it into the maven file.

Now open Appium.
Go to Advanced and configure like the image.

<img src="https://i.imgur.com/mFdUAyK.png =100x20" alt="drawing" width="350" height="300" />

Start the Server and leave it opened.

## Configuring the tests

We are almost done.
Open IntelliJ IDEA and go under the test folder.
You will find a setUp() method inside. We need to configure it.
The one you find is my personal configuration.
You need to replace udid with your emulator udid. You can find it by running the command
```
adb devices
```
inside the terminal. The result look like this:
![adb](https://i.imgur.com/fztuXte.png)
Replace also platformName depending on Android/iOS devices and platformVersion with the last firmware installed (you find it inside settings on the smartphone).
Replace also deviceName which is the name of your AVD.
Leave the other capabilities like this.

## Running the tests

Now we can start.
You have your react-native-cli opened, your Appium server listening in localhost on 4723 port, your emulator opened.
You can just clic on a test and press run or you can run all of them together.

You will see the emulator or smartphone working. At the end you will se a notify "Test Passed" and you can check your tests on IntelliJ.

![success](https://i.imgur.com/FRSlF08.png)

## Authors

* **Riccardo Basso** - *Università degli studi di Genova*
*
