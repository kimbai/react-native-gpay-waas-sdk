package vn.gpay.waas.sdk;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
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
  public void initSDK(String env, Callback callback) {
    GpayWAASSDK.Enviroment sdkEnv;
    if (env.toLowerCase().equals("development")) {
      sdkEnv = GpayWAASSDK.Enviroment.DEVELOPMENT;
    } else if (env.toLowerCase().equals("sandbox")) {
      sdkEnv = GpayWAASSDK.Enviroment.SANDBOX;
    } else {
      sdkEnv = GpayWAASSDK.Enviroment.PRODUCT;
    }
    GpayWAASSDK.initializeWith(this.getReactApplicationContext(), sdkEnv, new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        if (result != null) {
          WritableMap map = new WritableNativeMap();
          map.putString("code", result.get("code"));
          map.putString("message", result.get("message"));
          callback.invoke(map);
        }
      }
    });
  }

  @ReactMethod
  public void setupTheme(String theme) {
    GpayWAASSDK.Theme sdkTheme;
    if (theme.toLowerCase().equals("dark")) {
      sdkTheme = GpayWAASSDK.Theme.DARK;
    } else {
      sdkTheme = GpayWAASSDK.Theme.LIGHT;
    }
    GpayWAASSDK.getInstance().setupTheme(sdkTheme);
  }

  @ReactMethod
  public void setupLanguage(String language) {
    GpayWAASSDK.Language sdkLanguage;
    if (language.toLowerCase().equals("vi")) {
      sdkLanguage = GpayWAASSDK.Language.VI;
    } else {
      sdkLanguage = GpayWAASSDK.Language.EN;
    }
    GpayWAASSDK.getInstance().setupLanguage(sdkLanguage);
  }

  @ReactMethod
  public void homeOpen(String userId, String phoneNumber, Callback callback) {
    GpayWAASSDK.getInstance().homeOpen(this.getCurrentActivity(), userId, phoneNumber, new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        if (result != null) {
          WritableMap map = new WritableNativeMap();
          map.putString("code", result.get("code"));
          map.putString("message", result.get("message"));
          callback.invoke(map);
        }
      }
    });
  }

  @ReactMethod
  public void getUserStatus(Callback callback) {
    GpayWAASSDK.getInstance().getUserStatus(this.getCurrentActivity(), new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        if (result != null) {
          WritableMap map = new WritableNativeMap();
          map.putString("code", result.get("code"));
          map.putString("message", result.get("message"));
          callback.invoke(map);
        }
      }
    });
  }

  @ReactMethod
  public void getUserBalance(Callback callback) {
    GpayWAASSDK.getInstance().getUserBalance(this.getCurrentActivity(), new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
        if (result != null) {
          WritableMap map = new WritableNativeMap();
          map.putString("code", result.get("code"));
          map.putString("message", result.get("message"));
          callback.invoke(map);
        }
      }
    });
  }

  @ReactMethod
  public void paymentWithAmount(double amount, String phoneNumber, String userId, Callback callback) {
    AppCompatActivity activity = this.getCurrentActivity() != null && this.getCurrentActivity() instanceof AppCompatActivity ? (AppCompatActivity) this.getCurrentActivity() : null;
    if (activity != null) {
      GpayWAASSDK.getInstance().initPayment(activity, String.valueOf(amount), phoneNumber, userId, new GpayWAASSDK.onComplete() {
        @Override
        public void onComplete(HashMap<String, String> result) {
          if (result != null) {
            WritableMap map = new WritableNativeMap();
            map.putString("code", result.get("code"));
            map.putString("message", result.get("message"));
            callback.invoke(map);
          }
        }
      });
    } else {
      Toast.makeText(this.getCurrentActivity(), "Feature not supported", Toast.LENGTH_LONG).show();
    }
  }

  @ReactMethod
  public void logout() {
    GpayWAASSDK.getInstance().logout(new GpayWAASSDK.onComplete() {
      @Override
      public void onComplete(HashMap<String, String> result) {
//        if (result != null) {
//          WritableMap map = new WritableNativeMap();
//          map.putString("code", result.get("code"));
//          map.putString("message", result.get("message"));
//          callback.invoke(map);
//        }
      }
    });
  }
}
