package com.tutego.date4u4.interfaces.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("date4u4")
public class Date4u4Properties {
  public static class FileSystem{
    /**
     * required minimum free disk space for local file
     */
    private long minimumFreeDiskSpace=1000000;
  
    public long getMinimumFreeDiskSpace() {
      return minimumFreeDiskSpace;
    }
  
    public void setMinimumFreeDiskSpace( long minimumFreeDiskSpace ) {
      this.minimumFreeDiskSpace = minimumFreeDiskSpace;
    }
    
    
  }
  private FileSystem fileSystem=new FileSystem();
  
  public FileSystem getFileSystem() {
    return fileSystem;
  }
  
  public void setFileSystem( FileSystem fileSystem ) {
    this.fileSystem = fileSystem;
  }
  
  
}
