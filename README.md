# QuickComparePlugin

### Android studio plugin. Quick compare using external compare tools acrossing different projects

## Why I develop this plugin?
* Please refer my blog:[http://www.jianshu.com/p/2d7433bf54e9](http://www.jianshu.com/p/2d7433bf54e9)


## Feature
* With auto compare, you don't need to find the same name file in another project. The plugin find it automatically, then enable it. All you need to do is right click.
* Quick compare acrossing different projects with external compare tool.
* Support Windows and Mac OS

## Install 

* Install from Android studio plugin repository, search "quickcompare"
* Checkout source code and build QuickCompare.jar

## How to use?

* After install complete. Go to File->Settings->Other Settings->QuickCompare
    
* Select external compare tool executable path. Click apply. Note: On mac os, you must Install Command Line Tools first. [http://www.scootersoftware.com/support.php?zz=kb_vcs_osx](http://www.scootersoftware.com/support.php?zz=kb_vcs_osx)
    
<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot1.jpg" alt="Drawing" width="450px" />

* Open a file. Right click pop up editor menu. Select menu item "Select Left for Compare"
    
<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot2.jpg" alt="Drawing" width="450px" />

* Open another file. Right click pop up editor menu. Select menu item "Compare to"

<img src="https://github.com/nziyouren/QuickComparePlugin/blob/master/screenshots/windows/screenshot3.jpg" alt="Drawing" width="450px" />

## Change note

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

