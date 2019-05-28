package com.google.android.exoplayer2.h;

import android.net.Uri;

public interface f {

    public interface a {
        f tm();
    }

    long a(i iVar);

    void close();

    Uri getUri();

    int read(byte[] bArr, int i, int i2);
}
