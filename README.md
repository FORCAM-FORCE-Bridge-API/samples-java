# samples-java

Provides sample applications for using the FORCAM FORCE Bridge API with Java.
If you have any questions look at https://ask.forcebridge.io/

### Useful Links

* Website: https://www.forcebridge.io/ | https://www.forcam.com/
* Documentation: https://docs.forcebridge.io/
* API Definition: https://app.swaggerhub.com/apis-docs/FORCAM/FORCEBridgeAPI/
### Usage / Requirements

###### Access to a FORCAM FORCE Bridge API System

_If you need access to a demo system please contact forcebridge@forcam.com._

Please add your URL, user and password of your Bridge API instance to the variables below (contained by all samples).

```Java

String user; // YOUR USER (e.g. GitHub)
String password; // YOUR PASSWORD (e.g. GitHub)
String urlToken = ""; // YOUR URL (e.g. https://forcebridgehackathon.force.eco:24443/ffwebservices/)
```

###### Framework & Tool

Eclipse IDE runtime (https://www.eclipse.org/downloads)
Package for converting json (https://jar-download.com/artifacts/com.google.code.gson/gson/2.8.2/source-code)

### Description of the sample applications:

# Authentication

A small Eclipse Java console application wich authenticates to a FORCAM FORCE Bridge API and prints out the token information.

![Image](Assets/AuthenticationGif.gif)

Folder: "Authentication".

# Get all available workplaces

A small Eclipse Java console application wich authenticates to a FORCAM FORCE Bridge API, determine all available workplaces and prints them out.

![Image](Assets/GetAvailableWorkplacesGif.gif)

Folder: "GetAvailableWorkplaces".

# Get current operating state of a workplace

A small Eclipse Java console application wich authenticates to a FORCAM FORCE Bridge API, determine the operating state of an workplace and print it.

![Image](Assets/GetOperatingStateOfWorkplaceGif.gif)

Folder: "GetOperatingStateOfWorkplace".

# Get all operating states

A small Eclipse Java console application wich authenticates to a FORCAM FORCE Bridge API, determine all operating states and prints them out.

![Image](Assets/GetOperatingStatesGif.gif)

Folder: "GetOperatingStates".
