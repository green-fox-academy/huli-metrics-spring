# huli-metrics-spring

Dear Huli Developer!

This is a java library that implements the `/event` endpoint client.

Add this dependency to your build (in case of gradle use the build.gradle file):

'''java
dependencies {
	compile('com.greenfoxacademy.huli-metrics-spring:metrics:1.0.1-RELEASE')
}
'''

Import the external library:

'''java
import com.greenfoxacademy.metrics.Metrics;
'''

Call the 'Metrics.send' method to target the internal metrics backend 
application's endpoint with a json.

'''java
Metrics.send(level: "log", service_name: "template_service");
'''

This the the template API, it contains all the required fields:
- [x] time - is the current time the JSON is sent with
- [x] level - is the type of the log like: LOG, ERROR etc. it takes a String format
- [ ] service_name - is the name of the service the log comes from, this can only be a 
predetermined name like edu_service currently
Additional fields can be added in coordination with the MBT team.

#####HEADERS
**Content-Type** application/json

#####BODY
'''
{
	"time": "1516107575123",
	"level": "log",
	"service_name": "template_service"
}
'''

In this way we'll be able to store useful data in an AWS S3 bucket for greater good and 
to create some fancy charts out of your features!
