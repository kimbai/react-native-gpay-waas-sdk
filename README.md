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
      },
      (error) => {
        console.log(error);
      }
    );
  }, []);
```

## Features

Open SDK
parameters:
 - userId: user identifier
 - phoneNumber: user's phone number
 - onSuccess: callback when open succeed
 - onError: callback when failed
 
```js
React.useEffect(() => {
    GpayWaasSdk.openSDK(
      userId,
      phoneNumber,
      (result) => {
        console.log(result);
      },
      (error) => {
        console.log(error);
      }
    );
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
