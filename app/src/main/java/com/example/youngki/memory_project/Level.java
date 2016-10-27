package com.example.youngki.memory_project;

public enum Level {
  EASY(2, 26, 2, 4), MEDIUM(5, 26, 5, 7), HARD(8, 26, 8, 10);
  private final int minLetter;
  private final int maxLetter;
  private final int minDigit;
  private final int maxDigit;

  Level(int minLetter, int maxLetter, int minDigit, int maxDigit) {
    this.minLetter = minLetter;
    this.maxLetter = maxLetter;
    this.minDigit = minDigit;
    this.maxDigit = maxDigit;
    this.letters = minLetter;
    this.digits = minDigit;
  }

  private int letters;
  private int digits;

  public int letters() {
    return letters;
  }

  public int digits() {
    return digits;
  }

  public void incrementLetter() {
    if (letters < maxLetter) {
      letters++;
    }
  }

  public void decrementLetter() {
    if (letters > minLetter) {
      letters--;
    }
  }

  public void decrementDigit() {
    if (digits > minDigit) {
      digits--;
    }
  }

  public void incrementDigit() {
    if (digits < maxDigit) {
      digits++;
    }
  }
}
