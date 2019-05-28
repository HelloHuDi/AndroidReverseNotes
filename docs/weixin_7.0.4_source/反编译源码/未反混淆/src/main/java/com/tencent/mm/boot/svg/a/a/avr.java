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

public final class avr extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                Paint a2 = c.a(k2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(1.5f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(16.837944f, 33.589672f);
                l.cubicTo(7.7312255f, 33.589672f, 0.26877472f, 26.054348f, 0.26877472f, 16.858696f);
                l.cubicTo(0.26877472f, 7.6630435f, 7.7312255f, 0.12771739f, 16.837944f, 0.12771739f);
                l.cubicTo(25.944664f, 0.12771739f, 33.407116f, 7.6630435f, 33.407116f, 16.858696f);
                l.cubicTo(33.407116f, 26.182066f, 25.944664f, 33.589672f, 16.837944f, 33.589672f);
                l.close();
                l.moveTo(16.837944f, 1.4048913f);
                l.cubicTo(8.363636f, 1.4048913f, 1.5335969f, 8.30163f, 1.5335969f, 16.858696f);
                l.cubicTo(1.5335969f, 25.41576f, 8.363636f, 32.3125f, 16.837944f, 32.3125f);
                l.cubicTo(25.312254f, 32.3125f, 32.142292f, 25.41576f, 32.142292f, 16.858696f);
                l.cubicTo(32.142292f, 8.429348f, 25.18577f, 1.4048913f, 16.837944f, 1.4048913f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a = c.a(a2, looper);
                l = c.l(looper);
                l.moveTo(39.35178f, 40.23098f);
                l.cubicTo(39.225296f, 40.23098f, 38.972332f, 40.23098f, 38.845848f, 40.10326f);
                l.lineTo(27.841898f, 28.991848f);
                l.cubicTo(27.588932f, 28.736412f, 27.588932f, 28.35326f, 27.841898f, 28.097826f);
                l.cubicTo(28.094862f, 27.842392f, 28.474308f, 27.842392f, 28.727272f, 28.097826f);
                l.lineTo(39.731224f, 39.20924f);
                l.cubicTo(39.984188f, 39.464672f, 39.984188f, 39.847828f, 39.731224f, 40.10326f);
                l.cubicTo(39.604744f, 40.23098f, 39.47826f, 40.23098f, 39.35178f, 40.23098f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
