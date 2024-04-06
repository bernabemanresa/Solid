package org.example.open_closed;

public class File implements  Measurable{

  private Double size;
  private Double sentSize;

  public File(Double size, Double sentSize) {
    this.size = size;
    this.sentSize = sentSize;
  }

  @Override
  public Double getSentLengthPercentage() {
    return sentSize * 100 / size;
  }
}
