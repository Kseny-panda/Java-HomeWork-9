package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    Radio service = new Radio();

    // проверка граничных значений номера радиостанции
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 10"
    })

    public void shouldSetNumber (int expected, int newNumberStation) {

        service.setNumberStation(newNumberStation);
        Assertions.assertEquals(expected, service.getNumberStation());
    }

    // проверка граничных значений громкости
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "0, 101"
    })
    public void shouldSetVolume (int expected, int newSoundVolume) {

        service.setSoundVolume(newSoundVolume);
        Assertions.assertEquals(expected, service.getSoundVolume());
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

        service.setNumberStation(numberStation);
        service.next();
        Assertions.assertEquals(expected, service.getNumberStation());
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

        service.setNumberStation(numberStation);
        service.prev();

        Assertions.assertEquals(expected, service.getNumberStation());
    }

    // проверка переключения кнопок радиостанции
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

        service.setNumberStation(newNumberStation);
        Assertions.assertEquals(expected, service.getNumberStation());
    }

    // проверка увеличения громкости звука
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 2",
            "98, 99",
            "99, 100",
            "100, 100"
    })

    public void increaseVolume (int newSoundVolume, int expected) {

        service.setSoundVolume(newSoundVolume);
        service.increaseVolume();
        Assertions.assertEquals(expected, service.getSoundVolume());
    }

    // проверка уменьшения громкости звука
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 1",
            "99, 98",
            "100, 99"
    })

    public void decreaseVolume (int newSoundVolume, int expected) {

        service.setSoundVolume(newSoundVolume);
        service.decreaseVolume();
        Assertions.assertEquals(expected, service.getSoundVolume());
    }

    // проверка изменения количества каналов
    @ParameterizedTest
    @CsvSource({
            "6, 7",
            "16, 17"
    })

    public void selectingNumberOfStation (int expected, int size) {
        Radio service = new Radio(size);

        Assertions.assertEquals(expected, service.getMaxNumberStation());
    }
}