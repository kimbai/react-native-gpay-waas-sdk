package com.reactnativegpaywaassdk;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.openwallet.ui.widget.OpenWalletSDK;

@ReactModule(name = GpayWaasSdkModule.NAME)
public class GpayWaasSdkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GpayWaasSdk";
    public final static int  REQUEST_CODE = 47706179;
    OpenWalletSDK openWallet;

    public GpayWaasSdkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        openWallet = OpenWalletSDK.create(getReactApplicationContext().getCurrentActivity());
        openWallet.setupTheme(OpenWalletSDK.Theme.DARK);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void initSDK(String appId, Callback onSuccess, Callback onError) {
      openWallet.initializeWith(appId, new OpenWalletSDK.OpenWalletCallback() {
        @Override
        public void onSuccess(String s) {
          onSuccess.invoke(s);
        }

        @Override
        public void onError(String s) {
          onError.invoke(s);
        }

        @Override
        public void onStart() {

        }

        @Override
        public void onStop() {

        }
      });
  }

  @ReactMethod
  public void openSDK(String userId, String phoneNumber, Callback onSuccess, Callback onError) {
    openWallet.openSDKWith(REQUEST_CODE);
  }
}
