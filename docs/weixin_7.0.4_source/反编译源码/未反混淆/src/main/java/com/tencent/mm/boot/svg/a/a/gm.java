package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class gm extends c {
    private final int height = 21;
    private final int width = 39;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 21;
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
                canvas.saveLayerAlpha(null, 83, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, -1.0f, 1.2246469E-16f, 72.0f, -1.2246469E-16f, -1.0f, 72.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 6.123234E-17f, 1.0f, -9.0f, 1.0f, -6.123234E-17f, 9.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(63.0f, 77.8108f);
                l.lineTo(59.87755f, 81.0f);
                l.lineTo(42.883453f, 63.64262f);
                l.cubicTo(41.724884f, 62.459286f, 41.71944f, 60.546272f, 42.883453f, 59.35738f);
                l.lineTo(59.87755f, 42.0f);
                l.lineTo(63.0f, 45.1892f);
                l.lineTo(47.030582f, 61.5f);
                l.lineTo(63.0f, 77.8108f);
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
