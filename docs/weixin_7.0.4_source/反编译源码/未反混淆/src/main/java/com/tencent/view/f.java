package com.tencent.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;

public final class f {
    private static final float[] AIO = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] AIP = new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    public int height;
    public int texture = HardCoderJNI.ERR_CLIENT_CONNECT;
    public int width;

    public static f as(Bitmap bitmap) {
        AppMethodBeat.i(86637);
        if (bitmap != null) {
            f fVar = new f(g.at(bitmap), bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.o(86637);
            return fVar;
        }
        AppMethodBeat.o(86637);
        return null;
    }

    private f(int i, int i2, int i3) {
        this.texture = i;
        this.width = i2;
        this.height = i3;
    }
}
