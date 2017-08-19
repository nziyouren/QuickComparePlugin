package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.entity.CompareObject;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by zxx on 2016/6/15.
 */
public class CompareTo extends AnAction {

    public CompareTo() {
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(Icon icon) {
        super(icon);
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(@Nullable String text) {
        super(text);
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    @Override
    public void beforeActionPerformedUpdate(@NotNull AnActionEvent e) {
        super.beforeActionPerformedUpdate(e);
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        updateSelf(e);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        VirtualFile vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        Project project = e.getData(PlatformDataKeys.PROJECT);
        CompareManager instance = getCompareManager();
        if (instance == null){
            return;
        }
        instance.setRightCompare(new CompareObject(vFile,project));
        instance.doCompare();
        instance.setCurrentState(CompareManager.SelectState.INITIALIZE);
    }

    private void updateSelf(AnActionEvent e){

        CompareManager instance = getCompareManager();
        if (instance == null){
            return;
        }

        CompareManager.SelectState state = instance.getCurrentState();

        System.out.println("current state: "+state.name());

        if (state == CompareManager.SelectState.INITIALIZE){

            Presentation presentation = e.getPresentation();
            presentation.setEnabledAndVisible(false);


        }else if (state == CompareManager.SelectState.WAITFORCOMPARE){

            VirtualFile leftFile = instance.getLeftCompare().compareFile;
            VirtualFile currentFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);

            if (currentFile.getPath().equals(leftFile.getPath())){

                System.out.println("the same file, don't show compare to menu");
                Presentation presentation = e.getPresentation();
                presentation.setEnabledAndVisible(false);

            }else {

                Presentation presentation = e.getPresentation();
                presentation.setEnabledAndVisible(true);
                presentation.setText("Compare to \""+leftFile.getName()+"\"");

            }






        }

    }

    private CompareManager getCompareManager(){
        return CompareManager.getApplicationInstance();
    }
}
