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

public final class afz extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k2 = c.a(k, looper);
                k2.setColor(j.INVALID_ID);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 9.6f);
                l.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                l.lineTo(86.4f, 0.0f);
                l.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                l.lineTo(96.0f, 86.4f);
                l.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                l.lineTo(9.6f, 96.0f);
                l.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                l.lineTo(0.0f, 9.6f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 75.94388f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(50.0103f, 25.920588f);
                l.lineTo(50.0103f, 54.991493f);
                l.lineTo(46.988003f, 54.989735f);
                l.lineTo(46.988003f, 25.92229f);
                l.lineTo(41.28f, 31.652632f);
                l.lineTo(39.0f, 29.363708f);
                l.lineTo(46.587086f, 21.74693f);
                l.cubicTo(47.639442f, 20.690456f, 49.348984f, 20.687119f, 50.405457f, 21.739473f);
                l.cubicTo(50.407948f, 21.741953f, 50.41043f, 21.744438f, 50.412914f, 21.74693f);
                l.lineTo(50.78f, 22.115454f);
                l.lineTo(58.0f, 29.363708f);
                l.lineTo(55.72f, 31.652632f);
                l.lineTo(50.0103f, 25.920588f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-1);
                l = c.l(looper);
                l.moveTo(66.997154f, 35.043194f);
                l.lineTo(59.003365f, 35.039516f);
                l.lineTo(59.003365f, 32.0f);
                l.lineTo(67.31531f, 32.0f);
                l.cubicTo(68.79296f, 32.0f, 70.0f, 33.218624f, 70.0f, 34.721878f);
                l.lineTo(70.0f, 68.27812f);
                l.cubicTo(70.0f, 69.77295f, 68.80181f, 71.0f, 67.32376f, 71.0f);
                l.lineTo(29.676235f, 71.0f);
                l.cubicTo(28.206472f, 71.0f, 27.0f, 69.78137f, 27.0f, 68.27812f);
                l.lineTo(27.0f, 34.721878f);
                l.cubicTo(27.0f, 33.227047f, 28.201979f, 32.0f, 29.684696f, 32.0f);
                l.lineTo(37.994774f, 32.0f);
                l.lineTo(37.994774f, 35.045048f);
                l.lineTo(29.99933f, 35.045048f);
                l.lineTo(29.99933f, 67.92924f);
                l.lineTo(66.997154f, 67.932915f);
                l.lineTo(66.997154f, 35.043194f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
