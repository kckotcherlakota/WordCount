
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class ReadToLocal3 {

 public static void main(String[] args) throws IOException, URISyntaxException 
 {
  //1. Get the instance of Configuration
  Configuration conf = new Configuration();
  //2. URI of the file to be read
 //  URI uri = new URI("hdfs://localhost:8020/srk/sivawc");
  String uri= "hdfs://localhost:8020/t/tiimy";
  //3. Get the instance of the HDFS 
  FileSystem fs = FileSystem.get(URI.create(uri), conf);
  //4. A reference to hold the InputStream
  InputStream in = null;
  try{
   //5. Prepare the Path, i.e similar to File class in Java, Path represents file in HDFS
  Path path = new Path(uri);
   //6. Open a Input Stream to read the data from HDFS
   in = fs.open(path);
   //7. Use the IOUtils to flush the data from the file to console
   IOUtils.copyBytes(in, System.out, 4096, false);
  }finally{
   //8. Close the InputStream once the data is read
   IOUtils.closeStream(in);
  }

 }

}
