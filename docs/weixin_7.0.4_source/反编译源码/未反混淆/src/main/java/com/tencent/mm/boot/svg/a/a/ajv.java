package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ajv extends c {
    private final int height = 240;
    private final int width = 180;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 63.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 4.9965324f);
                l.cubicTo(0.0f, 3.3415933f, 1.3449905f, 2.0f, 2.9962382f, 2.0f);
                l.lineTo(60.00376f, 2.0f);
                l.cubicTo(61.65854f, 2.0f, 63.0f, 3.3373792f, 63.0f, 4.9965324f);
                l.lineTo(63.0f, 49.003468f);
                l.cubicTo(63.0f, 50.658405f, 61.65501f, 52.0f, 60.00376f, 52.0f);
                l.lineTo(2.9962382f, 52.0f);
                l.cubicTo(1.3414615f, 52.0f, 0.0f, 50.66262f, 0.0f, 49.003468f);
                l.lineTo(0.0f, 4.9965324f);
                l.close();
                l.moveTo(87.5f, 53.797123f);
                l.cubicTo(89.91545f, 54.568535f, 92.0f, 53.05244f, 92.0f, 50.732754f);
                l.lineTo(92.0f, 3.235053f);
                l.cubicTo(92.0f, 0.6385606f, 89.694824f, -0.4511346f, 87.5f, 0.17068519f);
                l.cubicTo(86.19809f, 1.3064651f, 75.559074f, 11.176803f, 68.0f, 18.05712f);
                l.lineTo(68.0f, 35.728115f);
                l.cubicTo(75.74342f, 42.702545f, 86.61983f, 52.864586f, 87.5f, 53.797123f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
