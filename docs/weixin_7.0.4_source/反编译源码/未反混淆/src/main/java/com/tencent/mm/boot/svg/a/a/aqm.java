package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aqm extends c {
    private final int height = 64;
    private final int width = 64;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 64;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k = c.a(k, looper);
                k.setColor(-11487894);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(32.0f, 64.0f);
                l.cubicTo(49.67311f, 64.0f, 64.0f, 49.67311f, 64.0f, 32.0f);
                l.cubicTo(64.0f, 14.326888f, 49.67311f, 0.0f, 32.0f, 0.0f);
                l.cubicTo(14.326888f, 0.0f, 0.0f, 14.326888f, 0.0f, 32.0f);
                l.cubicTo(0.0f, 49.67311f, 14.326888f, 64.0f, 32.0f, 64.0f);
                l.close();
                l.moveTo(3.0553617f, 31.019482f);
                l.cubicTo(2.559515f, 38.25722f, 5.4354253f, 45.386047f, 10.036881f, 50.881187f);
                l.cubicTo(14.08299f, 46.57419f, 20.043064f, 45.029606f, 24.71394f, 41.613712f);
                l.cubicTo(26.132061f, 40.73251f, 26.608074f, 38.811687f, 25.626297f, 37.415623f);
                l.cubicTo(23.623077f, 34.207653f, 20.757084f, 31.088789f, 21.104177f, 27.009516f);
                l.cubicTo(20.63808f, 20.05891f, 27.689018f, 13.524151f, 34.63087f, 15.623195f);
                l.cubicTo(41.850395f, 17.46481f, 45.093235f, 26.979813f, 41.13638f, 33.078922f);
                l.cubicTo(39.926514f, 35.42549f, 37.06052f, 37.47503f, 38.012543f, 40.415672f);
                l.cubicTo(42.495f, 45.019707f, 49.63519f, 46.00982f, 53.849884f, 51.0f);
                l.cubicTo(60.008297f, 43.910778f, 62.497448f, 33.890816f, 60.09755f, 24.80156f);
                l.cubicTo(57.16214f, 13.048896f, 46.14443f, 3.652706f, 33.9466f, 3.127945f);
                l.cubicTo(18.21835f, 1.5239588f, 3.015694f, 15.23705f, 3.0553617f, 31.019482f);
                l.lineTo(3.0553617f, 31.019482f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
