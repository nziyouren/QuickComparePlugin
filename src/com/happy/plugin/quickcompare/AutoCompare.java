package com.happy.plugin.quickcompare;

import com.happy.plugin.quickcompare.entity.CompareObject;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by zxx on 2016/6/15.
 */
public class AutoCompare extends AnAction {

    private CompareObject mAutoCompareFile = null;

    public AutoCompare() {
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public AutoCompare(Icon icon) {
        super(icon);
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public AutoCompare(@Nullable String text) {
        super(text);
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public AutoCompare(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
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
        CompareManager instance = getCompareManager();
        if (instance == null){
            return;
        }
        if (mAutoCompareFile == null){
            return;
        }
        instance.setRightFile(mAutoCompareFile);
        instance.doCompare();
        instance.setCurrentState(CompareManager.SelectState.INITIALIZE);
        clearAutoCompare();
    }

    private void clearAutoCompare(){
        mAutoCompareFile = null;
    }

    private void updateSelf(AnActionEvent e){

        CompareManager instance = getCompareManager();
        if (instance == null){
            return;
        }

        CompareManager.SelectState state = instance.getCurrentState();

        System.out.println("current state: "+state.name());

        if (state == CompareManager.SelectState.INITIALIZE){

            System.out.println("Compare to setVisible false: "+state.name());
            Presentation presentation = e.getPresentation();
            presentation.setEnabledAndVisible(false);


        }else if (state == CompareManager.SelectState.WAITFORCOMPARE){

            System.out.println("Compare to setVisible true: "+state.name());

            Presentation presentation = e.getPresentation();

            VirtualFile leftFile = instance.getLeftFile().compareFile;
            String compareTo = leftFile.getName();

            Project project = e.getData(PlatformDataKeys.PROJECT);

            System.out.println("wait for compare project name: "+project.getName()+" path: "+project.getBasePath());

            PsiFileSystemItem[] items = FilenameIndex.getFilesByName(project,compareTo, GlobalSearchScope.projectScope(project));

            for (PsiFileSystemItem item:items){
                System.out.println("found path: "+item.getVirtualFile().getPath());
            }

            if (items != null && items.length>0){
                if (!leftFile.getPath().equals(items[0].getVirtualFile().getPath()) && (!instance.getLeftFile().belongProject.getBasePath().equals(project.getBasePath()))) {
                    //maybe it's another project file, so we do it!
                    System.out.println("maybe it's another project file, so we do it!");
                    presentation.setEnabledAndVisible(true);
                    mAutoCompareFile = new CompareObject(items[0].getVirtualFile(),project);
                } else {
                    //alreay the same file, we don't enable it
                    System.out.println("alreay the same file, we don't enable it");
                    presentation.setEnabledAndVisible(false);
                }
            }else {
                presentation.setEnabledAndVisible(false);
            }

        }

    }

    private CompareManager getCompareManager(){
        return CompareManager.getApplicationInstance();
    }
}
