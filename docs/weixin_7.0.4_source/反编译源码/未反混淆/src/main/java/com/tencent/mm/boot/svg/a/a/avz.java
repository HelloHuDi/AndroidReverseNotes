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

public final class avz extends c {
    private final int height = 46;
    private final int width = 46;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-12206054);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(21.72f, 0.0f);
                l.lineTo(24.06f, 0.0f);
                l.cubicTo(35.45f, 0.38f, 45.34f, 10.09f, 46.0f, 21.46f);
                l.lineTo(46.0f, 24.3f);
                l.cubicTo(45.5f, 35.7f, 35.65f, 45.5f, 24.26f, 46.0f);
                l.lineTo(21.93f, 46.0f);
                l.cubicTo(10.47f, 45.63f, 0.54f, 35.78f, 0.0f, 24.34f);
                l.lineTo(0.0f, 21.82f);
                l.cubicTo(0.44f, 10.39f, 10.3f, 0.51f, 21.72f, 0.0f);
                l.lineTo(21.72f, 0.0f);
                l.close();
                l.moveTo(17.58f, 13.59f);
                l.cubicTo(15.96f, 15.34f, 16.17f, 17.82f, 15.82f, 20.0f);
                l.lineTo(12.99f, 20.0f);
                l.cubicTo(13.0f, 24.34f, 13.0f, 28.67f, 13.0f, 33.0f);
                l.lineTo(33.0f, 33.0f);
                l.cubicTo(33.0f, 28.67f, 33.0f, 24.34f, 33.01f, 20.0f);
                l.lineTo(30.18f, 20.0f);
                l.cubicTo(29.83f, 17.83f, 30.07f, 15.34f, 28.43f, 13.6f);
                l.cubicTo(25.84f, 10.18f, 20.17f, 10.17f, 17.58f, 13.59f);
                l.lineTo(17.58f, 13.59f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(18.82f, 20.0f);
                l.cubicTo(18.8f, 17.38f, 19.71f, 13.9f, 22.99f, 14.0f);
                l.cubicTo(26.26f, 13.87f, 27.22f, 17.37f, 27.18f, 20.0f);
                l.lineTo(18.82f, 20.0f);
                l.lineTo(18.82f, 20.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a3 = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(5.58f, 2.59f);
                l.cubicTo(8.17f, -0.83f, 13.84f, -0.82f, 16.43f, 2.6f);
                l.cubicTo(18.07f, 4.34f, 17.83f, 6.83f, 18.18f, 9.0f);
                l.lineTo(21.01f, 9.0f);
                l.cubicTo(21.0f, 13.34f, 21.0f, 17.67f, 21.0f, 22.0f);
                l.lineTo(1.0f, 22.0f);
                l.cubicTo(1.0f, 17.67f, 1.0f, 13.34f, 0.99f, 9.0f);
                l.lineTo(3.82f, 9.0f);
                l.cubicTo(4.17f, 6.82f, 3.96f, 4.34f, 5.58f, 2.59f);
                l.lineTo(5.58f, 2.59f);
                l.close();
                l.moveTo(6.82f, 9.0f);
                l.lineTo(15.18f, 9.0f);
                l.cubicTo(15.22f, 6.37f, 14.26f, 2.87f, 10.99f, 3.0f);
                l.cubicTo(7.71f, 2.9f, 6.8f, 6.38f, 6.82f, 9.0f);
                l.lineTo(6.82f, 9.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
