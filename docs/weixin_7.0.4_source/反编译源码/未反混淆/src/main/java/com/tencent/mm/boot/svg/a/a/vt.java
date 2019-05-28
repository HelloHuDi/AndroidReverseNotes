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

public final class vt extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                Paint a2 = c.a(k, looper);
                a2.setColor(-9473160);
                g = c.a(g, 1.0f, 0.0f, 39.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                a = c.a(a, looper);
                a.setColor(-9473160);
                Path l = c.l(looper);
                l.moveTo(10.5f, 7.5f);
                l.lineTo(10.5f, 10.5f);
                l.lineTo(3.0f, 10.5f);
                l.lineTo(3.0f, 67.5f);
                l.lineTo(39.0f, 67.5f);
                l.lineTo(39.0f, 42.5f);
                l.lineTo(42.0f, 42.5f);
                l.lineTo(42.0f, 67.5f);
                l.cubicTo(42.0f, 69.15685f, 40.656853f, 70.5f, 39.0f, 70.5f);
                l.lineTo(3.0f, 70.5f);
                l.cubicTo(1.3431457f, 70.5f, 2.0290612E-16f, 69.15685f, 0.0f, 67.5f);
                l.lineTo(4.440892E-16f, 10.5f);
                l.cubicTo(2.4118308E-16f, 8.843145f, 1.3431457f, 7.5f, 3.0f, 7.5f);
                l.lineTo(10.5f, 7.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a3 = c.a(a2, looper);
                l = c.l(looper);
                l.moveTo(19.736181f, 0.0f);
                l.lineTo(22.228626f, 0.0f);
                l.cubicTo(22.580238f, 0.0f, 22.865276f, 0.28781694f, 22.865276f, 0.64285713f);
                l.cubicTo(22.865276f, 0.6517809f, 22.865093f, 0.66070366f, 22.864725f, 0.6696196f);
                l.lineTo(22.281128f, 14.812477f);
                l.cubicTo(22.26692f, 15.156808f, 21.986332f, 15.428572f, 21.64503f, 15.428572f);
                l.lineTo(20.319778f, 15.428572f);
                l.cubicTo(19.978476f, 15.428572f, 19.697887f, 15.156808f, 19.68368f, 14.812477f);
                l.lineTo(19.100082f, 0.6696196f);
                l.cubicTo(19.085445f, 0.31488723f, 19.35837f, 0.015337827f, 19.709679f, 5.573102E-4f);
                l.cubicTo(19.718508f, 1.8581032E-4f, 19.727345f, 0.0f, 19.736181f, 0.0f);
                l.close();
                l.moveTo(41.70983f, 8.148046f);
                l.lineTo(43.472256f, 9.92765f);
                l.cubicTo(43.720886f, 10.178701f, 43.720886f, 10.585736f, 43.472256f, 10.836787f);
                l.cubicTo(43.466007f, 10.843098f, 43.45963f, 10.849276f, 43.453125f, 10.855318f);
                l.lineTo(33.1365f, 20.43914f);
                l.cubicTo(32.885323f, 20.672474f, 32.49661f, 20.6643f, 32.255272f, 20.42061f);
                l.lineTo(31.318178f, 19.47438f);
                l.cubicTo(31.07684f, 19.23069f, 31.068745f, 18.838186f, 31.299826f, 18.584562f);
                l.lineTo(40.791122f, 8.167363f);
                l.cubicTo(41.029182f, 7.9060783f, 41.43194f, 7.8891335f, 41.6907f, 8.129516f);
                l.cubicTo(41.697205f, 8.135557f, 41.703583f, 8.141735f, 41.70983f, 8.148046f);
                l.close();
                l.moveTo(51.541637f, 29.598772f);
                l.lineTo(51.541637f, 32.115513f);
                l.cubicTo(51.541637f, 32.470554f, 51.2566f, 32.75837f, 50.904987f, 32.75837f);
                l.cubicTo(50.89615f, 32.75837f, 50.887314f, 32.758186f, 50.878483f, 32.757812f);
                l.lineTo(36.872166f, 32.16853f);
                l.cubicTo(36.53116f, 32.154182f, 36.26202f, 31.87086f, 36.26202f, 31.526228f);
                l.lineTo(36.26202f, 30.188057f);
                l.cubicTo(36.26202f, 29.843428f, 36.53116f, 29.560104f, 36.872166f, 29.545757f);
                l.lineTo(50.878483f, 28.956472f);
                l.cubicTo(51.22979f, 28.941692f, 51.526447f, 29.217278f, 51.541084f, 29.57201f);
                l.cubicTo(51.541454f, 29.580925f, 51.541637f, 29.589848f, 51.541637f, 29.598772f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
