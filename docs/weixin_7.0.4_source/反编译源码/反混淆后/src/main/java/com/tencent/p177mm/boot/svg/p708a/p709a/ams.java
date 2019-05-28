package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.ams */
public final class ams extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(44.10407f, 48.572086f);
                l.lineTo(20.999926f, 35.23115f);
                l.cubicTo(19.958965f, 34.62973f, 19.004f, 35.25858f, 19.0f, 36.462433f);
                l.lineTo(19.004f, 62.93198f);
                l.cubicTo(19.0f, 64.13482f, 19.846968f, 65.615f, 20.88693f, 66.21947f);
                l.lineTo(44.10907f, 79.74022f);
                l.cubicTo(45.149033f, 80.345695f, 46.0f, 79.85603f, 46.0f, 78.65319f);
                l.lineTo(46.0f, 51.85246f);
                l.cubicTo(45.999f, 50.648605f, 45.14603f, 49.17249f, 44.10407f, 48.572086f);
                l.close();
                l.moveTo(73.216934f, 29.458399f);
                l.lineTo(50.073246f, 16.4451f);
                l.cubicTo(49.02697f, 15.856779f, 47.311195f, 15.850846f, 46.259857f, 16.432247f);
                l.lineTo(22.789015f, 29.413904f);
                l.cubicTo(21.738686f, 29.994316f, 21.73666f, 30.948486f, 22.784964f, 31.533842f);
                l.lineTo(46.14338f, 44.56098f);
                l.cubicTo(47.19168f, 45.14634f, 48.90745f, 45.14634f, 49.956768f, 44.56098f);
                l.lineTo(73.21288f, 31.591192f);
                l.cubicTo(74.261185f, 31.006824f, 74.2622f, 30.046722f, 73.216934f, 29.458399f);
                l.close();
                l.moveTo(76.997f, 36.350918f);
                l.cubicTo(77.001f, 35.14774f, 76.151f, 34.6553f, 75.11f, 35.256382f);
                l.lineTo(51.895f, 48.66497f);
                l.cubicTo(50.853f, 49.267067f, 50.0f, 50.74337f, 50.0f, 51.94655f);
                l.lineTo(50.0f, 78.64493f);
                l.cubicTo(50.0f, 79.84912f, 50.854f, 80.34461f, 51.898f, 79.74556f);
                l.lineTo(74.994f, 66.51567f);
                l.cubicTo(76.037f, 65.91763f, 76.996f, 64.287f, 77.0f, 63.082806f);
                l.lineTo(76.997f, 36.350918f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
