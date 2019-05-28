package com.tencent.mm.svg;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.svg.b.b;

public class WeChatSVG {
    public static native float[] getViewPort(long j);

    private static native void nativeInit();

    public static native long parse(String str);

    public static native void release(long j);

    public static native int render(long j, Canvas canvas);

    public static native int renderViewPort(long j, Canvas canvas, float f, float f2);

    static {
        AppMethodBeat.i(70063);
        if (b.dvK()) {
            System.loadLibrary("wechatsvg");
            nativeInit();
        }
        AppMethodBeat.o(70063);
    }
}
