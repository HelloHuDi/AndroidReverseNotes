package com.tencent.mm.plugin.appbrand.d;

import android.graphics.Bitmap;
import android.graphics.Rect;

public interface a extends com.tencent.luggage.a.b {

    public interface a {
        void Q(byte[] bArr);
    }

    public interface c {
        void E(Bitmap bitmap);
    }

    public interface b {
        void a(String str, a aVar);

        Bitmap b(String str, Rect rect, c cVar);

        boolean match(String str);

        String wP();
    }

    Bitmap a(String str, Rect rect, c cVar);

    void a(String str, a aVar);

    Bitmap bB(String str);
}
