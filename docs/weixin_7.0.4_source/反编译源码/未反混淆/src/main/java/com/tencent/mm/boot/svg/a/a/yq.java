package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import android.support.v4.widget.j;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yq extends c {
    private final int height = 8;
    private final int width = 14;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(j.INVALID_ID);
                g = c.a(g, -1.8369701E-16f, -1.0f, 19.0f, 1.0f, -1.8369701E-16f, -3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -2.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, -0.70710677f, -0.70710677f, 16.048742f, 0.70710677f, -0.70710677f, 7.360316f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(3.0f, 2.5039608f);
                l.lineTo(11.0f, 2.5039608f);
                l.lineTo(11.0f, 4.503961f);
                l.lineTo(4.0f, 4.503961f);
                l.lineTo(4.0f, 11.503961f);
                l.lineTo(2.0f, 11.503961f);
                l.lineTo(2.0f, 3.5039608f);
                l.cubicTo(2.0f, 2.9516761f, 2.4477153f, 2.5039608f, 3.0f, 2.5039608f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
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
