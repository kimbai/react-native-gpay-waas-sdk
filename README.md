# react-native-gpay-waas-sdk

Gpay WaaS SDK

## Installation

```sh
yarn add https://github.com/kimbai/react-native-gpay-waas-sdk
```
or
```sh
npm install --save https://github.com/kimbai/react-native-gpay-waas-sdk
```
this package require react-native >= 0.60

### Android Setup
Adding the following to your android/app/build.gradle file

```
allprojects {
  repositories {
        flatDir {
            dirs "$rootDir/../node_modules/react-native-gpay-waas-sdk/android/libs"
        }
    }
}
```

### iOS Setup

```sh
cd ios && pod install && cd ..
```

Then update your Info.plist with wanted permissions usage descriptions:
```
<key>NSCameraUsageDescription</key>
<string>Need to access your camera to capture a photo and update profile picture.</string>
```

## Example

```sh
yarn
yarn example ios
or 
yarn example android
```

## Usage

Step 1: import sdk

```js
import GpayWaasSdk from "react-native-gpay-waas-sdk";
```

Step 2: init SDK when start app with appId (example 'ABCDE12345.com.cocoacasts.scribbles_ios')

```js
React.useEffect(() => {
  GpayWaasSdk.initSDK(
    'ABCDE12345.com.cocoacasts.scribbles_ios',
    (result) => {
      console.log(result);
    }
  );
}, []);
```

## Features

### Open Home
parameters:
 - userId: user identifier
 - phoneNumber: user's phone number
 - callback: callback when completed

```js
GpayWaasSdk.openSDK(
  userId,
  phoneNumber,
  (result) => {
    console.log(result);
  }
);
```

### Setup Theme
parameters:
 - theme: 'dark' | 'light'

```js
GpayWaasSdk.setupTheme('dark');
```

### Setup Language
parameters:
 - language: 'vi' | 'en'

```js
GpayWaasSdk.setupLanguage('vi');
```

### Get User Status

```js
GpayWaasSdk.getUserStatus((result) => {
  console.log(result);
});
```

### Get User Balance

```js
GpayWaasSdk.getUserBalance((result) => {
  console.log(result);
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
