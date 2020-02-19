package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSExam02 {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		//HDFS를 접근하기 위해서 제공되는 객체 생성 - HDFS
		FileSystem hdfs = null;
		//HDFS로부터 input하기 위해 스트림 객체 생성
		FSDataInputStream hdfsinput = null;
		
		try {
			hdfs = FileSystem.get(conf);
			
			Path path = new Path(args[0]);
			//HDFS에 저장된 파일을 읽어야 하므로 스트림 생성하기 
			hdfsinput = hdfs.open(path);
			//입력 스트림을 통해 데이터를 읽는다.
			String result = hdfsinput.readUTF();
			System.out.println(" HDFS에서 읽은 데이터 : " +result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
