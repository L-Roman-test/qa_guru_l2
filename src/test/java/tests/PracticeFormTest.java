package tests;

import settings.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.page;

public class PracticeFormTest extends BaseTest {
    private static final AutomationPracticeForm practiceForm = page(AutomationPracticeForm.class);

    String firstName = "James";
    String lastName = "Bond";
    String email = "MI6.agent007@gmail.com";
    String genderMale = "Male";
    String number = "7871234567";
    String birthYear = "1930";
    String birthMonth = "august";
    String birthDay = "25";
    String subject = "English";
    String sports = "Sports";
    String music = "Music";
    String pictureName = "dart-veyder-boba-fett-kostyumy.jpg";
    String address = "London Wellington Square, 25";
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    void studentRegistrationForm() {
        practiceForm.openPage();
        practiceForm.checkForm();
        practiceForm.fillName(firstName, lastName);
        practiceForm.fillEmail(email);
        practiceForm.selectGender(genderMale);
        practiceForm.fillMobileNumber(number);
        practiceForm.selectDateOfBirth(birthYear, birthMonth, birthDay);
        practiceForm.fillSubjects(subject);
        practiceForm.selectHobbies(Arrays.asList(sports, music));
        practiceForm.loadPictures(pictureName);
        practiceForm.fillCurrentAddress(address);
        practiceForm.selectState(state);
        practiceForm.selectCity(city);
        practiceForm.clickOnSubmitButton();
        practiceForm.formSuccessfullyFilled();

        practiceForm.checkStudentName("Name", firstName, lastName);
        practiceForm.checkEmail("Email", email);
        practiceForm.checkGender("Gender", genderMale);
        practiceForm.checkNumber("Mobile", number);
        practiceForm.checkDateOfBirth("Date of Birth", birthDay, birthMonth, birthYear);
        practiceForm.checkSubjects("Subjects", subject);
        practiceForm.checkHobbies("Hobbies", sports, music);
        practiceForm.checkPicture("Picture", pictureName);
        practiceForm.checkAddress("Address", address);
        practiceForm.checkStateAndCity("State and City", state, city);
    }
}
