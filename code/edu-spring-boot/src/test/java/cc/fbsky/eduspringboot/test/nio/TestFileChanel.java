package cc.fbsky.eduspringboot.test.nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChanel {

    @Test
    public void readBuffer() throws IOException {
        RandomAccessFile file = new RandomAccessFile("D:/tmp.log","rw");
        
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);

        while (-1 != fileChannel.read(byteBuffer)){

            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            System.out.println("");
            byteBuffer.clear();
        }

        file.close();
    }
}
