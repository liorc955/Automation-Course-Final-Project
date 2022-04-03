package workflows;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class ElectronFlow extends CommonOps {

    private static int getColorIndex(String colorMark) {
        if (colorMark.equalsIgnoreCase("red")) return 0;
        else if (colorMark.equalsIgnoreCase("green")) return 3;
        else throw new RuntimeException("Invalid color");
    }

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
        if (count > 0){
            for (int i=0; i<count; i++){
                UIActions.mouseHover(todoMain.btn_delete);
            }
        }
    }

    @Step("Business Flow: Mark a Task As Completed")
    public static void markTaskAsCompleted(String nameOfTask){
        int indexOfTask = UIActions.getIndexOfElementByTitle(nameOfTask,todoMain.txt_list_tasks);
        UIActions.mouseHover(todoMain.btn_mark_completed.get(indexOfTask));
    }

    @Step("Business Flow: Filter Completed Tasks")
    public static void filterCompletedTasks(){
        UIActions.click(todoMain.btn_open_filter_sideMenu);
        UIActions.click(todoFilterSideMenu.btn_status_completed_filter);
        ElectronFlow.closeFilterSideMenu();
    }

    @Step("Business Flow: Filter Todo Tasks")
    public static void filterTodoTasks(){
        UIActions.click( todoMain.btn_open_filter_sideMenu);
        UIActions.click(todoFilterSideMenu.btn_status_todo_filter);
        ElectronFlow.closeFilterSideMenu();
    }

    @Step("Business Flow: Filter All Tasks")
    public static void filterAllTasks(){
        UIActions.click(todoMain.btn_open_filter_sideMenu);
        UIActions.click(todoFilterSideMenu.btn_status_all_filter);
        ElectronFlow.closeFilterSideMenu();
    }

    @Step("Business Flow: Filter {colorMark} Color Mark Tasks")
    public static void filterTasksByColorMark(String colorMark){
        UIActions.click(todoMain.btn_open_filter_sideMenu);
        int colorIndex = getColorIndex(colorMark);
        UIActions.click(todoFilterSideMenu.list_color_filter.get(colorIndex));
        ElectronFlow.closeFilterSideMenu();
    }

    @Step("Business Flow: Close Filter SideMenu")
    public static void closeFilterSideMenu(){
        UIActions.click(todoMain.btn_close_filter_sideMenu);
        wait.until(ExpectedConditions.invisibilityOf(todoFilterSideMenu.btn_status_all_filter)); // wait until side menu is fully closed
    }

    @Step("Business Flow: Create a New Task With a {colorMark} Color Mark")
    public static void addNewColorMarkTask(String taskName, String colorMark){
        UIActions.click(todoMain.btn_color_list); // open
        int indexColor = getColorIndex(colorMark);
        UIActions.click(todoMain.list_color_marks.get(indexColor));
        ElectronFlow.addNewTask(taskName);
        UIActions.click(todoMain.btn_color_list); // close
    }

}
