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

public final class ll extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(20.001331f, 33.0f);
                l.cubicTo(17.239172f, 33.0f, 15.0f, 35.236286f, 15.0f, 38.00532f);
                l.lineTo(15.0f, 67.994675f);
                l.cubicTo(15.0f, 70.75904f, 17.233757f, 73.0f, 20.001331f, 73.0f);
                l.lineTo(75.998665f, 73.0f);
                l.cubicTo(78.760826f, 73.0f, 81.0f, 70.76372f, 81.0f, 67.994675f);
                l.lineTo(81.0f, 38.00532f);
                l.cubicTo(81.0f, 35.24096f, 78.76624f, 33.0f, 75.998665f, 33.0f);
                l.lineTo(20.001331f, 33.0f);
                l.close();
                l.moveTo(41.230534f, 24.0f);
                l.lineTo(48.0f, 24.0f);
                l.lineTo(48.0f, 33.0f);
                l.lineTo(27.74054f, 33.0f);
                l.cubicTo(33.113003f, 33.0f, 35.999054f, 24.0f, 41.230534f, 24.0f);
                l.close();
                l.moveTo(68.25946f, 33.0f);
                l.cubicTo(62.886997f, 33.0f, 60.000946f, 24.0f, 54.7683f, 24.0f);
                l.lineTo(48.0f, 24.0f);
                l.lineTo(48.0f, 33.0f);
                l.lineTo(68.25946f, 33.0f);
                l.close();
                l.moveTo(48.0f, 36.0f);
                l.cubicTo(56.83692f, 36.0f, 64.0f, 43.16308f, 64.0f, 52.0f);
                l.cubicTo(64.0f, 60.83692f, 56.83692f, 68.0f, 48.0f, 68.0f);
                l.cubicTo(39.16308f, 68.0f, 32.0f, 60.83692f, 32.0f, 52.0f);
                l.cubicTo(32.0f, 43.16308f, 39.16308f, 36.0f, 48.0f, 36.0f);
                l.close();
                l.moveTo(58.0f, 52.0f);
                l.cubicTo(58.0f, 57.523f, 53.523f, 62.0f, 48.0f, 62.0f);
                l.cubicTo(42.477f, 62.0f, 38.0f, 57.523f, 38.0f, 52.0f);
                l.cubicTo(38.0f, 46.477f, 42.477f, 42.0f, 48.0f, 42.0f);
                l.cubicTo(53.523f, 42.0f, 58.0f, 46.477f, 58.0f, 52.0f);
                l.close();
                l.moveTo(18.0f, 27.0f);
                l.lineTo(27.0f, 27.0f);
                l.lineTo(27.0f, 30.0f);
                l.lineTo(18.0f, 30.0f);
                l.lineTo(18.0f, 27.0f);
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
