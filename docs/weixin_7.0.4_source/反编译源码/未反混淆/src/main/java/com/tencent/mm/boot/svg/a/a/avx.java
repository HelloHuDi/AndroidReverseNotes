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

public final class avx extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-723724);
                Path l = c.l(looper);
                l.moveTo(0.0f, 30.0f);
                l.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                l.lineTo(30.0f, 0.0f);
                l.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                l.lineTo(60.0f, 30.0f);
                l.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                l.lineTo(30.0f, 60.0f);
                l.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                l.lineTo(0.0f, 30.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-363518);
                float[] a2 = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(24.475742f, 18.70696f);
                l.cubicTo(23.12304f, 21.028156f, 19.575186f, 21.698137f, 16.551128f, 20.203268f);
                l.cubicTo(13.527069f, 18.70792f, 12.171762f, 15.61459f, 13.523946f, 13.292914f);
                l.cubicTo(14.876649f, 10.971719f, 18.425022f, 10.301737f, 21.449081f, 11.797086f);
                l.cubicTo(24.473139f, 13.291956f, 25.828445f, 16.385765f, 24.475742f, 18.70696f);
                l.moveTo(25.103931f, 10.635292f);
                l.cubicTo(18.385532f, 4.646929f, 8.63892f, 4.4326096f, 3.3347385f, 10.156823f);
                l.cubicTo(-1.969443f, 15.880552f, -0.82257956f, 25.375916f, 5.89582f, 31.364279f);
                l.cubicTo(12.614714f, 37.353127f, 22.360832f, 37.567448f, 27.665506f, 31.843233f);
                l.cubicTo(32.969196f, 26.119503f, 31.822824f, 16.62414f, 25.103931f, 10.635292f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(30.503237f, 0.13884006f);
                l.cubicTo(33.136944f, -0.56668025f, 35.94263f, 1.4859271f, 36.76932f, 4.722692f);
                l.cubicTo(37.59601f, 7.959457f, 36.13047f, 11.156124f, 33.49676f, 11.861136f);
                l.cubicTo(30.86256f, 12.566657f, 28.05737f, 10.514557f, 27.230679f, 7.2772846f);
                l.cubicTo(26.40399f, 4.0405197f, 27.86953f, 0.84486794f, 30.503237f, 0.13884006f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
