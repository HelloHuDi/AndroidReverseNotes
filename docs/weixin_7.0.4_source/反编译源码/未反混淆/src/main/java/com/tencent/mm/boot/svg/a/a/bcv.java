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

public final class bcv extends c {
    private final int height = 30;
    private final int width = 17;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 17;
            case 1:
                return 30;
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
                a.setColor(-2601405);
                g = c.a(g, 1.0f, 0.0f, -754.0f, 0.0f, 1.0f, -1530.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 310.0f, 0.0f, 1.0f, 1513.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 444.0f, 0.0f, 1.0f, 17.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, -3.514718f, -0.70710677f, 0.70710677f, 8.485281f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(6.9852815f, -2.0147185f);
                l.lineTo(9.985281f, -2.0147185f);
                l.lineTo(9.985281f, 18.985281f);
                l.lineTo(6.9852815f, 18.985281f);
                l.lineTo(6.9852815f, -2.0147185f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, -12.707106f, 0.70710677f, -0.70710677f, 30.67767f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = c.l(looper);
                l2.moveTo(6.9852815f, 10.985281f);
                l2.lineTo(9.985281f, 10.985281f);
                l2.lineTo(9.985281f, 31.985281f);
                l2.lineTo(6.9852815f, 31.985281f);
                l2.lineTo(6.9852815f, 10.985281f);
                l2.close();
                canvas.drawPath(l2, a);
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
