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

public final class aeq extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                g = c.a(g, 2.4f, 0.0f, 0.0f, 0.0f, 2.4f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                a = c.a(a, looper);
                a.setColor(-3552823);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(19.5f, 10.123457f);
                l.cubicTo(19.5f, 4.7531796f, 15.24682f, 0.5f, 9.876543f, 0.5f);
                l.cubicTo(4.71725f, 0.5f, 0.5f, 4.789796f, 0.5f, 10.123457f);
                l.cubicTo(0.5f, 15.24682f, 4.7531796f, 19.5f, 9.876543f, 19.5f);
                l.cubicTo(15.210204f, 19.5f, 19.5f, 15.28275f, 19.5f, 10.123457f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
