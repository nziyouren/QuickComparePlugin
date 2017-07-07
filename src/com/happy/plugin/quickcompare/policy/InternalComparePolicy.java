package com.happy.plugin.quickcompare.policy;

import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.vfs.VirtualFile;

import java.io.IOException;

/**
 * Created by zhang on 2017/7/7.
 */
public class InternalComparePolicy extends AbstractComparePolicy {
    @Override
    public void compare(VirtualFile leftFile, VirtualFile rightFile) {

//        RUN_PATH = u'/Applications/AndroidStudioAll/Android Studio2.3.1.app'

        System.out.println("homepath:" + PathManager.getHomePath());

        Process p = null;
        try {
//            System.out.println("before compare...");
//            PropertiesComponent component = PropertiesComponent.getInstance();
//            if (StringUtil.isEmpty(component.getValue("bc"))){
//
//                System.out.println("pls set bc path first...");
//
//            }else {
//                String comparePath = component.getValue("bc");
//                String[] execStringArray = new String[]{comparePath,leftFile.getPath(),rightFile.getPath()};
//                Runtime.getRuntime().exec(execStringArray);
//                System.out.println("after compare...");
//            }

            System.out.println("before compare...");
            String comparePath = "/Applications/IntelliJ IDEA CE.app/Contents/MacOS/idea";
            String action = "diff";
            String[] execStringArray = new String[]{comparePath, action, leftFile.getPath(), rightFile.getPath()};
            Runtime.getRuntime().exec(execStringArray);
//            Runtime.getRuntime().exec("open -a /Applications/IntelliJ IDEA CE.app diff");
            System.out.println("after compare...");
        } catch (IOException e) {
            System.out.println("compare exception...");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("compare exception...");
            e.printStackTrace();
        }

    }

    @Override
    public String policyName() {
        return getClass().getSimpleName();
    }
}
