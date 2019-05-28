package com.tencent.p177mm.svg;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.svg.p611b.C5157b;

/* renamed from: com.tencent.mm.svg.WeChatSVG */
public class WeChatSVG {
    public static native float[] getViewPort(long j);

    private static native void nativeInit();

    public static native long parse(String str);

    public static native void release(long j);

    public static native int render(long j, Canvas canvas);

    public static native int renderViewPort(long j, Canvas canvas, float f, float f2);

    static {
        AppMethodBeat.m2504i(70063);
        if (C5157b.dvK()) {
            System.loadLibrary("wechatsvg");
            WeChatSVG.nativeInit();
        }
        AppMethodBeat.m2505o(70063);
    }
}
