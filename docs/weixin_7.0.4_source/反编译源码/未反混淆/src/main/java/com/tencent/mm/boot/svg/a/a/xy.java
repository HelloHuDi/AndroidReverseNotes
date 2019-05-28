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

public final class xy extends c {
    private final int height = 120;
    private final int width = 140;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 140;
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
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                k.setStrokeCap(Cap.ROUND);
                k.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-25290);
                a.setStrokeWidth(2.0f);
                float[] a2 = c.a(g, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(22.030169f, 30.0f);
                l.cubicTo(21.113115f, 70.0f, 41.103058f, 90.0f, 82.0f, 90.0f);
                l.cubicTo(79.92564f, 53.785316f, 59.935696f, 33.785316f, 22.030169f, 30.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                g = c.a(a2, -1.0f, 0.0f, 162.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(66.01508f, 48.0f);
                l.cubicTo(65.55656f, 68.0f, 75.55153f, 78.0f, 96.0f, 78.0f);
                l.cubicTo(94.96282f, 59.89266f, 84.96785f, 49.89266f, 66.01508f, 48.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
