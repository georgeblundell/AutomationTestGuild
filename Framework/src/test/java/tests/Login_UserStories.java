package tests;

import jakarta.mail.*;
import reports.TestNGListener;
import ie.curiositysoftware.testmodeller.TestModellerPath;
import ie.curiositysoftware.testmodeller.TestModellerSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ie.curiositysoftware.allocation.dto.ResultMergeMethod;
import ie.curiositysoftware.allocation.dto.DataAllocationRow;
import reports.ExtentTestListener;
import ie.curiositysoftware.allocation.dto.DataAllocationResult;
import ie.curiositysoftware.allocation.engine.DataAllocation;
import utilities.testmodeller.TestModellerLogger;
import io.restassured.RestAssured;

//https://internalcsitraining.cloud.testinsights.io/app/#!/model-engine/guid/c87a072e-c9a1-422c-823c-d9a9eaf91859
@Listeners({TestNGListener.class, ExtentTestListener.class})
@TestModellerSuite(id = 1268, profileId = 101661)
public class Login_UserStories extends TestBase
{
    

    
    @Test  (groups= {"Login","Login - User Stories"})
    @TestModellerPath(guid = "2dc06470-6c73-4775-9ab7-8510bcca01d4")
    public void ClickSignInScreenPositiveEnterEmailPositiveEnterPasswordClickSignInSucces()
    {
        
           pages.Magento_Login_or_Sign_up _Magento_Login_or_Sign_up = new pages.Magento_Login_or_Sign_up(getDriver());
    TestModellerLogger.SetLastNodeGuid("ba2d2ab6-6d98-4deb-8371-4e989a04b443");
    _Magento_Login_or_Sign_up.Click_Sign_In_Screen();

    TestModellerLogger.SetLastNodeGuid("091d4f78-f381-44e3-889a-6b7d875019b5");
    _Magento_Login_or_Sign_up.Enter_Email("roni_cost@example.com");

    TestModellerLogger.SetLastNodeGuid("e9e5ed57-756e-4b7b-ae4c-6a9852b278a4");
    _Magento_Login_or_Sign_up.Enter_Password("roni_cost3@example.com");

    TestModellerLogger.SetLastNodeGuid("42dc6863-1d99-4408-9b6e-190f2fdb708a");
    _Magento_Login_or_Sign_up.Click_Sign_In();

    }


    @Test  (groups= {"Login","Login - User Stories"})
    @TestModellerPath(guid = "07c18781-0a3e-4ebf-9fd4-0c6a893ad967")
    public void ClickSignInScreenPositiveEnterEmailNegativeEnterPasswordClickSignInError()
    {
        
           pages.Magento_Login_or_Sign_up _Magento_Login_or_Sign_up = new pages.Magento_Login_or_Sign_up(getDriver());
    TestModellerLogger.SetLastNodeGuid("ba2d2ab6-6d98-4deb-8371-4e989a04b443");
    _Magento_Login_or_Sign_up.Click_Sign_In_Screen();

    TestModellerLogger.SetLastNodeGuid("091d4f78-f381-44e3-889a-6b7d875019b5");
    _Magento_Login_or_Sign_up.Enter_Email("roni_cost@example.com");

    TestModellerLogger.SetLastNodeGuid("8cf18829-6fdf-4807-8262-3462ccdc9ca7");
    _Magento_Login_or_Sign_up.Enter_Password("#!_ @");

    TestModellerLogger.SetLastNodeGuid("42dc6863-1d99-4408-9b6e-190f2fdb708a");
    _Magento_Login_or_Sign_up.Click_Sign_In();

    }


    @Test  (groups= {"Login","Login - User Stories"})
    @TestModellerPath(guid = "2e9f699c-6367-4237-9759-a1c8fc7c9dc0")
    public void ClickSignInScreenNegativeEnterEmailPositiveEnterPasswordClickSignInError()
    {
        
           pages.Magento_Login_or_Sign_up _Magento_Login_or_Sign_up = new pages.Magento_Login_or_Sign_up(getDriver());
    TestModellerLogger.SetLastNodeGuid("ba2d2ab6-6d98-4deb-8371-4e989a04b443");
    _Magento_Login_or_Sign_up.Click_Sign_In_Screen();

    TestModellerLogger.SetLastNodeGuid("966f7279-7eeb-4a28-a199-88aecf6249e6");
    _Magento_Login_or_Sign_up.Enter_Email("Data");

    TestModellerLogger.SetLastNodeGuid("e9e5ed57-756e-4b7b-ae4c-6a9852b278a4");
    _Magento_Login_or_Sign_up.Enter_Password("roni_cost3@example.com");

    TestModellerLogger.SetLastNodeGuid("42dc6863-1d99-4408-9b6e-190f2fdb708a");
    _Magento_Login_or_Sign_up.Click_Sign_In();

    }


}