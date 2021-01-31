package tests;

import Settings.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.page;

public class PracticeFormTest extends BaseTest {
    private static final AutomationPracticeForm practiceForm = page(AutomationPracticeForm.class);

    @Test
    void studentRegistrationForm() {
        practiceForm.openPage();
        practiceForm.checkForm();
        practiceForm.fillName("James", "Bond");
        practiceForm.fillEmail("MI6.agent007@gmail.com");
        practiceForm.selectGender("Male");
        practiceForm.fillMobileNumber("7871234567");
        practiceForm.selectDateOfBirth("1930", "august", "25");
        practiceForm.fillSubjects("agent 007");
        practiceForm.selectHobbies(Arrays.asList("Sports", "Music"));
        practiceForm.loadPictures();
        practiceForm.fillCurrentAddress("London Wellington Square, 25");
        practiceForm.selectState("Uttar Pradesh");
        practiceForm.selectCity("Agra");
        practiceForm.clickOnSubmitButton();
        practiceForm.formSuccessfullyFilled();
    }
}
