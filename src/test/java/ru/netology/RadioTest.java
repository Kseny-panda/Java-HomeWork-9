package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    // Проверка граничных значений номера радиостанции
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 10"
         })

        public void shouldSetNumber (int expected, int newNumberStation) {
            Radio service = new Radio();
            int actuale = service.getNumberStation();

            Assertions.assertEquals(expected, actuale);
        }

    // Проверка граничных значений громкости
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"
         })
        public void shouldSetVolume (int expected, int newSoundVolume) {
            Radio service = new Radio();
            int actual = service.getSoundVolume();

            Assertions.assertEquals(expected, actual);
        }

    // next - проверка переключения на следующую станцию
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "8, 9",
            "9, 0"
         })

        public void shouldSetNextStation (int numberStation, int expected) {
            Radio service = new Radio();

            service.setNumberStation(numberStation);
            service.nextStation();
            int actual = service.getNumberStation();

            Assertions.assertEquals(expected, actual);
        }

    // prev - проверка переключения на предыдущую станцию
    @ParameterizedTest
    @CsvSource({
            "0, 9",
            "1, 0",
            "2, 1",
            "9, 8",
        })

        public void shouldSetPrevStation (int numberStation, int expected) {
            Radio service = new Radio();

            service.setNumberStation(numberStation);
            service.prevStation();
            int actual = service.getNumberStation();

            Assertions.assertEquals(expected, actual);
        }

    // Проверка переключения кнопок радиостанции
    @ParameterizedTest
    @CsvSource({
            "-1, 0",
            "1, 1",
            "2, 2",
            "8, 8",
            "9, 9",
            "10, 0"
        })

        public void channelSwitching (int newNumberStation, int expected) {
            Radio service = new Radio();

            service.setNumberStation(newNumberStation);
            int actual = service.getNumberStation();

            Assertions.assertEquals(expected, actual);
        }

    // Проверка увеличения громкости звука
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "98, 99",
            "99, 100",
            "100, 100"
        })

        public void increaseVolume (int newSoundVolume, int expected) {
            Radio service = new Radio();

            service.setSoundVolume(newSoundVolume);
            service.increaseVolume();
            int actual = service.getSoundVolume();

            Assertions.assertEquals(expected, actual);
    }

    // Проверка уменьшения громкости звука
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 1",
            "99, 98",
            "100, 99"
        })

        public void decreaseVolume (int newSoundVolume, int expected) {
            Radio service = new Radio();

            service.setSoundVolume(newSoundVolume);
            service.decreaseVolume();
            int actual = service.getSoundVolume();

            Assertions.assertEquals(expected, actual);
        }
}