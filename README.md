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

Step 2: init SDK with enviroment

```js
const env = 'development'; // 'development' | 'sandbox' | 'staging' | 'product',
React.useEffect(() => {
  GpayWaasSdk.initSDK(
    env,
    (result) => {
      console.log(result);
    }
  );
}, []);
```

## Features

### Open Home

| Parameters  |             | Type        | Description             |
| ----------- | ----------- | ----------- | -----------             |
| userId      |             | string      | user's identifier       |
| phoneNumber |             | string      | user's phone number     |
| callback    |             | Callback    | callback when completed |
|             | code        | string      | result code             |
|             | message     | string      | result message          |

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

| Parameters  |             | Type        | Description             |
| ----------- | ----------- | ----------- | -----------             |
| callback    |             | Callback    | callback when completed |
|             | code        | string      | result code             |
|             | message     | string      | result message          |
|             | userStatus  | string      | user's status           |

```js
GpayWaasSdk.getUserStatus((result) => {
  console.log(result);
});
```

### Get User Balance

| Parameters  |             | Type        | Description             |
| ----------- | ----------- | ----------- | -----------             |
| callback    |             | Callback    | callback when completed |
|             | code        | string      | result code             |
|             | message     | string      | result message          |
|             | userBalance | string      | user's balance          |

```js
GpayWaasSdk.getUserBalance((result) => {
  console.log(result);
});
```
### Payment

| Parameters  |                      | Type        | Description              |
| ----------- | -----------          | ----------- | -----------              |
| amount      |                      | number      | amount of transaction    |
| refId       |                      | string      | reference of transaction |
| embedData   |                      | string      | embed data               |
| callbackUrl |                      | string      | callbackUrl              |
| webhookUrl  |                      | string      | webhookUrl               |
| phoneNumber |                      | string      | user's phone number      |
| userId      |                      | string      | user's identifier        |
| callback    |                      | Callback    | callback when completed  |
|             | code                 | string      | result code              |
|             | message              | string      | result message           |
|             | paymentOrderId       | string      | order Id from Gpay       |
|             | paymentTransactionId | string      | corresponding refId Gpay |

```js
GpayWaasSdk.payment(amount, refId, embedData, phoneNumber, userId, (result) => {
  console.log(result);
});
```

### Logout

| Parameters  |             | Type        | Description             |
| ----------- | ----------- | ----------- | -----------             |
| callback    |             | Callback    | callback when completed |
|             | code        | string      | result code             |

```js
GpayWaasSdk.logout((result) => {
  console.log(result);
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
