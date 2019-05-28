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

public final class cb extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-10197008);
                Path l = c.l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                canvas.saveLayerAlpha(null, 51, 4);
                k2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(46.252487f, 44.839684f);
                l.lineTo(26.667143f, 48.85265f);
                l.lineTo(26.667143f, 66.858986f);
                l.lineTo(26.667143f, 68.5715f);
                l.cubicTo(26.667143f, 70.166306f, 25.580133f, 71.72134f, 24.118086f, 72.391304f);
                l.cubicTo(23.846298f, 72.51585f, 22.129362f, 72.89289f, 21.905174f, 72.9372f);
                l.cubicTo(19.751049f, 73.36299f, 18.095936f, 71.55011f, 18.004787f, 69.71689f);
                l.cubicTo(17.913637f, 67.88367f, 19.13724f, 66.35503f, 20.556929f, 66.07441f);
                l.lineTo(22.858772f, 65.61942f);
                l.cubicTo(24.065191f, 65.38096f, 24.934671f, 64.32279f, 24.934671f, 63.09303f);
                l.lineTo(24.934671f, 46.618843f);
                l.cubicTo(24.935736f, 46.618027f, 24.936798f, 46.617214f, 24.93786f, 46.6164f);
                l.lineTo(24.93786f, 45.481544f);
                l.cubicTo(24.93786f, 44.873074f, 25.365826f, 44.34853f, 25.961914f, 44.226395f);
                l.lineTo(46.461594f, 40.026085f);
                l.cubicTo(47.154797f, 39.88405f, 47.83189f, 40.330856f, 47.973923f, 41.02406f);
                l.cubicTo(47.991264f, 41.10869f, 48.0f, 41.19485f, 48.0f, 41.28124f);
                l.lineTo(48.0f, 44.02073f);
                l.lineTo(48.0f, 62.217106f);
                l.lineTo(48.0f, 63.929623f);
                l.cubicTo(48.0f, 65.52442f, 46.903553f, 67.07946f, 45.42881f, 67.74942f);
                l.cubicTo(45.15466f, 67.87396f, 43.422817f, 68.251015f, 43.196682f, 68.29533f);
                l.cubicTo(41.023853f, 68.721115f, 39.35437f, 66.908226f, 39.26243f, 65.075005f);
                l.cubicTo(39.170486f, 63.241783f, 40.404713f, 61.713146f, 41.836727f, 61.432526f);
                l.lineTo(44.172447f, 60.97482f);
                l.cubicTo(45.380814f, 60.738026f, 46.252487f, 59.67896f, 46.252487f, 58.447613f);
                l.lineTo(46.252487f, 44.839684f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
