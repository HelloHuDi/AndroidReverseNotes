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

public final class on extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                g = c.a(g, -0.70710677f, -0.70710677f, 131.874f, 0.70710677f, -0.70710677f, 32.16815f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(85.83542f, 16.085417f);
                l.cubicTo(86.106865f, 16.356863f, 86.27476f, 16.731863f, 86.27476f, 17.146076f);
                l.lineTo(86.27476f, 69.64608f);
                l.cubicTo(86.27476f, 70.4745f, 85.60318f, 71.14608f, 84.77476f, 71.14608f);
                l.lineTo(81.77476f, 71.14608f);
                l.cubicTo(80.94633f, 71.14608f, 80.27476f, 70.4745f, 80.27476f, 69.64608f);
                l.lineTo(80.27476f, 21.646076f);
                l.lineTo(33.774757f, 21.646076f);
                l.cubicTo(32.94633f, 21.646076f, 32.274757f, 20.974504f, 32.274757f, 20.146076f);
                l.lineTo(32.274757f, 17.146076f);
                l.cubicTo(32.274757f, 16.31765f, 32.94633f, 15.646077f, 33.774757f, 15.646077f);
                l.lineTo(84.77476f, 15.646077f);
                l.cubicTo(85.18897f, 15.646077f, 85.56397f, 15.81397f, 85.83542f, 16.085417f);
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
