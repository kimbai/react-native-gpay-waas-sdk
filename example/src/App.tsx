import GpayWaasSdk, {
  GpayWaasSdkCallbackType,
} from 'react-native-gpay-waas-sdk';
import React, { useEffect, useRef, useState } from 'react';
import {
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
  View,
} from 'react-native';

const APP_ID = 'ABCDE12345.com.cocoacasts.scribbles_ios';

export default function App() {
  useEffect(() => {
    GpayWaasSdk.initSDK(APP_ID, 'development', (result) => {
      console.log(result);
      GpayWaasSdk.setupLanguage('vi');
      GpayWaasSdk.setupTheme('light');
    });
    getBalance();
    getStatus();
  }, []);

  const [userId, setUserId] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [userStatus, setUserStatus] =
    useState<GpayWaasSdkCallbackType>(undefined);
  const [userBalance, setUserBalance] =
    useState<GpayWaasSdkCallbackType>(undefined);

  const getBalance = () => {
    GpayWaasSdk.getUserBalance((result) => {
      setUserBalance(result);
    });
  };

  const getStatus = () => {
    GpayWaasSdk.getUserStatus((result) => {
      setUserStatus(result);
    });
  };

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        placeholder="User ID"
        onChangeText={(text: string) => setUserId(text)}
      />
      <TextInput
        style={styles.input}
        placeholder="Phone Number"
        onChangeText={(text: string) => setPhoneNumber(text)}
      />
      <View style={styles.row}>
        <Text style={styles.label}>Status</Text>
        <Text style={styles.content}>{userStatus?.message}</Text>
      </View>
      <View style={styles.row}>
        <Text style={styles.label}>Balance</Text>
        <Text style={styles.content}>{userBalance?.message}</Text>
      </View>
      <TouchableOpacity
        style={styles.button}
        onPress={() => {
          GpayWaasSdk.homeOpen(userId, phoneNumber, (result) => {
            console.log(result);
          });
        }}
      >
        <Text style={styles.buttonTitle}>Show SDK</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingVertical: 64,
    paddingHorizontal: 32,
  },
  row: {
    flexDirection: 'row',
    paddingVertical: 16,
  },
  input: {
    fontSize: 14,
    color: '#2d2d2d',
    borderColor: '#4a4a4a',
    borderWidth: 1,
    borderRadius: 4,
    padding: 8,
    marginVertical: 8,
  },
  label: {
    fontSize: 14,
    flex: 1,
  },
  content: {
    fontSize: 14,
    color: '#4a4a4a',
    fontWeight: 'bold',
  },
  button: {
    backgroundColor: '#5555cc',
    padding: 10,
    borderRadius: 8,
    alignItems: 'center',
  },
  buttonTitle: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
  },
});
