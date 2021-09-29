import * as React from 'react';

import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';

import GpayWaasSdk from 'react-native-gpay-waas-sdk';

export default function App() {

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

  return (
    <View style={styles.container}>
      <TouchableOpacity
        onPress={() => {
          GpayWaasSdk.openSDK(
            '',
            '',
            (result) => {
              console.log(result);
            },
            (error) => {
              console.log(error);
            }
          );
        }}
      >
        <Text>Show SDK</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
