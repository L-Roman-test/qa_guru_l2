package tests;

import settings.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    Map<String, String> registerForm = new HashMap<>();

    @Test
    void studentRegistrationForm() {
        fillMapForRegisterFormMap();
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

        practiceForm.checkRegisterForm(registerForm);
    }

    private void fillMapForRegisterFormMap() {
        registerForm.put("Student Name", firstName + " " + lastName);
        registerForm.put("Student  Email", email);
        registerForm.put("Gender", genderMale);
        registerForm.put("Mobile", number);
        registerForm.put("Date of Birth", birthDay + " " + birthMonth + "," + birthYear);
        registerForm.put("Subjects", subject);
        registerForm.put("Hobbies", sports + ", " + music);
        registerForm.put("Picture", pictureName);
        registerForm.put("Address", address);
        registerForm.put("State and City", state + " " + city);
    }
}
