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

public final class bby extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k2 = c.a(k, looper);
                k2.setColor(-7829368);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(90.0f, 0.0f);
                l.lineTo(90.0f, 90.0f);
                l.lineTo(0.0f, 90.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(4.0f);
                Path l2 = c.l(looper);
                l2.moveTo(40.0f, 50.0f);
                l2.cubicTo(40.0f, 51.162144f, 39.16621f, 52.0f, 38.0f, 52.0f);
                l2.lineTo(2.0f, 52.0f);
                l2.cubicTo(0.83545685f, 52.0f, 0.0f, 51.15074f, 0.0f, 50.0f);
                l2.lineTo(0.0f, 2.0f);
                l2.cubicTo(0.0f, 0.8378576f, 0.8337914f, 0.0f, 2.0f, 0.0f);
                l2.lineTo(27.0f, 0.0f);
                l2.lineTo(40.0f, 13.0f);
                l2.lineTo(40.0f, 50.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-1);
                Path l3 = c.l(looper);
                l3.moveTo(23.0f, 0.0f);
                l3.lineTo(27.0f, 0.0f);
                l3.lineTo(27.0f, 16.0f);
                l3.lineTo(23.0f, 16.0f);
                l3.lineTo(23.0f, 0.0f);
                l3.close();
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                a3.setColor(-1);
                l3 = c.l(looper);
                l3.moveTo(23.0f, 13.0f);
                l3.lineTo(40.0f, 13.0f);
                l3.lineTo(40.0f, 17.0f);
                l3.lineTo(23.0f, 17.0f);
                l3.lineTo(23.0f, 13.0f);
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
