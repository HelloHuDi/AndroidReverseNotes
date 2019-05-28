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

public final class ti extends c {
    private final int height = 84;
    private final int width = 84;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                a.setColor(-5460820);
                g = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(35.18f, 1.25f);
                l.cubicTo(37.03f, 0.39f, 38.77f, 1.7f, 39.98f, 3.0f);
                l.cubicTo(46.58f, 9.72f, 53.34f, 16.29f, 59.91f, 23.03f);
                l.cubicTo(61.61f, 24.5f, 61.14f, 27.15f, 59.49f, 28.45f);
                l.cubicTo(49.33f, 38.64f, 39.13f, 48.78f, 28.98f, 58.99f);
                l.cubicTo(27.92f, 60.05f, 26.72f, 61.2f, 25.07f, 60.98f);
                l.cubicTo(19.04f, 61.07f, 13.0f, 60.94f, 6.97f, 61.03f);
                l.cubicTo(5.32f, 60.88f, 3.3f, 61.34f, 2.04f, 59.98f);
                l.cubicTo(0.69f, 58.72f, 1.09f, 56.7f, 0.97f, 55.06f);
                l.cubicTo(1.06f, 49.01f, 0.93f, 42.95f, 1.02f, 36.9f);
                l.cubicTo(0.82f, 35.29f, 1.94f, 34.09f, 2.99f, 33.05f);
                l.cubicTo(12.19f, 23.88f, 21.37f, 14.69f, 30.54f, 5.51f);
                l.cubicTo(32.04f, 4.04f, 33.4f, 2.39f, 35.18f, 1.25f);
                l.lineTo(35.18f, 1.25f);
                l.close();
                l.moveTo(16.16f, 38.3f);
                l.cubicTo(12.0f, 39.44f, 10.56f, 45.35f, 13.77f, 48.24f);
                l.cubicTo(16.69f, 51.44f, 22.64f, 49.97f, 23.72f, 45.78f);
                l.cubicTo(25.35f, 41.39f, 20.52f, 36.64f, 16.16f, 38.3f);
                l.lineTo(16.16f, 38.3f);
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
