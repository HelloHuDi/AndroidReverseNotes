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

public final class ru extends c {
    private final int height = 8;
    private final int width = 242;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 242;
            case 1:
                return 8;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1498304079);
                Path l = c.l(looper);
                l.moveTo(119.5f, 0.0f);
                l.cubicTo(121.433f, 0.0f, 123.0f, 1.5670033f, 123.0f, 3.5f);
                l.cubicTo(123.0f, 5.4329967f, 121.433f, 7.0f, 119.5f, 7.0f);
                l.cubicTo(117.567f, 7.0f, 116.0f, 5.4329967f, 116.0f, 3.5f);
                l.cubicTo(116.0f, 1.5670033f, 117.567f, 0.0f, 119.5f, 0.0f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setColor(-1716407887);
                a3.setStrokeCap(Cap.SQUARE);
                Path l2 = c.l(looper);
                l2.moveTo(130.5f, 3.5f);
                l2.lineTo(238.51852f, 3.5f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1716407887);
                a3.setStrokeCap(Cap.SQUARE);
                l2 = c.l(looper);
                l2.moveTo(0.5f, 3.5f);
                l2.lineTo(108.51852f, 3.5f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
