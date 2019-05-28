package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.nio.ByteBuffer;

public interface a {

    public interface a {
        Bitmap b(int i, int i2, Config config);

        byte[] da(int i);

        int[] db(int i);

        void f(Bitmap bitmap);

        void g(byte[] bArr);

        void k(int[] iArr);
    }

    void a(Config config);

    void advance();

    void clear();

    ByteBuffer getData();

    int getFrameCount();

    int lT();

    int lU();

    void lV();

    int lW();

    Bitmap lX();
}
