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

public final class aom extends c {
    private final int height = 44;
    private final int width = 54;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 44;
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.5f, 0.5f);
                l.lineTo(46.5f, 0.5f);
                l.lineTo(46.5f, 36.5f);
                l.lineTo(0.5f, 36.5f);
                l.lineTo(0.5f, 0.5f);
                l.close();
                l.moveTo(42.5f, 2.5f);
                l.lineTo(42.5f, 32.5f);
                l.lineTo(3.5f, 32.5f);
                l.lineTo(3.5f, 2.5f);
                l.lineTo(42.5f, 2.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(51.0f, 42.5f);
                l.lineTo(52.5f, 42.5f);
                l.lineTo(52.5f, 7.5f);
                l.lineTo(49.5f, 7.5f);
                l.lineTo(49.5f, 39.5f);
                l.lineTo(5.5f, 39.5f);
                l.lineTo(5.5f, 42.5f);
                l.lineTo(51.0f, 42.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(36.170597f, 14.009804f);
                l.lineTo(28.390347f, 19.793558f);
                l.lineTo(15.891026f, 9.5f);
                l.lineTo(0.5576923f, 22.578432f);
                l.lineTo(0.5576923f, 32.5f);
                l.lineTo(46.557693f, 32.5f);
                l.lineTo(46.557693f, 22.578432f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
