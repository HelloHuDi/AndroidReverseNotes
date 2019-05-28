package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aod extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                g = c.a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-13421773);
                g = c.a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(3.0f, 0.0f);
                l.lineTo(57.0f, 0.0f);
                l.cubicTo(58.656853f, -3.043592E-16f, 60.0f, 1.3431457f, 60.0f, 3.0f);
                l.lineTo(60.0f, 45.0f);
                l.cubicTo(60.0f, 46.656853f, 58.656853f, 48.0f, 57.0f, 48.0f);
                l.lineTo(3.0f, 48.0f);
                l.cubicTo(1.3431457f, 48.0f, 2.0290612E-16f, 46.656853f, 0.0f, 45.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(87.0f, 6.1723914f);
                l.lineTo(87.0f, 41.82761f);
                l.cubicTo(87.0f, 43.484463f, 85.65685f, 44.82761f, 84.0f, 44.82761f);
                l.cubicTo(83.327805f, 44.82761f, 82.675095f, 44.601856f, 82.14654f, 44.186565f);
                l.lineTo(66.0f, 31.5f);
                l.lineTo(66.0f, 24.0f);
                l.lineTo(66.0f, 16.5f);
                l.lineTo(82.14654f, 3.8134365f);
                l.cubicTo(83.44935f, 2.7897964f, 85.33531f, 3.016112f, 86.358955f, 4.318927f);
                l.cubicTo(86.77425f, 4.8474836f, 87.0f, 5.5002f, 87.0f, 6.1723914f);
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
