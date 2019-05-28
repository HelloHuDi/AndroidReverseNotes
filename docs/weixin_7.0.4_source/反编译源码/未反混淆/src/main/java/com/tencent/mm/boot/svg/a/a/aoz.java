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

public final class aoz extends c {
    private final int height = 76;
    private final int width = 76;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path l = c.l(looper);
                l.moveTo(0.0f, 4.0f);
                l.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                l.lineTo(72.0f, 0.0f);
                l.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                l.lineTo(76.0f, 72.0f);
                l.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                l.lineTo(4.0f, 76.0f);
                l.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                l.lineTo(0.0f, 4.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-5658199);
                float[] a2 = c.a(g, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(11.048801f, 4.034698f);
                l.cubicTo(16.060522f, -0.743125f, 23.669407f, 1.7006466f, 29.878258f, 1.1320957f);
                l.cubicTo(29.898548f, 4.1444182f, 29.898548f, 7.146766f, 29.878258f, 10.159089f);
                l.cubicTo(26.469477f, 10.288758f, 22.959244f, 9.760106f, 19.631624f, 10.607945f);
                l.cubicTo(16.557634f, 12.134055f, 17.521427f, 15.994218f, 17.318523f, 18.737226f);
                l.cubicTo(21.549065f, 18.737226f, 25.769459f, 18.737226f, 30.0f, 18.757175f);
                l.cubicTo(29.513031f, 21.789448f, 29.005772f, 24.811745f, 28.468079f, 27.834042f);
                l.cubicTo(24.765087f, 27.844017f, 21.07224f, 27.85399f, 17.379395f, 27.863966f);
                l.cubicTo(17.328669f, 35.56434f, 17.38954f, 43.27469f, 17.348959f, 50.98504f);
                l.cubicTo(14.234388f, 51.004986f, 11.109673f, 51.004986f, 7.9951024f, 50.98504f);
                l.cubicTo(7.9545217f, 43.27469f, 8.015392f, 35.574314f, 7.964667f, 27.863966f);
                l.cubicTo(5.6515656f, 27.863966f, 3.3384643f, 27.844017f, 1.0152178f, 27.844017f);
                l.cubicTo(0.9949274f, 24.811745f, 0.9949274f, 21.779472f, 1.0152178f, 18.747202f);
                l.cubicTo(3.3384643f, 18.747202f, 5.6617107f, 18.737226f, 7.984957f, 18.727251f);
                l.cubicTo(8.14728f, 13.779861f, 6.8892775f, 7.8050885f, 11.048801f, 4.034698f);
                l.lineTo(11.048801f, 4.034698f);
                l.close();
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
