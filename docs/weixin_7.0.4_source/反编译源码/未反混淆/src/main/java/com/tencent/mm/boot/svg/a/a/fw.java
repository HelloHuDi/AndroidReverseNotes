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

public final class fw extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                g = c.a(g, 1.0f, 0.0f, -114.0f, 0.0f, 1.0f, -60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 114.0f, 0.0f, 1.0f, 60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(5.0f, 3.3f);
                l.cubicTo(5.0f, 3.1343145f, 5.1343145f, 3.0f, 5.3f, 3.0f);
                l.lineTo(8.7f, 3.0f);
                l.cubicTo(8.865685f, 3.0f, 9.0f, 3.1343145f, 9.0f, 3.3f);
                l.lineTo(9.0f, 20.7f);
                l.cubicTo(9.0f, 20.865686f, 8.865685f, 21.0f, 8.7f, 21.0f);
                l.lineTo(5.3f, 21.0f);
                l.cubicTo(5.1343145f, 21.0f, 5.0f, 20.865686f, 5.0f, 20.7f);
                l.lineTo(5.0f, 3.3f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(15.0f, 3.3f);
                l.cubicTo(15.0f, 3.1343145f, 15.134315f, 3.0f, 15.3f, 3.0f);
                l.lineTo(18.7f, 3.0f);
                l.cubicTo(18.865686f, 3.0f, 19.0f, 3.1343145f, 19.0f, 3.3f);
                l.lineTo(19.0f, 20.7f);
                l.cubicTo(19.0f, 20.865686f, 18.865686f, 21.0f, 18.7f, 21.0f);
                l.lineTo(15.3f, 21.0f);
                l.cubicTo(15.134315f, 21.0f, 15.0f, 20.865686f, 15.0f, 20.7f);
                l.lineTo(15.0f, 3.3f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
