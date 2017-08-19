package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.entity.CompareObject;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
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
        Project project = e.getData(PlatformDataKeys.PROJECT);
        CompareManager instance = getBCInstance();
        if (instance == null){
            return;
        }
        instance.setLeftCompare(new CompareObject(vFile,project));
        instance.setCurrentState(CompareManager.SelectState.WAITFORCOMPARE);


        System.out.println("select left project name: "+project.getName()+" path: "+project.getBasePath());
    }

    private CompareManager getBCInstance(){
        return CompareManager.getApplicationInstance();
    }
}
