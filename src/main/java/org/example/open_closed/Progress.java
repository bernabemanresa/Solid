package org.example.open_closed;

public class Progress {

  static Double getSentLengthPercentage(Measurable measurable) {
    return measurable.getSentLength() * 100 / measurable.getTotalLength();
  }

}
