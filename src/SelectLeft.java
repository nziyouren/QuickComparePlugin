import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by zxx on 2016/6/15.
 */
public class SelectLeft extends AnAction {

    private BC mInstance = (BC) ApplicationManager.getApplication().getComponent("BC");

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {

        // TODO: insert action logic here
        VirtualFile vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        mInstance.setLeftFile(vFile);
        mInstance.setCurrentState(BC.SelectState.WAITFORCOMPARE);

    }
}
