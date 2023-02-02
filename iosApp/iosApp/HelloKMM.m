//
//  HelloKMM.m
//  iosApp
//
//  Created by ansjer on 2023/2/1.
//  Copyright © 2023 orgName. All rights reserved.
//

#import "HelloKMM.h"

@implementation HelloKMM

- (void)greet {
    SharedGreeting *greeting = [[SharedGreeting alloc] init];
    [greeting greet];
}

@end
