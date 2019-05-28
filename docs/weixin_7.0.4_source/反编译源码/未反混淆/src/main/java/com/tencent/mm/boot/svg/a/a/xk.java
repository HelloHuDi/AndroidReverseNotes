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

public final class xk extends c {
    private final int height = 43;
    private final int width = 43;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 43;
            case 1:
                return 43;
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
                canvas.save();
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                g = c.a(g, 1.0f, 0.0f, -57.0f, 0.0f, 1.0f, -1296.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-6710887);
                a.setStrokeWidth(4.6f);
                g = c.a(g, 1.0f, 0.0f, 60.0f, 0.0f, 1.0f, 1299.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(15.0f, 0.0f);
                l.cubicTo(23.284271f, 0.0f, 30.0f, 6.7157288f, 30.0f, 15.0f);
                l.cubicTo(30.0f, 23.284271f, 23.284271f, 30.0f, 15.0f, 30.0f);
                l.cubicTo(6.7157288f, 30.0f, 0.0f, 23.284271f, 0.0f, 15.0f);
                l.cubicTo(0.0f, 6.7157288f, 6.7157288f, 0.0f, 15.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                Path l2 = c.l(looper);
                l2.moveTo(26.5f, 26.5f);
                l2.lineTo(36.0f, 36.0f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
