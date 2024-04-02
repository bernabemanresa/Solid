package org.example.open_closed;

public class Song implements  Measurable{

  private Double duration;
  private Double sentDuration;

  public Song(Double duration, Double sentDuration) {
    this.duration = duration;
    this.sentDuration = sentDuration;
  }

  @Override
  public Double getTotalLength() {
    return duration;
  }

  @Override
  public Double getSentLength() {
    return sentDuration;
  }
}
