package vn.gpay.waas.sdk;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.openwallet.ui.widget.GpayWAASSDK;

import java.util.HashMap;

@ReactModule(name = GpayWaasSdkModule.NAME)
public class GpayWaasSdkModule extends ReactContextBaseJavaModule {
  public static final String NAME = "GpayWaasSdk";

  public GpayWaasSdkModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void initSDK(String appId, String env, Callback callback) {
    GpayWAASSDK.Enviroment sdkEnv;
    if (env.toLowerCase() == "development") {
      sdkEnv = GpayWAASSDK.Enviroment.DEVELOPMENT;
    } else if (env.toLowerCase() == "sandbox") {
      sdkEnv = GpayWAASSDK.Enviroment.SANDBOX;
    } else {
      sdkEnv = GpayWAASSDK.Enviroment.PRODUCT;
    }
    GpayWAASSDK.initializeWith(this.getReactApplicationContext(), appId, sdkEnv, result -> callback.invoke(result));
  }

  @ReactMethod
  public void setupTheme(String theme) {
    GpayWAASSDK.Theme sdkTheme;
    if (theme.toLowerCase() == "dark") {
      sdkTheme = GpayWAASSDK.Theme.DARK;
    } else {
      sdkTheme = GpayWAASSDK.Theme.LIGHT;
    }
    GpayWAASSDK.getInstance().setupTheme(sdkTheme);
  }

  @ReactMethod
  public void setupLanguage(String language) {
    GpayWAASSDK.Language sdkLanguage;
    if (language.toLowerCase() == "vi") {
      sdkLanguage = GpayWAASSDK.Language.VI;
    } else {
      sdkLanguage = GpayWAASSDK.Language.EN;
    }
    GpayWAASSDK.getInstance().setupLanguage(sdkLanguage);
  }

  @ReactMethod
  public void homeOpen(String userId, String phoneNumber, Callback callback) {
    GpayWAASSDK.getInstance().homeOpen(this.getCurrentActivity(), userId, phoneNumber, result -> callback.invoke(result));
  }

  @ReactMethod
  public void getUserStatus(Callback callback) {
    GpayWAASSDK.getInstance().getUserStatus(this.getCurrentActivity(), new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        callback.invoke(result);
      }
    });
  }

  @ReactMethod
  public void getUserBalance(Callback callback) {
    GpayWAASSDK.getInstance().getUserBalance(this.getCurrentActivity(), new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        callback.invoke(result);
      }
    });
  }
}
