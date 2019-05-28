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

public final class dg extends c {
    private final int height = 96;
    private final int width = 130;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 130;
            case 1:
                return 96;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -292.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 292.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(61.0f, 44.0f);
                l.lineTo(61.0f, 50.0f);
                l.cubicTo(61.0f, 58.22929f, 67.93958f, 65.0f, 77.0f, 65.0f);
                l.cubicTo(85.06042f, 65.0f, 92.0f, 58.22929f, 92.0f, 50.0f);
                l.lineTo(92.0f, 44.0f);
                l.lineTo(94.99676f, 44.0f);
                l.cubicTo(95.56201f, 44.0f, 96.0f, 44.45037f, 96.0f, 45.005928f);
                l.lineTo(96.0f, 50.25f);
                l.cubicTo(96.0f, 60.017532f, 88.3659f, 67.91314f, 79.0f, 68.89677f);
                l.lineTo(79.0f, 72.0f);
                l.lineTo(91.003685f, 72.0f);
                l.cubicTo(91.561775f, 72.0f, 92.0f, 72.45191f, 92.0f, 73.00937f);
                l.lineTo(92.0f, 74.99063f);
                l.cubicTo(92.0f, 75.55665f, 91.55393f, 76.0f, 91.003685f, 76.0f);
                l.lineTo(61.996315f, 76.0f);
                l.cubicTo(61.438225f, 76.0f, 61.0f, 75.54809f, 61.0f, 74.99063f);
                l.lineTo(61.0f, 73.00937f);
                l.cubicTo(61.0f, 72.44335f, 61.446064f, 72.0f, 61.996315f, 72.0f);
                l.lineTo(74.0f, 72.0f);
                l.lineTo(74.0f, 68.796776f);
                l.cubicTo(64.20818f, 67.464806f, 57.0f, 59.741146f, 57.0f, 50.25f);
                l.lineTo(57.0f, 44.997505f);
                l.cubicTo(57.0f, 44.447468f, 57.449165f, 44.0f, 58.003242f, 44.0f);
                l.lineTo(61.0f, 44.0f);
                l.close();
                l.moveTo(76.5f, 21.0f);
                l.cubicTo(82.30026f, 21.0f, 87.0f, 25.705276f, 87.0f, 31.50953f);
                l.lineTo(87.0f, 50.49047f);
                l.cubicTo(87.0f, 56.29387f, 82.29899f, 61.0f, 76.5f, 61.0f);
                l.cubicTo(70.69974f, 61.0f, 66.0f, 56.294724f, 66.0f, 50.49047f);
                l.lineTo(66.0f, 31.50953f);
                l.cubicTo(66.0f, 25.706133f, 70.70101f, 21.0f, 76.5f, 21.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
