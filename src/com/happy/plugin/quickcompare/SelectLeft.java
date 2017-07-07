package com.happy.plugin.quickcompare;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zxx on 2016/6/15.
 */
public class SelectLeft extends AnAction {

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {

        // TODO: insert action logic here
        VirtualFile vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        CompareManager instance = getBCInstance();
        if (instance == null){
            return;
        }
        instance.setLeftFile(vFile);
        instance.setCurrentState(CompareManager.SelectState.WAITFORCOMPARE);

    }

    private CompareManager getBCInstance(){
        return CompareManager.getApplicationInstance();
    }
}
