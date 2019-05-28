package com.tencent.qqmusic.mediaplayer.seektable;

public interface Parsable {
    long available();

    void readBytes(byte[] bArr, int i, int i2);

    int readInt();

    int[] readIntArray(int i);

    void readIntArrayInterleaved(int i, int[]... iArr);

    long readLong();

    long[] readLongArray(int i);

    void readLongArrayInterleaved(int i, long[]... jArr);

    String readString(int i);

    long skip(long j);

    long tell();
}
