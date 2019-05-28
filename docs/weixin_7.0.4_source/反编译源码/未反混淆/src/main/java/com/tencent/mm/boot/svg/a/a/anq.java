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

public final class anq extends c {
    private final int height = 168;
    private final int width = 168;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                Paint a = c.a(k, looper);
                a.setColor(-8617594);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 49.0f, 0.0f, 1.0f, 46.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.9448406f, 3.0f);
                l.cubicTo(0.42301953f, 3.0f, 0.0f, 3.4298856f, 0.0f, 3.9448407f);
                l.lineTo(0.0f, 36.05516f);
                l.cubicTo(0.0f, 36.57698f, 0.42988563f, 37.0f, 0.9448406f, 37.0f);
                l.lineTo(33.05516f, 37.0f);
                l.cubicTo(33.57698f, 37.0f, 34.0f, 36.570114f, 34.0f, 36.05516f);
                l.lineTo(34.0f, 3.9448407f);
                l.cubicTo(34.0f, 3.4230196f, 33.570114f, 3.0f, 33.05516f, 3.0f);
                l.lineTo(0.9448406f, 3.0f);
                l.lineTo(0.9448406f, 3.0f);
                l.close();
                l.moveTo(0.0f, 42.94484f);
                l.lineTo(0.0f, 75.05516f);
                l.cubicTo(0.0f, 75.57698f, 0.42988563f, 76.0f, 0.9448406f, 76.0f);
                l.lineTo(33.05516f, 76.0f);
                l.cubicTo(33.57698f, 76.0f, 34.0f, 75.570114f, 34.0f, 75.05516f);
                l.lineTo(34.0f, 42.94484f);
                l.cubicTo(34.0f, 42.42302f, 33.570114f, 42.0f, 33.05516f, 42.0f);
                l.lineTo(0.9448406f, 42.0f);
                l.cubicTo(0.42301953f, 42.0f, 0.0f, 42.429886f, 0.0f, 42.94484f);
                l.close();
                l.moveTo(39.94484f, 42.0f);
                l.cubicTo(39.42302f, 42.0f, 39.0f, 42.429886f, 39.0f, 42.94484f);
                l.lineTo(39.0f, 75.05516f);
                l.cubicTo(39.0f, 75.57698f, 39.429886f, 76.0f, 39.94484f, 76.0f);
                l.lineTo(72.05516f, 76.0f);
                l.cubicTo(72.57698f, 76.0f, 73.0f, 75.570114f, 73.0f, 75.05516f);
                l.lineTo(73.0f, 42.94484f);
                l.cubicTo(73.0f, 42.42302f, 72.570114f, 42.0f, 72.05516f, 42.0f);
                l.lineTo(39.94484f, 42.0f);
                l.lineTo(39.94484f, 42.0f);
                l.close();
                l.moveTo(39.461056f, 36.24942f);
                l.cubicTo(39.497868f, 34.750427f, 41.87496f, 16.05255f, 53.198692f, 10.63516f);
                l.cubicTo(64.52242f, 5.217771f, 71.405556f, 7.708689f, 76.82161f, 1.0075728f);
                l.cubicTo(78.15621f, -0.6436917f, 79.45604f, 12.767504f, 74.10915f, 24.23966f);
                l.cubicTo(68.76226f, 35.711815f, 57.2631f, 32.031345f, 51.075695f, 31.984705f);
                l.cubicTo(44.88829f, 31.938068f, 39.42424f, 37.74841f, 39.461056f, 36.24942f);
                l.lineTo(39.461056f, 36.24942f);
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
