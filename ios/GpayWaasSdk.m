#import "GpayWaasSdk.h"
#import <React/RCTLog.h>

@import OpenWallet;

@implementation GpayWaasSdk

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(initSDK:(NSString *)appId onSuccess:(RCTResponseSenderBlock)onSuccess onError:(RCTResponseSenderBlock)onError) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[OpenWalletSDK sharedInstance] initializeWithAppId:appId
                                                  theme:OpenWalletThemeDark
                                               language:OpenWalletLangVietnamese
                                             enviroment:OpenWalletEnvDevelopment
                                              onSuccess:^(NSDictionary<NSString *,NSString *> * _Nullable object) {
      if (object != nil) {
        onSuccess(@[object]);
      } else {
        onSuccess(@[]);
      }
      
      RCTLogInfo(@"[GpayWAASSDK] init SDK: %@", object);
    } onError:^(NSDictionary<NSString *,NSString *> * _Nullable object) {
      if (object != nil) {
        onError(@[object]);
      } else {
        onError(@[]);
      }
      
      RCTLogInfo(@"[GpayWAASSDK] init SDK error: %@", object);
    }];
  });
}

RCT_EXPORT_METHOD(openSDK:(NSString *)userId phoneNumber:(NSString *)phoneNumber onSuccess:(RCTResponseSenderBlock)onSuccess onError:(RCTResponseSenderBlock)onError) {
  dispatch_async(dispatch_get_main_queue(), ^{
    [[OpenWalletSDK sharedInstance] openSDKWithUserId:userId
                                          phoneNumber:phoneNumber
                                            onSuccess:^(NSDictionary<NSString *,NSString *> *object) {
      if (object != nil) {
        onSuccess(@[object]);
      } else {
        onSuccess(@[]);
      }
      
      RCTLogInfo(@"[GpayWAASSDK] open SDK: %@", object);
    } onError:^(NSDictionary<NSString *,NSString *> *object) {
      if (object != nil) {
        onError(@[object]);
      } else {
        onError(@[]);
      }
      
      RCTLogInfo(@"[GpayWAASSDK] open SDK error: %@", object);
    }];
  });
}

@end
