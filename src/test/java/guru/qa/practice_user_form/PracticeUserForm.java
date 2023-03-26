package guru.qa.practice_user_form;

import guru.qa.practice_user_form.components.PageObgects;
import guru.qa.practice_user_form.components.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PracticeUserForm extends TestBase {
    PageObgects pageObgects = new PageObgects();
    @DisplayName("Проверка фомы text box")
    @Tag("WEB")
    @CsvSource(value = {"Testov Test| test@test.ru| Am Markt 11, 37213 Witzenhausen| Velozavodskaya Ulitsa, 7",
                        "Ivanov Ivan| ivan@ivanov.ru| yl. Pushkina, dom Kolotushkina| yl. Tut, dom 777"},
               delimiter = '|')
    @ParameterizedTest(name = "Проверка формы c данными {0} и {1}")
    void practiceUserForm(String fullName, String userEmail, String currentAddress, String permanentAddress) {
        pageObgects.openPage()
                .setFullNameInput(fullName)
                .setUserEmailInput(userEmail)
                .setCurrentAddressInput(currentAddress)
                .setPermanentAddressInput(permanentAddress)
                .setSubmit();
    }
}
