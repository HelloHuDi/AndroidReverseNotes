package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yf extends c {
    private final int height = 104;
    private final int width = 104;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 104;
            case 1:
                return 104;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-6766);
                float[] a3 = c.a(g, 0.89879405f, -0.43837115f, 28.230295f, 0.43837115f, 0.89879405f, -15.78627f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(21.793938f, 18.856665f);
                l.lineTo(90.79637f, 43.881905f);
                l.cubicTo(92.528595f, 44.510136f, 93.42174f, 46.418655f, 92.79126f, 48.144703f);
                l.lineTo(79.09226f, 85.648125f);
                l.cubicTo(78.461784f, 87.374176f, 76.54643f, 88.26413f, 74.8142f, 87.6359f);
                l.lineTo(5.8117714f, 62.61066f);
                l.cubicTo(4.0795445f, 61.982433f, 3.1864014f, 60.073914f, 3.8168805f, 58.347866f);
                l.lineTo(17.515879f, 20.84444f);
                l.cubicTo(18.146358f, 19.118393f, 20.06171f, 18.228436f, 21.793938f, 18.856665f);
                l.close();
                canvas.saveLayerAlpha(null, n.CTRL_INDEX, 4);
                k = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-16074);
                a.setStrokeWidth(3.0f);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                g = c.a(a3, 0.9975641f, 0.06975647f, -3.3305128f, -0.06975647f, 0.9975641f, 3.923065f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(59.294525f, 21.50847f);
                l.cubicTo(64.62902f, 18.715134f, 70.33086f, 17.109463f, 76.400024f, 16.691454f);
                l.cubicTo(85.764915f, 16.630167f, 93.19274f, 19.516296f, 96.61384f, 25.42067f);
                l.cubicTo(103.76379f, 37.760567f, 90.705086f, 58.61107f, 67.44642f, 71.99156f);
                l.cubicTo(44.187748f, 85.37206f, 19.536694f, 86.21563f, 12.386744f, 73.87573f);
                l.cubicTo(11.5345125f, 72.40489f, 10.96939f, 70.81314f, 10.674427f, 69.12753f);
                l.cubicTo(10.217703f, 65.51224f, 10.431046f, 62.472187f, 11.314454f, 60.00737f);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
