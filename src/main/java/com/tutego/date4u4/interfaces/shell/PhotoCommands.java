package com.tutego.date4u4.interfaces.shell;

import com.tutego.date4u4.core.Photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ShellComponent
public class PhotoCommands {
  private final PhotoService photoService;
  public PhotoCommands( PhotoService photoService ) {
    this.photoService = photoService;
  }
  
  @ShellMethod( "Show photo" )
  String showPhoto( String name ) {// show-photo
    return photoService.download( name ).map( bytes -> {
      try {
        var image = ImageIO.read( new ByteArrayInputStream( bytes ) );
        return "Width: " + image.getWidth()
                   + ", Height: " + image.getHeight();
      } catch ( IOException e ) { return "Unable to read image dimensions"; }
    } ).orElse( "Image not found" );
  }
  
  @ShellMethod("upload photo")
  String uploadPhoto(String filename) throws IOException {
    byte[]bytes= Files.readAllBytes(Paths.get(filename));
    return "uploaded"+ photoService.upload(bytes);
  }
}
