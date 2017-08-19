package com.happy.plugin.quickcompare.policy;

import com.happy.plugin.quickcompare.Constants;
import com.happy.plugin.quickcompare.entity.CompareObject;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.util.text.StringUtil;

import java.io.IOException;

/**
 * Created by zhang on 2017/7/7.
 */
public class BeyondComparePolicy extends AbstractComparePolicy {

    @Override
    public void compare(CompareObject leftCompare, CompareObject rightCompare) {
        Process p = null;
        try {
            System.out.println("before compare...");
            PropertiesComponent component = PropertiesComponent.getInstance();
            if (StringUtil.isEmpty(component.getValue(Constants.KEY_EXECUTABLE_PATH))){

                System.out.println("pls set bc path first...");

            }else {
                String comparePath = component.getValue(Constants.KEY_EXECUTABLE_PATH);
                String[] execStringArray = new String[]{comparePath, leftCompare.compareFile.getPath(), rightCompare.compareFile.getPath()};
                Runtime.getRuntime().exec(execStringArray);
                System.out.println("after compare...");
            }
        } catch (IOException e) {
            System.out.println("compare exception...");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("compare exception...");
            e.printStackTrace();
        }
    }

    @Override
    public String policyName() {
        return getClass().getSimpleName();
    }
}
