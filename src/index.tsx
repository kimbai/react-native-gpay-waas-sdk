import { NativeModules } from 'react-native';

const { GpayWaasSdk } = NativeModules;

type GpayWaasSdkType = {
  initSDK(
    appId: string,
    onSuccess: (result: any) => void,
    onError: (error: any) => void
  ): void;
  openSDK(
    userId: string,
    phoneNumber: string,
    onSuccess: (result: any) => void,
    onError: (error: any) => void
  ): void;
};

export default GpayWaasSdk as GpayWaasSdkType;
