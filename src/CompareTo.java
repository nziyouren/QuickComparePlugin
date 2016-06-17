import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by zxx on 2016/6/15.
 */
public class CompareTo extends AnAction {

    private BC mInstance = (BC) ApplicationManager.getApplication().getComponent("BC");

    public CompareTo() {
        System.out.println("CompareTo()");
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(Icon icon) {
        super(icon);
        System.out.println("CompareTo()");
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(@Nullable String text) {
        super(text);
        System.out.println("CompareTo()");
        Presentation presentation = getTemplatePresentation();
        presentation.setVisible(false);
    }

    public CompareTo(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
        System.out.println("CompareTo()");
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
        mInstance.setRightFile(vFile);
        mInstance.doCompare();
        mInstance.setCurrentState(BC.SelectState.INITIALIZE);
    }

    private void updateSelf(AnActionEvent e){

        BC.SelectState state = mInstance.getCurrentState();

        System.out.println("current state: "+state.name());

        if (state == BC.SelectState.INITIALIZE){

            System.out.println("Compare to setVisible false: "+state.name());
            Presentation presentation = e.getPresentation();
            presentation.setEnabledAndVisible(false);


        }else if (state == BC.SelectState.WAITFORCOMPARE){

            System.out.println("Compare to setVisible true: "+state.name());

            Presentation presentation = e.getPresentation();
            presentation.setEnabledAndVisible(true);

            VirtualFile leftFile = mInstance.getLeftFile();
            String compareTo = leftFile.getName();

            presentation.setText("Compare to \""+compareTo+"\"");

        }

    }
}
