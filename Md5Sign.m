//
//  Md5Sign.m
//  bangbang
//
//  Created by davinlau on 14-9-26.
//
//

#import "Md5Sign.h"
#import <Cordova/CDV.h>

@implementation Md5Sign

- (void)sign:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString *mystr = [command.arguments objectAtIndex:0];
    //mystr = @"success return!!!!!!!";
    //NSString *signstr=[mystr stringByAppendingString:@"ouxuan1234"];
    mystr = [mystr stringByAppendingString:@"ouxuan1234"];
    const char *cStr = [mystr UTF8String];
    unsigned char result[16];
    CC_MD5( cStr, strlen(cStr), result );
    mystr = [NSString stringWithFormat:
            @"%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x",
            result[0], result[1], result[2], result[3],
            result[4], result[5], result[6], result[7],
            result[8], result[9], result[10], result[11],
            result[12], result[13], result[14], result[15]
            ];

    if (mystr != nil && [mystr length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:mystr];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
