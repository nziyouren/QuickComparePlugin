package com.happy.plugin.quickcompare.policy;

import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zhang on 2017/7/7.
 */
public abstract class AbstractComparePolicy implements ComparePolicy{

    private VirtualFile mLeftFile;

    private VirtualFile mRightFile;

    @Override
    public VirtualFile getRightFile() {
        return mRightFile;
    }

    @Override
    public void setRightFile(VirtualFile mRightFile) {
        this.mRightFile = mRightFile;
    }

    @Override
    public VirtualFile getLeftFile() {
        return mLeftFile;
    }

    @Override
    public void setLeftFile(VirtualFile mLeftFile) {
        this.mLeftFile = mLeftFile;
    }

    @Override
    public void doCompare(){
        compare(mLeftFile,mRightFile);
    }


}
