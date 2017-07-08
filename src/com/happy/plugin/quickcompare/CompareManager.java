package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.policy.ComparePolicy;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Created by zxx on 2016/6/15.
 */
public class CompareManager implements ApplicationComponent, ComparePolicy {

    public enum SelectState{
        INITIALIZE,
        WAITFORCOMPARE,
    }

    public SelectState getCurrentState() {
        return mCurrentState;
    }

    public void setCurrentState(SelectState currentState) {
        this.mCurrentState = currentState;
    }

    private SelectState mCurrentState = SelectState.INITIALIZE;

    public ComparePolicy getComparePolicy() {
        return mComparePolicy;
    }

    public void setComparePolicy(ComparePolicy comparePolicy) {
        this.mComparePolicy = comparePolicy;
    }

    private ComparePolicy mComparePolicy;

    @Override
    public VirtualFile getRightFile() {
        if (mComparePolicy != null){
            return mComparePolicy.getRightFile();
        }
        return null;
    }

    @Override
    public void setRightFile(VirtualFile mRightFile) {
        if (mComparePolicy != null){
            mComparePolicy.setRightFile(mRightFile);
        }
    }

    @Override
    public VirtualFile getLeftFile() {
        if (mComparePolicy != null){
            return mComparePolicy.getLeftFile();
        }
        return null;
    }

    @Override
    public void setLeftFile(VirtualFile mLeftFile) {
        if (mComparePolicy != null){
            mComparePolicy.setLeftFile(mLeftFile);
        }
    }

    @Override
    public void doCompare(){
        if (mComparePolicy != null) {
            mComparePolicy.doCompare();
        }
    }

    public void compare(VirtualFile leftFile,VirtualFile rightFile){

        Process p = null;
        try {
            System.out.println("before compare...");
            PropertiesComponent component = PropertiesComponent.getInstance();
            if (StringUtil.isEmpty(component.getValue(Constants.KEY_EXECUTABLE_PATH))){

                System.out.println("pls set bc path first...");

            }else {
                String comparePath = component.getValue(Constants.KEY_EXECUTABLE_PATH);
                String[] execStringArray = new String[]{comparePath,leftFile.getPath(),rightFile.getPath()};
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
        return null;
    }

    public CompareManager() {

        System.out.println("com.happy.plugin.quickcompare.CompareManager() ");

    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        System.out.println("initComponent() ");
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
        System.out.println("disposeComponent() ");
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "com.happy.plugin.quickcompare.CompareManager";
    }

    public static CompareManager getApplicationInstance(){
        return ApplicationManager.getApplication().getComponent(CompareManager.class);
    }
}
