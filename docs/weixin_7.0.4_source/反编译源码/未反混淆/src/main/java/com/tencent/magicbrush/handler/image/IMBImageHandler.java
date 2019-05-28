package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.IBitmap;

public interface IMBImageHandler {

    public interface a {
        void ag(Object obj);
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
