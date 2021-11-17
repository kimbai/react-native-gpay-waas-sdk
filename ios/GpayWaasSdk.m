#import "GpayWaasSdk.h"
#import <React/RCTLog.h>

@import GpayWAAS;

@implementation GpayWaasSdk

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(initSDK:(NSString *)enviroment callback:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    GpayWAASSDKEnv env;
    if ([[enviroment lowercaseString] isEqualToString:@"development"]) {
      env = GpayWAASSDKEnvDevelopment;
    } else if ([[enviroment lowercaseString] isEqualToString:@"sandbox"]) {
      env = GpayWAASSDKEnvSandbox;
    } else {
      env = GpayWAASSDKEnvProduct;
    }
    [[GpayWAASSDK sharedInstance] initializeWithEnviroment:env onComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

RCT_EXPORT_METHOD(setupTheme:(NSString *)theme) {
  dispatch_async(dispatch_get_main_queue(), ^{
    GpayWAASSDKTheme sdkTheme;
    if ([[theme lowercaseString] isEqualToString:@"dark"]) {
      sdkTheme = GpayWAASSDKThemeDark;
    } else {
      sdkTheme = GpayWAASSDKThemeLight;
    }
    [[GpayWAASSDK sharedInstance] setupTheme:sdkTheme];
  });
}

RCT_EXPORT_METHOD(setupLanguage:(NSString *)language) {
  dispatch_async(dispatch_get_main_queue(), ^{
    GpayWAASSDKLang sdkLanguage;
    if ([[language lowercaseString] isEqualToString:@"vi"]) {
      sdkLanguage = GpayWAASSDKLangVietnamese;
    } else {
      sdkLanguage = GpayWAASSDKLangEnglish;
    }
    [[GpayWAASSDK sharedInstance] setupLanguage:sdkLanguage];
  });
}

RCT_EXPORT_METHOD(homeOpen:(NSString *)userId phoneNumber:(NSString *)phoneNumber callback:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GpayWAASSDK sharedInstance] homeOpenWithUserId:userId phoneNumber:phoneNumber onComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

RCT_EXPORT_METHOD(getUserStatus:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GpayWAASSDK sharedInstance] getUserStatusOnComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

RCT_EXPORT_METHOD(getUserBalance:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GpayWAASSDK sharedInstance] getUserBalanceOnComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

RCT_EXPORT_METHOD(payment:(double)amount
                  refId:(NSString *)refId
                  embedData:(NSString *)embedData
                  callbackUrl:(NSString * _Nullable)callbackUrl
                  webhookUrl:(NSString * _Nullable)webhookUrl
                  phoneNumber:(NSString *)phoneNumber
                  userId:(NSString *)userId
                  callback:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GpayWAASSDK sharedInstance] paymentWithAmount:amount
                                              refId:refId
                                          embedData:embedData
                                        callbackUrl:callbackUrl
                                         webhookUrl:webhookUrl
                                        phoneNumber:phoneNumber
                                             userId:userId
                                         onComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

RCT_EXPORT_METHOD(logout:(RCTResponseSenderBlock)callback) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[GpayWAASSDK sharedInstance] logoutOnComplete:^(NSDictionary<NSString *,NSString *> *result) {
      if (result != nil) {
        callback(@[result]);
      } else {
        callback(@[]);
      }
    }];
  });
}

@end
