# QuickComparePlugin

## What's QuickComparePlugin？
It's a Jetbrains product plugin, compatible with all familiar IDEs, such as Android studio, Pycharm, PHPStorm. You can quick compare files and folders with external/internal compare tools **acrossing different projects like BeyondCompare's way**: Select any left file and compare to it. 

## Why I develop this plugin?
* Please refer my blog:[http://www.jianshu.com/p/2d7433bf54e9](http://www.jianshu.com/p/2d7433bf54e9)


## Feature
* Auto compare: You don't need to find and navigate to the same name file in another project manually. The plugin will find it, all you need to do is right click and select "Auto Compare" menu.
* Quick compare: Quick compare like BeyondCompare's way. User don't need to click "compare with" menu and then show a dialog to choose another file.

## Supported platform OS
* Windows
* Mac
* Linux

## Supported Compare tool
* BeyondCompare
* Jetbrains internal diff
* Continue to add more later...

## Install 

* Install from Android studio plugin repository, search "quickcompare"

## How to use?

1. After install complete. Go to File->Settings->Other Settings->QuickCompare
    
2. Select external compare tool executable path. Click apply. Note: On mac os, you must Install Command Line Tools first. [http://www.scootersoftware.com/support.php?zz=kb_vcs_osx](http://www.scootersoftware.com/support.php?zz=kb_vcs_osx)    
<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot1.jpg" alt="Drawing" width="450px" />

3. Open a file. Right click pop up editor menu. Select menu item "Select Left for Compare"
    <img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot2.jpg" alt="Drawing" width="450px" />

4. Open another file. Right click pop up editor menu. Select menu item "Compare to"
<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot3.jpg" alt="Drawing" width="450px" />

## Video

<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/tutorial.gif" alt="Drawing" width="750px" height="410px" />

## Change note

### V0.5.4
* Support internal diff view
* Compatible with other jetbrains familiar IDEs

### V0.5.3
* Fix issue: can't find autoenable.png. Thanks to Simone Z

### V0.5.2
* Fix NPE exception on AndroidStudio 2.3

### V0.5
* Add auto compare function. When select left file to compare, then jump to another project. If the same file existed in another project, the autocompare menu will appear automatically.

### V0.4
* Fixed for 2016.2(AndroidStudio 2.2 and above) compatibilty

### V0.3
* Fix bug:Settings screen apply button doesn't reflect atual state
* Fix bug:Settings screen reset button doesn't work sometimes

### V0.2
* Add Mac OS support.

### V0.1 
* Implement baisc function. Currently only supported windows.
    

# Contact
You can reach me by email nziyouren@gmail.com

# License:
Apache License, Version 2.0

