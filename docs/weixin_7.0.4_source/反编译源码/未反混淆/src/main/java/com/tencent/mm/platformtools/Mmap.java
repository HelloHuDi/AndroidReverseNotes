package com.tencent.mm.platformtools;

public class Mmap {
    private int fileSize = 0;
    private String ghD = "";

    private static native int close(long j);

    private static native long open(String str, int i);

    private static native int read(long j, int i, int i2, Object obj);

    private static native int sync(long j, int i);

    private static native int write(long j, int i, int i2, Object obj);
}
