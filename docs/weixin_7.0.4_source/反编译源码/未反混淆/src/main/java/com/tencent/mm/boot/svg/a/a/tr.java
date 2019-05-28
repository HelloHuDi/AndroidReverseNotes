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

public final class tr extends c {
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
                a.setColor(-10526881);
                g = c.a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(46.01f, 0.01f);
                l.cubicTo(53.34f, 6.17f, 60.67f, 12.34f, 68.0f, 18.5f);
                l.cubicTo(60.71f, 24.71f, 53.32f, 30.81f, 46.01f, 36.99f);
                l.cubicTo(45.99f, 33.32f, 46.0f, 29.65f, 46.0f, 25.98f);
                l.cubicTo(38.87f, 26.16f, 30.95f, 26.38f, 25.17f, 31.13f);
                l.cubicTo(21.73f, 33.95f, 19.85f, 38.09f, 17.96f, 42.0f);
                l.cubicTo(18.18f, 31.95f, 21.11f, 20.87f, 29.62f, 14.66f);
                l.cubicTo(34.26f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                l.cubicTo(46.0f, 7.35f, 46.0f, 3.68f, 46.01f, 0.01f);
                l.lineTo(46.01f, 0.01f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(1.01f, 14.82f);
                l.cubicTo(0.72f, 13.08f, 1.91f, 10.96f, 3.85f, 11.06f);
                l.cubicTo(9.89f, 10.89f, 15.94f, 11.07f, 21.98f, 10.99f);
                l.cubicTo(20.17f, 13.11f, 18.65f, 15.46f, 17.46f, 17.99f);
                l.cubicTo(14.31f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                l.lineTo(8.0f, 52.0f);
                l.lineTo(54.0f, 52.0f);
                l.lineTo(54.0f, 40.15f);
                l.cubicTo(56.32f, 38.16f, 58.66f, 36.19f, 60.99f, 34.23f);
                l.cubicTo(60.96f, 41.53f, 61.09f, 48.83f, 60.94f, 56.13f);
                l.cubicTo(61.0f, 58.1f, 58.89f, 59.32f, 57.1f, 59.0f);
                l.cubicTo(39.37f, 58.97f, 21.63f, 59.07f, 3.9f, 58.95f);
                l.cubicTo(1.9f, 59.06f, 0.69f, 56.9f, 1.01f, 55.11f);
                l.cubicTo(1.0f, 41.68f, 0.99f, 28.25f, 1.01f, 14.82f);
                l.lineTo(1.01f, 14.82f);
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
