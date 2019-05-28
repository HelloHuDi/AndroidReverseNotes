package com.github.henryye.nativeiv.bitmap;

import android.graphics.Bitmap.Config;
import android.support.annotation.Keep;
import java.io.InputStream;

public interface IBitmap<Type> {
    void decodeInputStream(InputStream inputStream, Config config, c cVar);

    long getDecodeTime();

    BitmapType getType();

    Type provide();

    @Keep
    void recycle();
}
