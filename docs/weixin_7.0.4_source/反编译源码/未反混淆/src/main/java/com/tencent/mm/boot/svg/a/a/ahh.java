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

public final class ahh extends c {
    private final int height = 38;
    private final int width = 38;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 38;
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
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, -1025.0f, 0.0f, 1.0f, -106.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 53.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 960.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, -19.882248f, -0.70710677f, 0.70710677f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(50.0f, 24.0f);
                l.lineTo(46.0f, 24.0f);
                l.lineTo(46.0f, 46.0f);
                l.lineTo(24.0f, 46.0f);
                l.lineTo(24.0f, 50.0f);
                l.lineTo(46.0f, 50.0f);
                l.lineTo(46.0f, 72.0f);
                l.lineTo(50.0f, 72.0f);
                l.lineTo(50.0f, 50.0f);
                l.lineTo(72.0f, 50.0f);
                l.lineTo(72.0f, 46.0f);
                l.lineTo(50.0f, 46.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
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
