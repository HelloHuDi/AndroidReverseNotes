package com.tencent.qqmusic.mediaplayer.downstream;

import java.io.Closeable;

public interface IDataSink extends Closeable {
    void open();

    int write(long j, byte[] bArr, int i, int i2);
}
