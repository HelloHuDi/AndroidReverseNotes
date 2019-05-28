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

public final class auv extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
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
                a.setColor(-16384);
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(20.01f, 18.99f);
                l.cubicTo(22.68f, 12.67f, 25.33f, 6.34f, 28.0f, 0.02f);
                l.cubicTo(30.67f, 6.34f, 33.33f, 12.67f, 36.0f, 18.99f);
                l.cubicTo(42.66f, 19.7f, 49.32f, 20.31f, 55.98f, 21.01f);
                l.cubicTo(51.33f, 26.03f, 46.64f, 31.0f, 42.0f, 36.02f);
                l.cubicTo(43.34f, 42.68f, 44.66f, 49.33f, 46.0f, 55.99f);
                l.cubicTo(39.98f, 52.68f, 34.01f, 49.31f, 27.99f, 46.01f);
                l.cubicTo(22.32f, 49.34f, 16.66f, 52.67f, 10.99f, 56.0f);
                l.cubicTo(12.34f, 49.34f, 13.66f, 42.68f, 15.0f, 36.02f);
                l.cubicTo(10.03f, 31.0f, 5.0f, 26.03f, 0.02f, 21.01f);
                l.cubicTo(6.68f, 20.31f, 13.35f, 19.7f, 20.01f, 18.99f);
                l.lineTo(20.01f, 18.99f);
                l.close();
                l.moveTo(14.0f, 22.0f);
                l.lineTo(14.0f, 24.0f);
                l.cubicTo(20.66f, 24.01f, 27.33f, 23.99f, 33.99f, 24.0f);
                l.cubicTo(28.01f, 29.34f, 22.0f, 34.65f, 16.02f, 40.0f);
                l.lineTo(40.0f, 40.0f);
                l.lineTo(40.0f, 38.0f);
                l.cubicTo(34.67f, 37.99f, 29.35f, 38.01f, 24.02f, 37.99f);
                l.cubicTo(30.0f, 32.65f, 36.01f, 27.34f, 42.0f, 22.0f);
                l.lineTo(14.0f, 22.0f);
                l.lineTo(14.0f, 22.0f);
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
