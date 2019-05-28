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

public final class wx extends c {
    private final int height = 58;
    private final int width = 58;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                k.setStrokeCap(Cap.SQUARE);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.32f);
                g = c.a(g, 1.0f, 0.0f, -2167.0f, 0.0f, 1.0f, -920.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2168.64f, 0.0f, 1.0f, 921.6f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(33.12f, 33.12f);
                l.lineTo(33.12f, 53.28f);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                g = c.a(g, 6.123234E-17f, -1.0f, 77.759995f, 1.0f, 6.123234E-17f, -11.52f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = c.l(looper);
                l2.moveTo(44.64f, 24.48f);
                l2.lineTo(44.64f, 41.76f);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, -1.0f, 0.0f, 25.92f, 0.0f, -1.0f, 25.92f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(4.32f, 4.32f);
                l.lineTo(4.32f, 24.48f);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 6.123234E-17f, -1.0f, 20.16f, 1.0f, 6.123234E-17f, -11.52f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l3 = c.l(looper);
                l3.moveTo(15.84f, -4.32f);
                l3.lineTo(15.84f, 12.96f);
                canvas.drawPath(l3, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
