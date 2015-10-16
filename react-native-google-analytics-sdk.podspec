Pod::Spec.new do |s|
  s.name         = "react-native-google-analytics-sdk"
  s.version      = "0.0.1"
  s.summary      = "React Native Google Analytics SDK Integration"
  s.homepage     = "https://github.com/gsmke/react-native-google-analytics-sdk"
  s.license      = "MIT"
  s.author             = { "Chris Erickson" => "chris.erickson@gsdesign.com" }
  s.platform     = :ios
  s.platform     = :ios, "8.0"
  s.source       = { :git => "http://github.com/gsmke/react-native-google-analytics-sdk.git", :tag => "0.0.1" }
  s.source_files  = "RNGoogleAnalytics", "RNGoogleAnalytics/**/*.{h,m}"
  s.requires_arc = true
  s.dependency "GoogleAnalytics", "3.13.0"
end
