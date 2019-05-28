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

public final class aii extends c {
    private final int height = 10;
    private final int width = 20;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 10;
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
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -120.0f, 0.0f, 1.0f, -178.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, -1.8369701E-16f, -1.0f, 136.0f, 1.0f, -1.8369701E-16f, 179.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.666667f, 0.0f, 1.0f, 0.166667f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-3618616);
                g = c.a(g, -1.0f, 1.2246469E-16f, 6.701306f, -1.2246469E-16f, -1.0f, 11.67545f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(6.322924f, 10.358243f);
                l.lineTo(5.4390407f, 11.242126f);
                l.lineTo(0.6232929f, 6.4263787f);
                l.cubicTo(0.29818854f, 6.1012745f, 0.29530483f, 5.5770597f, 0.6232929f, 5.2490716f);
                l.lineTo(5.4390407f, 0.4333242f);
                l.lineTo(6.322924f, 1.3172077f);
                l.lineTo(1.8024063f, 5.837725f);
                l.lineTo(6.322924f, 10.358243f);
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
