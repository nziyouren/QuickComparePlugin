package com.happy.plugin.quickcompare.policy;

import com.happy.plugin.quickcompare.entity.CompareObject;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zhang on 2017/7/7.
 */
public abstract class AbstractComparePolicy implements ComparePolicy{

    @Override
    public void compare(CompareObject leftCompare, CompareObject rightCompare) {
        System.out.println("Execute compare left file: "+leftCompare+" with right file: "+rightCompare);
    }
}
