package com.google.android.exoplayer2.p110h;

import android.net.Uri;

/* renamed from: com.google.android.exoplayer2.h.f */
public interface C0867f {

    /* renamed from: com.google.android.exoplayer2.h.f$a */
    public interface C0868a {
        /* renamed from: tm */
        C0867f mo2587tm();
    }

    /* renamed from: a */
    long mo2583a(C17665i c17665i);

    void close();

    Uri getUri();

    int read(byte[] bArr, int i, int i2);
}
