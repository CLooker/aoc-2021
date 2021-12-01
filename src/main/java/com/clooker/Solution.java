package com.clooker;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

public abstract class Solution implements Supplier<Number> {

  protected final String inputFile;

  protected Solution(String inputFile) {
    this.inputFile = inputFile;
  }

  protected Stream<String> readInputFile() {
    try {
      URL resourceUrl = getClass().getClassLoader().getResource(inputFile);
      assert resourceUrl != null;
      return Files.lines(Path.of(resourceUrl.getPath()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
