#
# Be sure to run `pod lib lint iotcamera.podspec' to ensure this is a
# valid spec before submitting.
#
# Any lines starting with a # are optional, but their use is encouraged
# To learn more about a Podspec see https://guides.cocoapods.org/syntax/podspec.html
#

Pod::Spec.new do |s|
  s.name             = 'AnsjerCamera'
  s.version          = '1.3.6'
  s.summary          = 'AnsjerCamera pod'

# This description is used to generate tags and improve search results.
#   * Think: What does it do? Why did you write it? What is the focus?
#   * Try to keep it short, snappy and to the point.
#   * Write the description between the DESC delimiters below.
#   * Finally, don't worry about the indent, CocoaPods strips it!

  s.description      = <<-DESC
A pod for Ansjer iotcamera.
                       DESC

  s.homepage         = 'https://github.com/yancaico/iotcamera'
  # s.screenshots     = 'www.example.com/screenshots_1', 'www.example.com/screenshots_2'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'ziliye' => 'zosidev@163.com' }
  s.source           = { :git => 'https://github.com/yancaico/iotcamera.git', :tag => s.version.to_s }
  # s.social_media_url = 'https://twitter.com/<TWITTER_USERNAME>'

  s.platform = :ios

  s.ios.deployment_target = '10.0'

#   s.source_files = 'Pod/Classes/**/*.{h,m}'
#   s.vendored_frameworks = 'Pod/frameworks/IOTCamera.framework'
# AnsjerCamera
# IOTCamera
    s.preserve_paths = "AnsjerCamera.framework/*"

   s.xcconfig = {
          'FRAMEWORK_SEARCH_PATH[sdk=iphoneos*]' => '$(inherited) "$(PODS_ROOT)/AnsjerCamera"',
          'OTHERCFLAGS[sdk=iphoneos*]' => '$(inherited) -iframework "$(PODS_ROOT)/AnsjerCamera"',
          'OTHER_LDFLAGS[sdk=iphoneos*]' => '$(inherited) -framework AnsjerCamera'
      }
#   s.module_map = true
  # s.resource_bundles = {
  #   'iotcamera' => ['iotcamera/Assets/*.png']
  # }

#   s.public_header_files = 'Pod/Classes/**/*.h', 'Pod/Classes/*.h,'
#   s.public_header_files = 'Pod/Classes/**/*.h'
#   s.pod_target_xcconfig = {
#     'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64'
#   }
#   s.user_target_xcconfig = { 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'arm64' }
  # s.frameworks = 'UIKit', 'MapKit'
  # s.dependency 'AFNetworking', '~> 2.3'
end
