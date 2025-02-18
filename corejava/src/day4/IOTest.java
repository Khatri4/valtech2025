package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.Writer;
import java.io.FileWriter;
import org.junit.jupiter.api.Test;

class IOTest {
	
	
	@Test
	public void testBufferReader() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")))){
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testReaders() {
		try (Reader reader = new FileReader(new File("data.txt"))){
			try(Writer writer = new FileWriter(new File("dataOut.txt"))){
				char [] buff = new char[4];
				int i = -1;
				while((i=reader.read(buff))!=-1) {
					writer.write(buff, 0, i);
				}
				writer.flush();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	@Test
	public void testChainingStreams() {
		try (InputStream is = new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			try(OutputStream os = new FileOutputStream("dataCopy.txt")){
				byte [] buff = new byte[4];
//				int bytesRead = is.read(buff);
				int i = 0;
				
				while((i=is.read(buff)) != -1) {
					System.out.println(new String(buff,0,i));
					os.write(buff, 0, i);
			}
				os.flush();
		}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	@Test
	public void testReadTryWithResources() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			assertEquals('H', ((byte)is.read()));
			assertEquals('e', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Test
	public void testSecondReadTryWithResources() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			try(OutputStream os = new FileOutputStream("dataCopy.txt")){
				byte [] buff = new byte[4];
//				int bytesRead = is.read(buff);
				int i = 0;
				
				while((i=is.read(buff)) != -1) {
					System.out.println(new String(buff,0,i));
					os.write(buff, 0, i);
			}
			os.flush();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	@Test
	public void testRead() {
		InputStream is = null;
		try {
			is = new FileInputStream(new File("data.txt"));
//			int h = 'H';
			assertEquals('H', ((byte)is.read()));
			assertEquals('e', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
