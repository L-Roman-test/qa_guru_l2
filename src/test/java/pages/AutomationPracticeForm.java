package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    private final SelenideElement
            registrationForm = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            mobileNumber = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            yearSelector = $(".react-datepicker__year-select"),
            monthSelector = $(".react-datepicker__month-select"),
            subjects = $("#subjectsContainer input"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit"),
            submitPopupHeader = $("#example-modal-sizes-title-lg");

    private final ElementsCollection
            hobbies = $$("#hobbiesWrapper label"),
            gender = $$("#genterWrapper label"),
            birthDay = $$(".react-datepicker__day"),
            stateList = $$("#state [id^='react-select-3-option']"),
            cityList = $$("#city [id^='react-select-4-option']"),
            filledForm = $$(".table-responsive tbody tr");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        firstName.setValue(firstNameValue);
        lastName.setValue(lastNameValue);
    }

    public void fillEmail(String emailValue) {
        email.setValue(emailValue);
    }

    public void selectGender(String genderValue) {
        gender.findBy(text(genderValue)).click();
    }

    public void fillMobileNumber(String number) {
        mobileNumber.setValue(number);
    }

    public void selectDateOfBirth(String year, String month, String day) {
        dateOfBirth.click();
        yearSelector.click();
        yearSelector.$$("option").findBy(text(year)).click();
        monthSelector.click();
        monthSelector.$$("option").findBy(text(month)).click();
        birthDay.findBy(text(day)).click();
    }

    public void fillSubjects(String subjectValue) {
        subjects.setValue(subjectValue).pressEnter();
    }

    public void selectHobbies(List<String> hobbiesList) {
        hobbiesList.forEach((item) -> hobbies.filterBy(text(item)).first().click());
    }

    public void loadPictures(String name) {
        picture.uploadFile(new File("src/test/resources/" + name));
    }

    public void fillCurrentAddress(String address) {
        currentAddress.setValue(address);
    }

    public void selectState(String stateValue) {
        state.click();
        stateList.findBy(text(stateValue)).click();
    }

    public void selectCity(String cityValue) {
        city.click();
        cityList.findBy(text(cityValue)).click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void checkForm() {
        registrationForm.shouldBe(visible);
    }

    public void formSuccessfullyFilled() {
        submitPopupHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkStudentName(String label, String firstName, String lastName) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(firstName + " " + lastName));
    }

    public void checkEmail(String label, String email) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(email));
    }

    public void checkGender(String label, String male) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(male));
    }

    public void checkNumber(String label, String number) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(number));
    }

    public void checkDateOfBirth(String label, String day, String month, String year) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(day + " " + month + "," + year));
    }


    public void checkSubjects(String label, String subject) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(subject));
    }

    public void checkHobbies(String label, String sport, String music) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(sport + ", " + music));
    }

    public void checkPicture(String label, String pictureName) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(pictureName));
    }


    public void checkAddress(String label, String address) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(address));
    }

    public void checkStateAndCity(String label, String State, String City) {
        filledForm
                .findBy(text(label))
                .$$("td")
                .last()
                .shouldHave(text(State + " " + City));
    }
}
