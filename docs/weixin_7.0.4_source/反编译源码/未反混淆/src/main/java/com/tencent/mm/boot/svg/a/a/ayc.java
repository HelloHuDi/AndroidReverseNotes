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

public final class ayc extends c {
    private final int height = 50;
    private final int width = 50;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                float[] a3 = c.a(g, 0.8910065f, 0.4539905f, -8.881499f, 0.4539905f, -0.8910065f, 36.994106f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(25.83573f, 29.0f);
                l.cubicTo(26.39911f, 31.619719f, 27.385025f, 33.732395f, 28.793476f, 35.422535f);
                l.cubicTo(29.075167f, 35.84507f, 29.356857f, 36.267605f, 29.638548f, 36.549297f);
                l.cubicTo(31.046997f, 37.957745f, 33.01883f, 38.94366f, 35.131504f, 39.0f);
                l.lineTo(38.793476f, 39.0f);
                l.cubicTo(41.187843f, 38.80282f, 43.300518f, 37.676056f, 44.568123f, 35.84507f);
                l.cubicTo(45.27235f, 34.859154f, 45.83573f, 33.59155f, 45.976574f, 32.323944f);
                l.lineTo(45.976574f, 30.774649f);
                l.cubicTo(45.976574f, 28.802816f, 45.694885f, 26.97183f, 45.131504f, 25.140844f);
                l.cubicTo(44.990658f, 24.71831f, 44.849815f, 24.295774f, 44.70897f, 23.732395f);
                l.cubicTo(44.286434f, 22.183098f, 44.145588f, 20.492958f, 44.145588f, 18.943663f);
                l.cubicTo(44.145588f, 18.239437f, 44.286434f, 16.830986f, 44.286434f, 16.830986f);
                l.cubicTo(44.42728f, 15.845071f, 43.723053f, 15.0f, 42.737137f, 15.0f);
                l.cubicTo(42.032913f, 15.0f, 41.187843f, 15.56338f, 40.76531f, 16.12676f);
                l.cubicTo(39.92024f, 16.97183f, 39.497704f, 18.09859f, 39.497704f, 19.225351f);
                l.lineTo(39.497704f, 22.746479f);
                l.lineTo(39.497704f, 23.169014f);
                l.cubicTo(39.356857f, 24.295774f, 38.37094f, 25.0f, 37.244183f, 25.0f);
                l.lineTo(17.976576f, 25.0f);
                l.cubicTo(16.872005f, 25.0f, 15.976575f, 25.89543f, 15.976575f, 27.0f);
                l.cubicTo(15.976575f, 28.10457f, 16.872005f, 29.0f, 17.976576f, 29.0f);
                l.lineTo(25.83573f, 29.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-1);
                a3 = c.a(a3, 0.76604444f, 0.64278764f, -14.573307f, -0.64278764f, 0.76604444f, 12.015224f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(-1.8615476f, 39.6103f);
                l.cubicTo(2.0552306f, 31.076334f, 14.849355f, 15.051029f, 20.299797f, 12.444754f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-1);
                g = c.a(a3, 0.92718387f, 0.37460658f, -4.2529f, -0.37460658f, 0.92718387f, 3.7691882f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(2.5404713f, 13.01096f);
                l.lineTo(10.597422f, 8.574231f);
                l.lineTo(12.597422f, 17.074232f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
