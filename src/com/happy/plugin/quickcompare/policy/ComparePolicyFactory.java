package com.happy.plugin.quickcompare.policy;

import java.util.HashMap;

/**
 * Created by zhang on 2017/7/7.
 */
public class ComparePolicyFactory {

    private static ComparePolicyFactory factoryInstance;

    static {
        factoryInstance = new ComparePolicyFactory();
    }

    private HashMap<String,ComparePolicy> mComparePolicyHashMap;

    private ComparePolicyFactory() {
        mComparePolicyHashMap = new HashMap<>();
    }

    public static ComparePolicyFactory getFactoryInstance(){
        return factoryInstance;
    }

    public ComparePolicy makeComparePolicy(ComparePolicy.PolicyType type){

        if (mComparePolicyHashMap.get(type.name()) != null){
            return mComparePolicyHashMap.get(type.name());
        }

        if (type == ComparePolicy.PolicyType.BeyondComparePolicy){

            if (mComparePolicyHashMap.get(type.name()) == null){
                BeyondComparePolicy policy = new BeyondComparePolicy();
                mComparePolicyHashMap.put(type.name(),policy);
            }

        }else if (type == ComparePolicy.PolicyType.InternalComparePolicy){

            if (mComparePolicyHashMap.get(type.name()) == null){
                InternalComparePolicy policy = new InternalComparePolicy();
                mComparePolicyHashMap.put(type.name(),policy);
            }
        }

        return mComparePolicyHashMap.get(type.name());
    }
}
