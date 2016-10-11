import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by zxx on 2016/6/15.
 */
public class BC implements ApplicationComponent {

    public enum SelectState{
        INITIALIZE,
        WAITFORCOMPARE,
    }

    public SelectState getCurrentState() {
        return mCurrentState;
    }

    public void setCurrentState(SelectState currentState) {
        this.mCurrentState = currentState;
    }

    private SelectState mCurrentState = SelectState.INITIALIZE;

    private VirtualFile mLeftFile;

    private VirtualFile mRightFile;

    public VirtualFile getRightFile() {
        return mRightFile;
    }

    public void setRightFile(VirtualFile mRightFile) {
        this.mRightFile = mRightFile;
    }

    public VirtualFile getLeftFile() {
        return mLeftFile;
    }

    public void setLeftFile(VirtualFile mLeftFile) {
        this.mLeftFile = mLeftFile;
    }

    public void doCompare(){
        compare(mLeftFile,mRightFile);
    }

    private void compare(VirtualFile leftFile,VirtualFile rightFile){

        Process p = null;
        try {
            System.out.println("before compare...");
            PropertiesComponent component = PropertiesComponent.getInstance();
            if (StringUtil.isEmpty(component.getValue("bc"))){

                System.out.println("pls set bc path first...");

            }else {
                String comparePath = component.getValue("bc");
                String[] execStringArray = new String[]{comparePath,leftFile.getPath(),rightFile.getPath()};
                Runtime.getRuntime().exec(execStringArray);
                System.out.println("after compare...");
            }
        } catch (IOException e) {
            System.out.println("compare exception...");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("compare exception...");
            e.printStackTrace();
        }

    }

    public BC() {

        System.out.println("BC() ");

    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        System.out.println("initComponent() ");
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
        System.out.println("disposeComponent() ");
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "BC";
    }

    public static BC getApplicationInstance(){
        return ApplicationManager.getApplication().getComponent(BC.class);
    }
}
