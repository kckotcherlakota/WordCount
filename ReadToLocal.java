import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class ReadToLocal{
	public static void main(String[] args) throws IOException 
	{
	Configuration conf = new Configuration();
	String localpath="/home/hadoop/Desktop/timmy";
	// String uri= "hdfs://localhost:8020";
	String Hdfspath="hdfs://localhost:8020/t/timmy";
	FileSystem fs =FileSystem.get(URI.create(Hdfspath),conf);
	fs.copyToLocalFile(new Path(Hdfspath),new Path(localpath));
	}
}

