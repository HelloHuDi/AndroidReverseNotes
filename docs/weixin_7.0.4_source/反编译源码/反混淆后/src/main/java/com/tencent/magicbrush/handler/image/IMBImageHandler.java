package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.IBitmap;

public interface IMBImageHandler {

    /* renamed from: com.tencent.magicbrush.handler.image.IMBImageHandler$a */
    public interface C25718a {
        /* renamed from: ag */
        void mo43565ag(Object obj);
    }

    @Keep
    String encodeToBase64(Bitmap bitmap, int i, float f);

    @Keep
    byte[] encodeToBuffer(Bitmap bitmap, int i, float f);

    @Keep
    Bitmap getBitmap(int i, int i2);

    @Keep
    void init();

    @Keep
    void loadBitmapAsync(String str);

    @Keep
    IBitmap loadBitmapSync(String str);

    @Keep
    void release();

    @Keep
    void releaseBitmap(Bitmap bitmap);
}
