package com.tencent.p177mm.p1176ag;

import java.io.Closeable;

/* renamed from: com.tencent.mm.ag.e */
public interface C45139e extends Closeable {
    int acc();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
