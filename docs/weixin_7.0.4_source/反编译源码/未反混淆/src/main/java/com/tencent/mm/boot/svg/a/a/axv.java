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

public final class axv extends c {
    private final int height = 14;
    private final int width = 8;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 8;
            case 1:
                return 14;
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
                g = c.a(g, 1.0f, 0.0f, -312.0f, 0.0f, 1.0f, -480.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 448.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 28.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 259.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                g = c.a(g, -1.0f, 1.2246469E-16f, 8.041568f, -1.2246469E-16f, -1.0f, 14.01054f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(7.5875087f, 12.429892f);
                l.lineTo(6.526849f, 13.490552f);
                l.lineTo(0.7479515f, 7.7116547f);
                l.cubicTo(0.35782623f, 7.3215294f, 0.3543658f, 6.692472f, 0.7479515f, 6.298886f);
                l.lineTo(6.526849f, 0.519989f);
                l.lineTo(7.5875087f, 1.5806491f);
                l.lineTo(2.1628876f, 7.0052705f);
                l.lineTo(7.5875087f, 12.429892f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
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
