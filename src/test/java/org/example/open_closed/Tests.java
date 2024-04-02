package org.example.open_closed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tests {
  @Test
  void testSongConsumptionPercentage() {
    Measurable song = new Song(180.0, 30.0);
    Assertions.assertEquals(16.66, Progress.getSentLengthPercentage(song), 0.1);
  }

  @Test
  void testFileReadPercentage() {
    Measurable file = new File(1024.0, 24.0);
    Assertions.assertEquals(2.3, Progress.getSentLengthPercentage(file), 0.1);
  }
}
