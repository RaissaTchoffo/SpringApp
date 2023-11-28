package com.tutego.date4u4.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.UncheckedIOException;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
  
  @Test
  @DisplayName("free disk space has to be positive")
    //void getFreeDiskSpace() {
  void free_disk_space_has_to_be_positive() {
    //given
    FileSystem fileSystem = new FileSystem();
    //when
    long actual = fileSystem.getFreeDiskSpace();
    //then
    //assertTrue( actual>0,"Free disk space was not>0");
    assertThat(actual).isGreaterThan(0);
  }
  
  //@Test
  //void load() {
  //}
  
  @Test
  void store_and_load_successful() {
    FileSystem fileSystem = new FileSystem();
    fileSystem.store("test.txt", "Hello World".getBytes());
    byte[] actual = fileSystem.load("test.txt");
    assertThat(actual).containsExactly("Hello World".getBytes());
  }
  
  @Test
  void load_unknown_file_thows_exception() {
    FileSystem fileSystem = new FileSystem();
    
    //assertThat(actual).contains("je suis".getBytes());
    assertThatThrownBy(() -> {
      fileSystem.load("je suis");
    }).isInstanceOf(UncheckedIOException.class);
  }
  @Test
  @DisplayName("ecris-selbstaendiG")
  void load_unknown_file() {
    FileSystem fileSystem=new FileSystem();
    fileSystem.store("jeSuis.txt","je suis".getBytes());
    byte[]actual= fileSystem.load("jeSuis.txt");
    assertThat(actual).containsExactly("je suis".getBytes());
    assertThat(actual).contains("je".getBytes());
  }
  
}