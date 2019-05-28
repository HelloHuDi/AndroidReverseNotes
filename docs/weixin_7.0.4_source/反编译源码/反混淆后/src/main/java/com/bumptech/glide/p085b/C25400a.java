package com.bumptech.glide.p085b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.b.a */
public interface C25400a {

    /* renamed from: com.bumptech.glide.b.a$a */
    public interface C25401a {
        /* renamed from: b */
        Bitmap mo42440b(int i, int i2, Config config);

        /* renamed from: da */
        byte[] mo42441da(int i);

        /* renamed from: db */
        int[] mo42442db(int i);

        /* renamed from: f */
        void mo42443f(Bitmap bitmap);

        /* renamed from: g */
        void mo42444g(byte[] bArr);

        /* renamed from: k */
        void mo42445k(int[] iArr);
    }

    /* renamed from: a */
    void mo42430a(Config config);

    void advance();

    void clear();

    ByteBuffer getData();

    int getFrameCount();

    /* renamed from: lT */
    int mo42435lT();

    /* renamed from: lU */
    int mo42436lU();

    /* renamed from: lV */
    void mo42437lV();

    /* renamed from: lW */
    int mo42438lW();

    /* renamed from: lX */
    Bitmap mo42439lX();
}
