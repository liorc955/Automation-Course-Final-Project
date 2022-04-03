package sanity;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlow;

@Listeners(utilities.Listeners.class)
public class ToDoElectron extends CommonOps {


    @AfterMethod
    public void afterMethod(){
        ElectronFlow.filterAllTasks();
        ElectronFlow.emptyList();
    }

    @Test(description = "Test01 - Add And Verify a New Task ")
    @Description("This test adds a new task and verifies it ")
    public void test01_addAndVerifyNewTask(){
        ElectronFlow.addNewTask("Learn Groovy");
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(),1);
    }

    @Test(description = "Test02 - Add And Verify New Tasks")
    @Description("This test adds new tasks and verifies it ")
    public void test02_addAndVerifyNewTasks(){
        ElectronFlow.addNewTask("Learn Java");
        ElectronFlow.addNewTask("Learn Python");
        ElectronFlow.addNewTask("Learn C#");
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(),3);
    }

    @Test(description = "Test03 - Add And Verify Completed Tasks Filter")
    @Description("This test adds new tasks, marks them as completed and verifies it ")
    public void test03_addAndVerifyCompletedTasks(){
        ElectronFlow.addNewTask("Learn Java");
        ElectronFlow.addNewTask("Learn C#");
        ElectronFlow.markTaskAsCompleted("Learn Java");
        ElectronFlow.filterCompletedTasks();
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(),1);
    }

    @Test(description = "Test04 - Add And Verify Todo Tasks Filter")
    @Description("This test adds new tasks, marks some of them as completed and verifies the uncompleted tasks are on the todo filter task list ")
    public void test04_addAndVerifyTodoTasks(){
        ElectronFlow.addNewTask("Learn Java");
        ElectronFlow.addNewTask("Learn Kotlin");
        ElectronFlow.addNewTask("Learn TypeScript");
        ElectronFlow.markTaskAsCompleted("Learn Java");
        ElectronFlow.filterTodoTasks();
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(),2);
    }

    @Test(description = "Test05 - Add And Verify Color Mark Tasks Filter")
    @Description("This test adds new color mark tasks and verifies them on the Color filter task list ")
    public void test05_addAndVerifyColorTasks(){
        ElectronFlow.addNewColorMarkTask("Learn Java","Red");
        ElectronFlow.addNewColorMarkTask("Learn Groovy","Green");
        ElectronFlow.filterTasksByColorMark("Red");
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(),1);
    }


}
