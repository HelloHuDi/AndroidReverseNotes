package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.b;

public interface e extends b {

    public interface a {
        void a(d dVar);
    }

    Bitmap a(d dVar, String str);

    Bitmap a(d dVar, String str, Rect rect, a aVar);

    Bitmap a(d dVar, String str, a aVar);
}
