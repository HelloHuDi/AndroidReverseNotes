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

public final class asb extends c {
    private final int height = 79;
    private final int width = 78;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 79;
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
                a.setColor(-11184811);
                g = c.a(g, 1.0f, 0.0f, -98.0f, 0.0f, 1.0f, -362.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 362.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(39.0f, 78.49056f);
                l.cubicTo(60.539104f, 78.49056f, 78.0f, 60.919853f, 78.0f, 39.24528f);
                l.cubicTo(78.0f, 17.570711f, 60.539104f, 0.0f, 39.0f, 0.0f);
                l.cubicTo(17.460896f, 0.0f, 0.0f, 17.570711f, 0.0f, 39.24528f);
                l.cubicTo(0.0f, 60.919853f, 17.460896f, 78.49056f, 39.0f, 78.49056f);
                l.close();
                l.moveTo(39.0f, 49.81132f);
                l.cubicTo(44.79899f, 49.81132f, 49.5f, 45.080746f, 49.5f, 39.24528f);
                l.cubicTo(49.5f, 33.40982f, 44.79899f, 28.679245f, 39.0f, 28.679245f);
                l.cubicTo(33.20101f, 28.679245f, 28.5f, 33.40982f, 28.5f, 39.24528f);
                l.cubicTo(28.5f, 45.080746f, 33.20101f, 49.81132f, 39.0f, 49.81132f);
                l.close();
                l.moveTo(5.5411763f, 25.559748f);
                l.lineTo(39.42353f, 25.559748f);
                l.lineTo(21.635294f, 7.280799f);
                l.cubicTo(14.510319f, 11.176246f, 8.756289f, 17.502306f, 5.5411763f, 25.559748f);
                l.close();
                l.moveTo(38.623528f, 3.018868f);
                l.cubicTo(42.618313f, 3.018868f, 46.231693f, 3.5782247f, 49.4f, 4.7236404f);
                l.lineTo(49.4f, 30.295227f);
                l.lineTo(25.07059f, 5.5760264f);
                l.cubicTo(29.332592f, 3.9696975f, 33.99222f, 3.018868f, 38.623528f, 3.018868f);
                l.close();
                l.moveTo(3.0f, 39.671474f);
                l.cubicTo(3.0f, 44.320057f, 3.949455f, 49.015682f, 5.55f, 53.309654f);
                l.lineTo(30.2f, 28.779875f);
                l.lineTo(4.7f, 28.779875f);
                l.cubicTo(3.5547369f, 32.009815f, 3.0f, 35.63943f, 3.0f, 39.671474f);
                l.close();
                l.moveTo(25.4f, 72.91454f);
                l.lineTo(25.4f, 38.81909f);
                l.lineTo(7.2352943f, 56.7192f);
                l.cubicTo(11.105359f, 63.90108f, 17.385756f, 69.68455f, 25.4f, 72.91454f);
                l.close();
                l.moveTo(39.42353f, 75.471695f);
                l.cubicTo(44.037518f, 75.471695f, 48.70667f, 74.51502f, 52.97647f, 72.91454f);
                l.lineTo(28.6f, 48.19534f);
                l.lineTo(28.6f, 73.76692f);
                l.cubicTo(31.807348f, 74.91449f, 35.411324f, 75.471695f, 39.42353f, 75.471695f);
                l.close();
                l.moveTo(72.458824f, 52.83019f);
                l.lineTo(38.57647f, 52.83019f);
                l.lineTo(56.364704f, 71.20977f);
                l.cubicTo(63.50134f, 67.31788f, 69.24691f, 61.003838f, 72.458824f, 52.83019f);
                l.close();
                l.moveTo(75.0f, 39.671474f);
                l.cubicTo(75.0f, 35.01675f, 74.04735f, 30.324898f, 72.45f, 26.033297f);
                l.lineTo(47.8f, 49.81132f);
                l.lineTo(73.3f, 49.81132f);
                l.cubicTo(74.441315f, 47.329823f, 75.0f, 43.696667f, 75.0f, 39.671474f);
                l.close();
                l.moveTo(52.6f, 6.381058f);
                l.lineTo(52.6f, 40.47651f);
                l.lineTo(70.76471f, 22.576397f);
                l.cubicTo(66.89496f, 15.407206f, 60.61241f, 9.61857f, 52.6f, 6.381058f);
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
