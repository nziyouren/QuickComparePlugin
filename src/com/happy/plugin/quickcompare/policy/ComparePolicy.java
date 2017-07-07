package com.happy.plugin.quickcompare.policy;

import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zhang on 2017/7/7.
 */
public interface ComparePolicy {

    enum PolicyType{
        BeyondComparePolicy,
        InternalComparePolicy,
    }

    VirtualFile getRightFile();

    void setRightFile(VirtualFile mRightFile);

    VirtualFile getLeftFile();

    void setLeftFile(VirtualFile mLeftFile);

    void doCompare();

    void compare(VirtualFile leftFile,VirtualFile rightFile);

    String policyName();

}
