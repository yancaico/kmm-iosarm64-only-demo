//
//  iosAppTests.m
//  iosAppTests
//
//  Created by ansjer on 2023/2/2.
//  Copyright © 2023 orgName. All rights reserved.
//

#import <XCTest/XCTest.h>
#import <shared/shared.h>

@interface iosAppTests : XCTestCase

@end

@implementation iosAppTests

- (void)setUp {

    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testExample {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    NSString *greet = [[[SharedGreeting alloc] init] greet];
    NSAssert([greet containsString:@"iOS"], @"iOS");
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    }];
}

@end
