package ru.netology;

public class Radio {

    private int minNumberStation;
    private int maxNumberStation;
    private int numberStation;

    private int minSoundVolume;
    private int maxSoundVolume;
    private int soundVolume;

    public Radio() {
        // установка ограничения значений
        this.minNumberStation = 0;
        this.maxNumberStation = 9;
        this.minSoundVolume = 0;
        this.maxSoundVolume = 100;
    }

    // присвоение максимального значение пользователем
    public Radio(int size) {
        this.maxNumberStation = (size - 1);
    }

    public int getMaxNumberStation() {

        return maxNumberStation;
    }

    public int getNumberStation() {

        return numberStation;
    }

    // установка ограничения значений (станция)
    public void setNumberStation(int newNumberStation) {
        if (newNumberStation < minNumberStation) {
            return;
        }
        if (newNumberStation > maxNumberStation) {
            return;
        } else {
            numberStation = newNumberStation;
        }
    }

    // переключение на следующую станцию (next)
    public void next() {

        if (numberStation < maxNumberStation) {
            numberStation++;
        } else {
            numberStation = minNumberStation;
        }
    }

    // переключение на предыдущую станцию (prev)
    public void prev() {

        if (numberStation > minNumberStation) {
            numberStation--;
        } else {
            numberStation = maxNumberStation;
        }
    }

    // установка ограничения громкости
    public void setSoundVolume(int newSoundVolume) {
        if (newSoundVolume < minSoundVolume) {
            return;
        }
        if (newSoundVolume > maxSoundVolume) {
            return;
        } else {
            soundVolume = newSoundVolume;
        }
    }

    public int getSoundVolume() {

        return soundVolume;
    }

    // увеличение громкости
    public void increaseVolume() {
        if (soundVolume < maxSoundVolume) {
            soundVolume++;
        }
    }

    // уменьшение громкости
    public void decreaseVolume() {
        if (soundVolume > minSoundVolume) {
            soundVolume--;
        }
    }
}