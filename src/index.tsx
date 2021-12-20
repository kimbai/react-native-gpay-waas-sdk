import { NativeModules } from 'react-native';

const { GpayWaasSdk } = NativeModules;

export type GpayWaasSdkCallbackType = {
  code: number;
  message: string;
};

export interface GpayWaasSdkGetUserStatusCallbackType
  extends GpayWaasSdkCallbackType {
  userStatus: string;
}

export interface GpayWaasSdkGetUserBalanceCallbackType
  extends GpayWaasSdkCallbackType {
  userBalance: string;
}

export interface GpayWaasSdkPaymentCallbackType
  extends GpayWaasSdkCallbackType {
  paymentOrderId: string;
  paymentTransactionId: string;
}

type GpayWaasSdkType = {
  initSDK(
    enviroment: 'sandbox' | 'product',
    callback?: (result: GpayWaasSdkCallbackType) => void
  ): void;
  setupTheme(theme: 'dark' | 'light'): void;
  setupLanguage(language: 'vi' | 'en'): void;
  homeOpen(
    userId: string,
    phoneNumber: string,
    callback: (result: GpayWaasSdkCallbackType) => void
  ): void;
  getUserStatus(
    callback: (result: GpayWaasSdkGetUserStatusCallbackType) => void
  ): void;
  getUserBalance(
    callback: (result: GpayWaasSdkGetUserBalanceCallbackType) => void
  ): void;
  payment(
    amount: number,
    refId: string,
    embedData: string,
    callbackUrl: string | undefined,
    webhookUrl: string | undefined,
    phoneNumber: string,
    userId: string,
    callback: (result: GpayWaasSdkPaymentCallbackType) => void
  ): void;
  logout(callback?: (result: GpayWaasSdkCallbackType) => void): void;
};

export default GpayWaasSdk as GpayWaasSdkType;
