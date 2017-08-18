package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.entity.CompareObject;
import com.happy.plugin.quickcompare.policy.ComparePolicy;
import com.happy.plugin.quickcompare.policy.ComparePolicyFactory;
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
public class CompareManager implements ApplicationComponent {

    public enum SelectState{
        INITIALIZE,
        WAITFORCOMPARE,
    }

    private ComparePolicy mComparePolicy;

    private CompareObject mLeftFile;

    private CompareObject mRightFile;

    private SelectState mCurrentState = SelectState.INITIALIZE;

    public CompareObject getRightFile() {
        return mRightFile;
    }

    public void setRightFile(CompareObject mRightFile) {
        this.mRightFile = mRightFile;
    }

    public CompareObject getLeftFile() {
        return mLeftFile;
    }

    public void setLeftFile(CompareObject mLeftFile) {
        this.mLeftFile = mLeftFile;
    }

    public void doCompare(){
        //check user select some compare tool and check user select executable path
        PropertiesComponent component = PropertiesComponent.getInstance();
        if (component.getInt(Constants.KEY_CHOOSE_TOOL,-1) == -1){
            System.out.println("pls choose compare tool first...");
            return;
        }
        if (StringUtil.isEmpty(component.getValue(Constants.KEY_EXECUTABLE_PATH))){
            System.out.println("pls set bc path first...");
            return;
        }

        if (mComparePolicy == null){
            mComparePolicy = ComparePolicyFactory.getFactoryInstance().makeComparePolicy(ComparePolicy.PolicyType.values()[component.getInt(Constants.KEY_CHOOSE_TOOL,-1)]);
        }

        mComparePolicy.compare(mLeftFile,mRightFile);

    }

    public SelectState getCurrentState() {
        return mCurrentState;
    }

    public void setCurrentState(SelectState currentState) {
        this.mCurrentState = currentState;
    }

    public ComparePolicy getComparePolicy() {
        return mComparePolicy;
    }

    public void setComparePolicy(ComparePolicy comparePolicy) {
        this.mComparePolicy = comparePolicy;
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
