package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.ApiFlows;


@Listeners(utilities.Listeners.class)
public class BookAPI extends CommonOps {


    @Test(description = "Test01 - Verify Book Title Property")
    @Description("This test verifies book title property")
    public void test01_verifyBookTitle(){
        Verifications.verifyText(ApiFlows.getBookProperty("books[0].title"),"Git Pocket Guide");
        Verifications.verifyNumber(ApiFlows.getStatusCode(),200);
    }

    @Test(description = "Test02 - Add a New Book And Verify", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("This test adds a new book to a user and verifies it")
    public void test02_addNewBook(String bookIsbn){
        ApiFlows.postNewBook(bookIsbn);
        Verifications.verifyNumber(ApiFlows.getStatusCode(),201);
        Verifications.verifyText(ApiActions.extractFromJSON("books[0].isbn"),bookIsbn);
    }

    @Test(description = "Test03 - Update a Book And Verify")
    @Description("This test updates a book in user's books and verifies it")
    public void test03_updateBook(){
        String newBook = "9781449325862";
        String oldBook = "9781491950296";
        ApiFlows.updateBook(oldBook,newBook);
        Verifications.verifyNumber(ApiFlows.getStatusCode(),200);
        Verifications.verifyText(ApiActions.extractFromJSON("books[2].isbn"),newBook);
    }

    @Test(description = "Test04 - Delete All User's Books And Verify")
    @Description("This test deletes all user's books and verifies it")
    public void test04_deleteAllUserBooks(){
        ApiFlows.deleteBooks();
        Verifications.verifyNumber(ApiFlows.getStatusCode(),204);
    }

}
