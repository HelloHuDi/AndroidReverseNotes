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

public final class dj extends c {
    private final int height = 40;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                g = c.a(g, 1.0f, 0.0f, -637.0f, 0.0f, 1.0f, -1392.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 637.0f, 0.0f, 1.0f, 1392.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-921103);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(40.0f, 0.0f);
                l.lineTo(40.0f, 40.0f);
                l.lineTo(0.0f, 40.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-3552823);
                Path l2 = c.l(looper);
                l2.moveTo(16.955261f, 20.434963f);
                l2.cubicTo(18.24053f, 22.476675f, 16.106638f, 23.401121f, 15.21541f, 23.914665f);
                l2.cubicTo(11.381262f, 26.095942f, 9.705882f, 26.912895f, 9.705882f, 27.974316f);
                l2.lineTo(9.705882f, 29.424192f);
                l2.cubicTo(9.705882f, 29.890316f, 10.054523f, 30.294117f, 10.575808f, 30.294117f);
                l2.lineTo(29.424192f, 30.294117f);
                l2.cubicTo(29.945477f, 30.294117f, 30.294117f, 29.890316f, 30.294117f, 29.424192f);
                l2.lineTo(30.294117f, 27.974316f);
                l2.cubicTo(30.294117f, 26.912895f, 28.618738f, 26.095942f, 24.78459f, 23.914665f);
                l2.cubicTo(23.893362f, 23.401121f, 21.75947f, 22.476675f, 23.044739f, 20.434963f);
                l2.cubicTo(24.186148f, 18.739943f, 25.076778f, 18.04949f, 25.074566f, 15.21541f);
                l2.cubicTo(25.076778f, 12.524936f, 23.08713f, 9.705882f, 20.144987f, 9.705882f);
                l2.cubicTo(16.91287f, 9.705882f, 14.923222f, 12.524936f, 14.925435f, 15.21541f);
                l2.cubicTo(14.923222f, 18.04949f, 15.813852f, 18.739943f, 16.955261f, 20.434963f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
