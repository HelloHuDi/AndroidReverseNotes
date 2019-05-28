package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

@Keep
public class MBCanvasContentHolder {
    public Bitmap content;
    public int height;
    public int width;

    @Keep
    public MBCanvasContentHolder(Bitmap bitmap, int i, int i2) {
        this.content = bitmap;
        this.width = i;
        this.height = i2;
    }
}
