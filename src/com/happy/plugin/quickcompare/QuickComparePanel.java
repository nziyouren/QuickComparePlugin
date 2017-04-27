package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.ui.CompareForm;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by zxx on 2016/6/16.
 */
public class QuickComparePanel implements Configurable {

    private CompareForm mCompareForm;

    @Nls
    @Override
    public String getDisplayName() {
        return "QuickCompare";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "Setting for compare tool executable path";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mCompareForm= new CompareForm();
        return mCompareForm.mContentPanel;
    }

    @Override
    public boolean isModified() {
        System.out.println("isModified()");
        return mCompareForm.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        System.out.println("click apply()");
        mCompareForm.apply();
    }

    @Override
    public void reset() {
        System.out.println("click reset()");
        mCompareForm.reset();
    }

    @Override
    public void disposeUIResources() {
        System.out.println("disposeUIResources()");
    }
}
