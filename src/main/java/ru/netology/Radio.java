package ru.netology;

public class Radio {

    private int numberStation;
    private int soundVolume;

    public int getNumberStation() {
        return numberStation;
    }

    public void setNumberStation(int newNumberStation) {
        // установка ограничения значений
        if (newNumberStation < 0) {
            return;
        }
        if (newNumberStation > 9) {
            return;
        }
        numberStation = newNumberStation;

    }

    // переключение на следующую станцию
    public void nextStation() {
        if (numberStation < 9) {
            numberStation++;
        } else {
            numberStation = 0;
        }
    }
    // переключение на предыдущую станцию
    public void prevStation() {
        if (numberStation > 0) {
            numberStation--;
        } else  {
            numberStation = 9;
        }
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(int newSoundVolume) {
        // установка ограничения громкости
        if (newSoundVolume < 0) {
            return;
        }
        if (newSoundVolume > 100) {
            return;
        }
        soundVolume = newSoundVolume;
    }

    // увеличение громкости
    public void increaseVolume() {
        if (soundVolume < 100) {
            soundVolume++;
        }
    }

    // уменьшение громкости
    public void decreaseVolume() {
        if (soundVolume > 0) {
            soundVolume--;
        }
    }
}