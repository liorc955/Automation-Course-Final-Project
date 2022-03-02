package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlow extends CommonOps {

    @Step("Business Flow: Create a New Task")
    public static void addNewTask(String taskName){
        UIActions.updateText(todoMain.txt_create,taskName);
        UIActions.insertKey(todoMain.txt_create, Keys.RETURN);
    }

    @Step("Business Flow: Count And Return Number Of Tasks List")
    public static int getNumberOfTasks(){
        return todoMain.list_tasks.size();
    }

    @Step("Business Flow: Delete All Tasks")
    public static void emptyList(){
        int count = getNumberOfTasks();
        for (int i=0; i<count; i++){
            UIActions.mouseHover(todoMain.btn_delete);
        }
    }


}
