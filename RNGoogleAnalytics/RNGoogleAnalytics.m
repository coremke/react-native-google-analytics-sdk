#import "RNGoogleAnalytics.h"
#import <GoogleAnalytics/GAI.h>
#import <GoogleAnalytics/GAIFields.h>
#import <GoogleAnalytics/GAIDictionaryBuilder.h>

@implementation RNGoogleAnalytics

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(createScreenView:(NSString *)screenName)
{
    NSLog(@"It worked: %@", screenName);
    id<GAITracker> tracker = [[GAI sharedInstance] defaultTracker];
    [tracker set:kGAIScreenName value:screenName];
    [tracker send:[[GAIDictionaryBuilder createScreenView] build]];
}
@end
