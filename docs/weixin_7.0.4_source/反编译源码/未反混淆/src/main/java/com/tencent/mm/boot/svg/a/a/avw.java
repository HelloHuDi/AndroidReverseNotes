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

public final class avw extends c {
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
                g = c.a(g, 1.0f, 0.0f, -415.0f, 0.0f, 1.0f, -651.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 415.0f, 0.0f, 1.0f, 651.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
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
                a = c.a(k, looper);
                a.setColor(-9074981);
                l = c.l(looper);
                l.moveTo(39.0f, 12.0f);
                l.cubicTo(36.80045f, 12.0f, 34.7991f, 12.586f, 33.0f, 14.0f);
                l.cubicTo(29.98325f, 15.412f, 27.9f, 18.645334f, 28.0f, 22.0f);
                l.lineTo(28.0f, 38.0f);
                l.cubicTo(27.9f, 40.428f, 25.2805f, 42.666668f, 22.0f, 43.0f);
                l.cubicTo(18.81885f, 42.666668f, 16.2f, 40.428f, 16.0f, 38.0f);
                l.cubicTo(16.2f, 35.701332f, 17.5299f, 34.006f, 19.0f, 33.0f);
                l.cubicTo(19.59885f, 33.13f, 19.7399f, 33.074f, 20.0f, 33.0f);
                l.cubicTo(21.0997f, 32.524666f, 22.14165f, 31.586f, 23.0f, 30.0f);
                l.cubicTo(23.09975f, 28.886667f, 22.03635f, 27.582666f, 20.0f, 28.0f);
                l.cubicTo(19.68465f, 27.582666f, 19.20885f, 27.664f, 19.0f, 28.0f);
                l.cubicTo(18.748f, 27.811333f, 18.74605f, 27.812f, 19.0f, 28.0f);
                l.cubicTo(16.0219f, 28.614f, 13.75015f, 30.371334f, 12.0f, 33.0f);
                l.cubicTo(11.5057f, 34.15f, 11.0f, 35.853333f, 11.0f, 38.0f);
                l.cubicTo(11.0f, 43.364666f, 15.9569f, 48.0f, 22.0f, 48.0f);
                l.cubicTo(24.19955f, 48.0f, 26.2009f, 47.414f, 28.0f, 46.0f);
                l.cubicTo(31.01675f, 44.588f, 33.1f, 41.354668f, 33.0f, 38.0f);
                l.lineTo(33.0f, 22.0f);
                l.cubicTo(33.1f, 19.572f, 35.71885f, 17.333334f, 39.0f, 17.0f);
                l.cubicTo(42.1805f, 17.333334f, 44.8f, 19.572f, 45.0f, 22.0f);
                l.cubicTo(44.8f, 24.382668f, 43.35765f, 26.144f, 41.0f, 27.0f);
                l.cubicTo(39.96075f, 27.374f, 38.8694f, 28.362667f, 38.0f, 30.0f);
                l.cubicTo(37.8853f, 31.135334f, 38.9435f, 32.434f, 41.0f, 32.0f);
                l.cubicTo(41.2419f, 32.434f, 41.6709f, 32.359333f, 42.0f, 32.0f);
                l.cubicTo(42.1571f, 32.218666f, 42.2247f, 32.197334f, 42.0f, 32.0f);
                l.cubicTo(44.9976f, 31.370667f, 47.2557f, 29.618668f, 49.0f, 27.0f);
                l.cubicTo(49.4943f, 25.850666f, 50.0f, 24.146667f, 50.0f, 22.0f);
                l.cubicTo(50.0f, 16.635334f, 45.0431f, 12.0f, 39.0f, 12.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
