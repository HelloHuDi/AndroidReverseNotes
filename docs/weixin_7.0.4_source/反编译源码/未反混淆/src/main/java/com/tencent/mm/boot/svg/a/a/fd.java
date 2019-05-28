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

public final class fd extends c {
    private final int height = 60;
    private final int width = 64;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 60;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -102.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(224.36317f, 150.10246f);
                l.lineTo(204.89511f, 161.91656f);
                l.lineTo(210.11502f, 139.75056f);
                l.lineTo(192.86317f, 124.88609f);
                l.lineTo(215.55734f, 123.000854f);
                l.lineTo(224.36317f, 102.0f);
                l.lineTo(233.16902f, 123.000854f);
                l.lineTo(255.86317f, 124.88609f);
                l.lineTo(238.61133f, 139.75056f);
                l.lineTo(243.83125f, 161.91656f);
                l.lineTo(224.36317f, 150.10246f);
                l.close();
                l.moveTo(224.24213f, 144.04645f);
                l.lineTo(235.99782f, 151.18034f);
                l.lineTo(232.8458f, 137.7955f);
                l.lineTo(243.26324f, 128.81966f);
                l.lineTo(229.5595f, 127.681274f);
                l.lineTo(224.24213f, 115.0f);
                l.lineTo(218.92476f, 127.681274f);
                l.lineTo(205.221f, 128.81966f);
                l.lineTo(215.63844f, 137.7955f);
                l.lineTo(212.48642f, 151.18034f);
                l.lineTo(224.24213f, 144.04645f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
