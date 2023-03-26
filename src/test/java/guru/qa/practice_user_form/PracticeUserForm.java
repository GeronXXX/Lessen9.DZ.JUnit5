package guru.qa.practice_user_form;

import guru.qa.practice_user_form.components.PageObgects;
import guru.qa.practice_user_form.components.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class PracticeUserForm extends TestBase {
    PageObgects pageObgects = new PageObgects();

    @DisplayName("Проверка фомы text box")
    @Tag("WEB")
    @CsvSource(value = {"Testov Test| test@test.ru| Am Markt 11, 37213 Witzenhausen| Velozavodskaya Ulitsa, 7",
            "Ivanov Ivan| ivan@ivanov.ru| yl. Pushkina, dom Kolotushkina| yl. Tut, dom 777"},
            delimiter = '|')
    @ParameterizedTest(name = "Проверка формы c данными {0} и {1} с использованием аннотации @CsvSource")
    void practiceUserFormCsvSource(String fullName, String userEmail, String currentAddress, String permanentAddress) {
        pageObgects.openPage()
                .setFullNameInput(" " + fullName)
                .setUserEmailInput(userEmail)
                .setCurrentAddressInput(" " + currentAddress)
                .setPermanentAddressInput(" " + permanentAddress)
                .setSubmit();

        pageObgects.verifyResult("Name:", fullName)
                .verifyResult("Email:", userEmail)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }

    @ParameterizedTest(name = "Проверка формы c данными {0} и {1} с использованием аннотации @ValueSource")
    @ValueSource(strings = {"Testov Test", "Ivanov Ivan"})
    void practiceUserFormValueSource(String fullName) {
        pageObgects.openPage()
                .setFullNameInput(" " + fullName)
                .setSubmit();

        pageObgects.verifyResult("Name:", fullName);
    }

    public static Stream<Arguments> practiceUserFormMethodSource() {
        return Stream.of(
                Arguments.of("Testov Test", "test@test.ru", "Am Markt 11, 37213 Witzenhausen",
                        "Velozavodskaya Ulitsa, 7"),
                Arguments.of("Ivanov Ivan", "ivan@ivanov.ru", "yl. Pushkina, dom Kolotushkina",
                        "yl. Tut, dom 777")
        );
    }
    @MethodSource
    @ParameterizedTest(name = "Проверка формы c данными {0} и {1} с использованием аннотации @MethodSource")
    void practiceUserFormMethodSource(String fullName, String userEmail, String currentAddress,
                                      String permanentAddress) {
        pageObgects.openPage()
                .setFullNameInput(" " + fullName)
                .setUserEmailInput(userEmail)
                .setCurrentAddressInput(" " + currentAddress)
                .setPermanentAddressInput(" " + permanentAddress)
                .setSubmit();

        pageObgects.verifyResult("Name:", fullName)
                .verifyResult("Email:", userEmail)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }

}


