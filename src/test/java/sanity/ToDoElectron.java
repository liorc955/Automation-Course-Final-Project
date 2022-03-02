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
}
