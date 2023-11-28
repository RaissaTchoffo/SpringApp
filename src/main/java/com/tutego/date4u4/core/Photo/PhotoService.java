package com.tutego.date4u4.core.Photo;

import com.tutego.date4u4.core.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Service;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {
  final Thumbnail thumbnail;
  private final Logger log= LoggerFactory.getLogger(getClass());
  private final FileSystem fsy;
  
  public PhotoService( FileSystem fsy, Thumbnail thumbnail ) {
    this.fsy = fsy;
    this.thumbnail = thumbnail;
  }
  @Cacheable("date4u.filesystem.file")
  public Optional<byte[]> download( String name ) {
    try {
      log.info("Load image {}",name);
      return Optional.of(fsy.load(name + ".jpg"));
    } catch ( UncheckedIOException e ) {
      return Optional.empty();
    }
  }
  public String upload( byte[] imageBytes ) {
    //String imageName = UUID.randomUUID().toString();
    String imageName =" blabla";
        // First: store original image
    fsy.store( imageName + ".jpg", imageBytes );
    
    // Second: store thumbnail
    
    byte[] thumbnailBytes = thumbnail.thumbnail(imageBytes );
    fsy.store( imageName + "-thumb.jpg", thumbnailBytes );
    
    return imageName;
    
  }
  
}
