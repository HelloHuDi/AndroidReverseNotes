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

public final class fo extends c {
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -330.0f, 0.0f, 1.0f, -60.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 330.0f, 0.0f, 1.0f, 60.0f);
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
                a = c.a(a, looper);
                a.setColor(-1);
                a.setStrokeWidth(1.5f);
                float[] a2 = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(12.0f, 0.0f);
                l2.lineTo(12.0f, 5.3816547f);
                l2.cubicTo(12.0f, 5.54734f, 12.134315f, 5.6816545f, 12.3f, 5.6816545f);
                l2.lineTo(17.964392f, 5.6816545f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                g = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 29.681654f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l2 = c.l(looper);
                l2.moveTo(12.0f, 12.0f);
                l2.lineTo(12.0f, 17.381655f);
                l2.cubicTo(12.0f, 17.54734f, 12.134315f, 17.681654f, 12.3f, 17.681654f);
                l2.lineTo(17.964392f, 17.681654f);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(5.964391f, 17.681654f);
                l2.lineTo(5.964391f, 12.3f);
                l2.cubicTo(5.964391f, 12.134315f, 5.8300767f, 12.0f, 5.6643915f, 12.0f);
                l2.lineTo(0.0f, 12.0f);
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(5.9643393f, 0.010877698f);
                l2.lineTo(5.9643393f, 5.3925323f);
                l2.cubicTo(5.9643393f, 5.558218f, 5.8300247f, 5.6925325f, 5.664339f, 5.6925325f);
                l2.lineTo(-5.2173913E-5f, 5.6925325f);
                canvas.drawPath(l2, a4);
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
