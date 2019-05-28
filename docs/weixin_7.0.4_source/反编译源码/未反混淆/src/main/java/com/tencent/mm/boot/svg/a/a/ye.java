package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ye extends c {
    private final int height = 102;
    private final int width = 112;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 112;
            case 1:
                return 102;
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
                a2.setColor(-1203649);
                float[] a3 = c.a(g, 0.89879405f, -0.43837115f, 28.1632f, 0.43837115f, 0.89879405f, -19.495651f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(29.793938f, 16.856665f);
                l.lineTo(98.79637f, 41.881905f);
                l.cubicTo(100.528595f, 42.510136f, 101.42174f, 44.418655f, 100.79126f, 46.144703f);
                l.lineTo(87.09226f, 83.648125f);
                l.cubicTo(86.461784f, 85.374176f, 84.54643f, 86.26413f, 82.8142f, 85.6359f);
                l.lineTo(13.811771f, 60.61066f);
                l.cubicTo(12.079545f, 59.982433f, 11.186401f, 58.073914f, 11.81688f, 56.347866f);
                l.lineTo(25.515879f, 18.84444f);
                l.cubicTo(26.146358f, 17.118393f, 28.06171f, 16.228436f, 29.793938f, 16.856665f);
                l.close();
                canvas.saveLayerAlpha(null, 108, 4);
                k = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1203649);
                a.setStrokeWidth(2.036736f);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                g = c.a(a3, 0.9975641f, 0.06975647f, -3.1715105f, -0.06975647f, 0.9975641f, 4.4762454f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(67.294525f, 19.50847f);
                l.cubicTo(72.62902f, 16.715134f, 78.33086f, 15.109462f, 84.400024f, 14.691455f);
                l.cubicTo(93.764915f, 14.630166f, 101.19274f, 17.516296f, 104.61384f, 23.42067f);
                l.cubicTo(111.76379f, 35.760567f, 98.705086f, 56.61107f, 75.44642f, 69.99156f);
                l.cubicTo(52.187748f, 83.37206f, 27.536694f, 84.21563f, 20.386744f, 71.87573f);
                l.cubicTo(19.534513f, 70.40489f, 18.96939f, 68.81314f, 18.674427f, 67.12753f);
                l.cubicTo(18.217703f, 63.51224f, 18.431046f, 60.472187f, 19.314455f, 58.00737f);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
