package guru.qa.practice_user_form.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    public void verifyResult(String key, String value) {
        $("#output").$(byText(key)).parent().shouldHave(text(value));

    }
}
