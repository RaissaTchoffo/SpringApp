package com.tutego.date4u4.core.photo;

import com.tutego.date4u4.core.FileSystem;
import com.tutego.date4u4.core.Photo.AwtBicubicThumbnail;
import com.tutego.date4u4.core.Photo.PhotoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;


//@ExtendWith(MockitoExtension.class)
 @SpringBootTest("spring.shell.interactive.enabled=false")
 
class PhotoServiceTest {
  private static final byte[] MINIMAL_JPG = Base64.getDecoder().decode(
     "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAP////////////////////////////////////"
    +"//////////////////////////////////////////////////wgALCAABAAEBAREA/8QA"
    +"FBABAAAAAAAAAAAAAAAAAAAAAP/aAAgBAQABPxA=" );    // https://git.io/J9GXr

  //private static class DummyFileSystem extends FileSystem {
  //  @Override public long getFreeDiskSpace() { return 1; }
  //  @Override public byte[] load( String filename ) { return MINIMAL_JPG; }
  //  @Override public void store( String filename, byte[] bytes ) { }
  //}
  @MockBean FileSystem fs;
  @Spy AwtBicubicThumbnail thumbnail;
  @Autowired
  PhotoService photoService;
  //
  @Test
  void successful_photo_upload() {
    String imageName = photoService.upload( MINIMAL_JPG );

    assertThat(imageName ).isNotEmpty();
  }
}