package guru.qa.practice_user_form.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObgects {
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submit = $("#submit");

    public PageObgects openPage() {
        open("/text-box");
        return this;
    }
    public PageObgects setFullNameInput(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public PageObgects setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PageObgects setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public PageObgects setPermanentAddressInput(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }
    public PageObgects setSubmit() {
        submit.click();
        return this;
    }
}
