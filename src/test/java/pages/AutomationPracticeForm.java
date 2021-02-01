package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
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
            cityList = $$("#city [id^='react-select-4-option']");

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

    public void loadPictures() {
        picture.uploadFile(new File("src/test/resources/dart-veyder-boba-fett-kostyumy.jpg"));
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
}
