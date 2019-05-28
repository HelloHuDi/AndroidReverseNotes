package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;

@Keep
class CommNativeBitmapStruct extends NativeBitmapStruct {
    @Keep
    private int nConfig = -1;

    public CommNativeBitmapStruct convertToCommonStruct() {
        int i = 0;
        int i2 = GLType.GL_UNSIGNED_BYTE;
        int i3 = this.nConfig;
        if (!(i3 == 4 || i3 == 3 || i3 == 2)) {
            i2 = 0;
        }
        this.glType = i2;
        i2 = this.nConfig;
        if (i2 == 4) {
            i = GLFormat.GL_RGBA;
        } else if (i2 == 3) {
            i = GLFormat.GL_RGB;
        } else if (i2 == 2) {
            i = GLFormat.GL_ALPHA;
        }
        this.glFormat = i;
        return this;
    }
}
