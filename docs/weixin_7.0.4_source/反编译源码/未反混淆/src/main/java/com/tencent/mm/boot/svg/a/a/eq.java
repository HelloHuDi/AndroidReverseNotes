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

public final class eq extends c {
    private final int height = 32;
    private final int width = 32;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                g = c.a(g, 1.0f, 0.0f, -307.0f, 0.0f, 1.0f, -1235.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 307.0f, 0.0f, 1.0f, 1235.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a = c.a(a, looper);
                a2.setColor(855638016);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(16.0f, 31.5f);
                l.cubicTo(24.560413f, 31.5f, 31.5f, 24.560413f, 31.5f, 16.0f);
                l.cubicTo(31.5f, 7.439586f, 24.560413f, 0.5f, 16.0f, 0.5f);
                l.cubicTo(7.439586f, 0.5f, 0.5f, 7.439586f, 0.5f, 16.0f);
                l.cubicTo(0.5f, 24.560413f, 7.439586f, 31.5f, 16.0f, 31.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-1);
                l = c.l(looper);
                l.moveTo(14.023999f, 10.208398f);
                l.cubicTo(13.896853f, 10.128932f, 13.749936f, 10.086796f, 13.6f, 10.086796f);
                l.cubicTo(13.158173f, 10.086796f, 12.8f, 10.444968f, 12.8f, 10.886796f);
                l.lineTo(12.8f, 21.113203f);
                l.cubicTo(12.8f, 21.26314f, 12.842135f, 21.410057f, 12.921601f, 21.537203f);
                l.cubicTo(13.155769f, 21.911873f, 13.64933f, 22.02577f, 14.023999f, 21.791603f);
                l.lineTo(22.205126f, 16.678398f);
                l.cubicTo(22.30814f, 16.614014f, 22.39514f, 16.527014f, 22.459524f, 16.424f);
                l.cubicTo(22.693693f, 16.04933f, 22.579794f, 15.55577f, 22.205126f, 15.321602f);
                l.lineTo(14.023999f, 10.208398f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
