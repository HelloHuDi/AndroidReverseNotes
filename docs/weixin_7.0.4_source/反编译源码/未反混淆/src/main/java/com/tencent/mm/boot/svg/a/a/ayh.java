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

public final class ayh extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.6f);
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setStrokeCap(Cap.SQUARE);
                g = c.a(g, 1.0f, 0.0f, 39.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(1.5f, 1.2857143f);
                l.lineTo(16.5f, 16.714285f);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, looper);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = c.l(looper);
                l2.moveTo(1.5f, 1.2857143f);
                l2.lineTo(16.5f, 16.714285f);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l3 = c.l(looper);
                l3.moveTo(1.8f, 15.3f);
                l3.lineTo(1.8f, 36.0f);
                l3.lineTo(14.15169f, 36.0f);
                l3.lineTo(27.9f, 47.456924f);
                l3.lineTo(27.9f, 3.8430748f);
                l3.lineTo(14.15169f, 15.3f);
                l3.lineTo(1.8f, 15.3f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
