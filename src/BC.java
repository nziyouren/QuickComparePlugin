import com.intellij.ide.util.PropertiesComponent;
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
          //  String execString = MessageFormat.format("D:\\Beyond Compare 4\\BCompare.exe {0} {1}",leftFile.getPath(),rightFile.getPath());
            PropertiesComponent component = PropertiesComponent.getInstance();
            if (StringUtil.isEmpty(component.getValue("bc"))){

                System.out.println("pls set bc path first...");

            }else {
                String comparePath = component.getValue("bc");
                String execString = MessageFormat.format("{0} {1} {2}",comparePath,leftFile.getPath(),rightFile.getPath());
//            p = Runtime.getRuntime().exec("D:\\Beyond Compare 4\\BCompare.exe F:\\bctest\\a.txt F:\\bctest\\b.txt");
                p = Runtime.getRuntime().exec(execString);
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
}
