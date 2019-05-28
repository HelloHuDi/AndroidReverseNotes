package com.tencent.mm.ag;

import java.io.Closeable;

public interface e extends Closeable {
    int acc();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
