package com.tutego.date4u4.interfaces.shell;

import com.tutego.date4u4.core.FileSystem;
import com.tutego.date4u4.interfaces.configuration.Date4u4Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import java.nio.file.Path;

@ShellComponent
public class FsCommands {
  
 
  
  
  private final FileSystem fs;
  private final Environment environment;
  private  Date4u4Properties date4u4Properties;
 
  
  //@Value("${date4u4.filesystem.minimum-free-disk-space:1000000}")
// private long minimumFreeDiskSpace;
  
 
  
 
  
  public FsCommands( FileSystem fs, Environment environment, Date4u4Properties date4u4Properties ) {
    this.fs = fs;
  
    this.environment = environment;
    this.date4u4Properties = date4u4Properties;
  }
  
  
  //@Autowired
  //public FsCommands( FileSystem fs,  Environment environment )
  //{this.fs = fs;
  //  this.environment = environment;
  //}
  
  @ShellMethod("Display required disk space")
  public long minimumFreeDiskSpace(){
    //return 1000000;
    
    //return minimumFreeDiskSpace;
    return date4u4Properties.getFileSystem().getMinimumFreeDiskSpace();
  }
  //@ShellMethod("Lowercase")
  //public String toLowerCase(String input){
  //  return input.toLowerCase(Locale.ROOT);
  //}
  
  @ShellMethod("Display free sick space")
  public String freeDiskSpace(){
  return DataSize.ofBytes(fs.getFreeDiskSpace()).toGigabytes() + " GB";
 }
 @ShellMethod("Display user home")
  public String userHome(){
    return environment.getProperty("user.home");
 }
  
  @ShellMethod( "Display if path exists")
  public boolean exists( Path path ){
    System.out.println(path);
    return true;
  }
}
@Component
 class StringToPathConverter implements Converter<String,Path>{

  @Override
  public Path convert( String source ) {
    return Path.of(source);
  }
  
}

