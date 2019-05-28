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

public final class wr extends c {
    private final int height = 40;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-6710887);
                g = c.a(g, -6.123234E-17f, -1.0f, 40.000004f, -1.0f, 6.123234E-17f, 40.02865f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(35.94087f, 3.8626087f);
                l.cubicTo(31.874783f, -0.20347826f, 25.26261f, -0.21565217f, 21.191305f, 3.853913f);
                l.lineTo(17.493914f, 7.5513043f);
                l.lineTo(19.953043f, 10.010435f);
                l.lineTo(23.634783f, 6.330435f);
                l.cubicTo(26.356522f, 3.6086957f, 30.770435f, 3.6104348f, 33.48f, 6.321739f);
                l.cubicTo(36.19652f, 9.03826f, 36.193043f, 13.446957f, 33.471306f, 16.166956f);
                l.lineTo(27.33913f, 22.29913f);
                l.cubicTo(24.617392f, 25.02087f, 20.203478f, 25.01913f, 17.493914f, 22.307827f);
                l.lineTo(15.034782f, 24.766956f);
                l.cubicTo(19.10087f, 28.833044f, 25.713043f, 28.845217f, 29.784348f, 24.775652f);
                l.lineTo(35.949566f, 18.610435f);
                l.cubicTo(40.00522f, 14.553043f, 40.01565f, 7.9373913f, 35.94087f, 3.8626087f);
                l.lineTo(35.94087f, 3.8626087f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(23.732174f, 16.017391f);
                l.cubicTo(19.666086f, 11.951304f, 13.050435f, 11.942609f, 8.975652f, 16.017391f);
                l.lineTo(3.692174f, 21.354782f);
                l.cubicTo(-0.38434783f, 25.431305f, -0.37391305f, 32.027824f, 3.7008696f, 36.102608f);
                l.cubicTo(7.7669563f, 40.168697f, 14.37913f, 40.18261f, 18.448696f, 36.111305f);
                l.lineTo(21.184347f, 33.375652f);
                l.lineTo(18.725218f, 30.916521f);
                l.lineTo(15.876522f, 33.765217f);
                l.cubicTo(13.165217f, 36.47652f, 8.76f, 36.466087f, 6.0486956f, 33.754784f);
                l.cubicTo(3.3321738f, 31.038261f, 3.3304348f, 26.634783f, 6.038261f, 23.926956f);
                l.lineTo(11.50087f, 18.495653f);
                l.cubicTo(14.213913f, 15.782609f, 18.622608f, 15.789565f, 21.333914f, 18.50087f);
                l.cubicTo(21.44174f, 18.608696f, 21.546087f, 18.72f, 21.645218f, 18.833044f);
                l.lineTo(24.088696f, 16.389565f);
                l.cubicTo(23.972174f, 16.264347f, 23.853912f, 16.14087f, 23.732174f, 16.017391f);
                l.lineTo(23.732174f, 16.017391f);
                l.close();
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
