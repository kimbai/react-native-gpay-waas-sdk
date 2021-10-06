import { NativeModules } from 'react-native';

const { GpayWaasSdk } = NativeModules;

export type GpayWaasSdkCallbackType = {
  code: number;
  message: string;
};

type GpayWaasSdkType = {
  initSDK(
    appId: string,
    enviroment: 'development' | 'sandbox' | 'product',
    callback: (result: GpayWaasSdkCallbackType) => void
  ): void;
  setupTheme(theme: 'dark' | 'light'): void;
  setupLanguage(language: 'vi' | 'en'): void;
  homeOpen(
    userId: string,
    phoneNumber: string,
    callback: (result: GpayWaasSdkCallbackType) => void
  ): void;
  getUserStatus(callback: (result: GpayWaasSdkCallbackType) => void): void;
  getUserBalance(callback: (result: GpayWaasSdkCallbackType) => void): void;
};

export default GpayWaasSdk as GpayWaasSdkType;
