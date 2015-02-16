package com.goldenpond.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {

    public static void main(String[] agrs) {
        try {
            demo();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
        System.out.println("\nDone");
    }

    private static void demo() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("E:/workspace/GCode/commons-utilities/src/com/goldenpond/nio/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
