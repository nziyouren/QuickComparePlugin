package com.happy.plugin.quickcompare.policy;

import com.happy.plugin.quickcompare.entity.CompareObject;

/**
 * Created by zhang on 2017/7/7.
 */
public interface ComparePolicy {

    enum PolicyType{

        BeyondComparePolicy,
        InternalComparePolicy,;

    }

    void compare(CompareObject leftFile, CompareObject rightFile);

    String policyName();

}
