package stdlib.nio.io.file;

import helper.UnitTestRunner;
import java.io.IOException;
import java.io.RandomAccessFile;
import static helper.MyAssert.*;

/**
 * Created with IntelliJ IDEA.
 * User: beyond
 * Email: beyondblog@outlook.com
 * Date: 15/3/19
 * Time: 上午7:01
 * Description:
 * java/stdlib.nio.io/RandomAccessFile#open(Ljava/lang/String;I)V
 * java/stdlib.nio.io/RandomAccessFile#read0()I
 * java/stdlib.nio.io/RandomAccessFile#readBytes([BII)I
 * java/stdlib.nio.io/RandomAccessFile#write0(I)V
 * java/stdlib.nio.io/RandomAccessFile#writeBytes([BII)V
 * java/stdlib.nio.io/RandomAccessFile#getFilePointer()J
 * java/stdlib.nio.io/RandomAccessFile#seek0(J)V
 * java/stdlib.nio.io/RandomAccessFile#length()J
 * java/stdlib.nio.io/RandomAccessFile#setLength(J)V
 * java/stdlib.nio.io/RandomAccessFile.initIDs()V
 * java/stdlib.nio.io/RandomAccessFile#close0()V
 */
public class RandomAccessFileTest {

    public static void main(String[] args) throws Exception {
        UnitTestRunner.run(RandomAccessFileTest.class);
    }

//    @Test
    public void writeTest() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFileWriteTest", "rw")) {
            //write data
            randomAccessFile.writeBytes("hello");
            randomAccessFile.writeInt(54);
            randomAccessFile.writeBytes("world");
            randomAccessFile.writeInt(-57);
        }
    }

//    @Test
    public void readTest() throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFileWriteTest", "rw")) {
            byte data[] = new byte[5];
            randomAccessFile.read(data);
            String result = new String(data);
            assertTrue(result.equals("hello"));
            int intValue = randomAccessFile.readInt();
            assertTrue(intValue == 54);
            randomAccessFile.read(data);
            result = new String(data);
            assertTrue(result.equals("world"));
            intValue = randomAccessFile.readInt();
            assertTrue(intValue == -57);
        }
    }

//    @Test
    public void seekTest() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFileWriteTest", "rw");
        //write data
        randomAccessFile.writeBytes("hello");
        randomAccessFile.writeInt(54);
        randomAccessFile.writeBytes("world");
        randomAccessFile.writeInt(-57);
        randomAccessFile.seek(9);
        byte data[] = new byte[5];
        randomAccessFile.read(data);
        String result = new String(data);
        long seek = randomAccessFile.getFilePointer();
        assertTrue(seek == 14);
        assertTrue(result.equals("world"));
        randomAccessFile.close();
    }

//    @Test
    public void lengthTest() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("RandomAccessFileWriteTest", "rw");
        //write data
        randomAccessFile.writeBytes("hello");
        randomAccessFile.writeInt(54);
        randomAccessFile.writeBytes("world");
        randomAccessFile.writeInt(-57);

        //randomAccessFile.setLength(5457);
        long length = randomAccessFile.length();
        //assertTrue(length == 5457);
        assertTrue(length == 18);
        randomAccessFile.close();
    }

}
