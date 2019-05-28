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

public final class ge extends c {
    private final int height = 27;
    private final int width = 22;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 27;
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
                a.setColor(-2565928);
                Path l = c.l(looper);
                l.moveTo(14.830475f, 11.264064f);
                l.cubicTo(14.830475f, 13.443658f, 13.071956f, 15.210672f, 10.902841f, 15.210672f);
                l.cubicTo(8.733725f, 15.210672f, 6.975206f, 13.443658f, 6.975206f, 11.264064f);
                l.cubicTo(6.975206f, 9.08447f, 8.733725f, 7.3174553f, 10.902841f, 7.3174553f);
                l.cubicTo(13.071956f, 7.3174553f, 14.830475f, 9.08447f, 14.830475f, 11.264064f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 6.134616f, 0.0f, 1.0f, 17.988773f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-2565928);
                l = c.l(looper);
                l.moveTo(4.431921f, 8.5750475f);
                l.lineTo(0.32109424f, 4.4439363f);
                l.cubicTo(0.135575f, 4.257308f, 0.135575f, 3.9548347f, 0.32109424f, 3.7684193f);
                l.lineTo(2.1475172f, 1.933173f);
                l.cubicTo(2.3332481f, 1.746545f, 2.6342673f, 1.7467575f, 2.8197865f, 1.933173f);
                l.lineTo(4.431921f, 3.5535207f);
                l.cubicTo(4.617652f, 3.7401488f, 4.918671f, 3.7401488f, 5.1041903f, 3.5537333f);
                l.lineTo(8.379652f, 0.2624483f);
                l.cubicTo(8.565171f, 0.07582029f, 8.86619f, 0.07582029f, 9.051921f, 0.2624483f);
                l.lineTo(10.878345f, 2.0976946f);
                l.cubicTo(11.063864f, 2.28411f, 11.063864f, 2.5865836f, 10.878345f, 2.7732117f);
                l.lineTo(5.1041903f, 8.5750475f);
                l.cubicTo(4.918671f, 8.761676f, 4.617652f, 8.761676f, 4.431921f, 8.5750475f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.1337f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                a3.setColor(-2565928);
                l = c.l(looper);
                l.moveTo(4.5452213f, 20.379143f);
                l.lineTo(3.328029f, 19.156069f);
                l.cubicTo(-1.0228943f, 14.784127f, -1.1692789f, 7.4824657f, 3.252721f, 3.182794f);
                l.cubicTo(7.5522404f, -0.9978435f, 14.436548f, -0.9559691f, 18.684029f, 3.312031f);
                l.cubicTo(22.858316f, 7.5062723f, 22.97128f, 14.260379f, 19.022913f, 18.592997f);
                l.cubicTo(18.842049f, 18.79174f, 18.52749f, 18.791529f, 18.338163f, 18.601288f);
                l.lineTo(16.510895f, 16.76519f);
                l.cubicTo(16.329393f, 16.582813f, 16.330875f, 16.294369f, 16.501163f, 16.101364f);
                l.cubicTo(17.71201f, 14.728436f, 18.373491f, 12.980765f, 18.373491f, 11.130427f);
                l.cubicTo(18.373491f, 8.834988f, 17.355356f, 6.697693f, 15.5335865f, 5.2376156f);
                l.cubicTo(12.87751f, 3.1090357f, 9.003818f, 3.0884173f, 6.328702f, 5.192978f);
                l.cubicTo(4.3658366f, 6.737229f, 3.3168173f, 9.059451f, 3.4426827f, 11.528128f);
                l.cubicTo(3.540625f, 13.449036f, 4.4318366f, 15.243683f, 5.785471f, 16.603857f);
                l.lineTo(7.0439134f, 17.86838f);
                l.cubicTo(7.2294326f, 18.055006f, 7.2294326f, 18.357481f, 7.0439134f, 18.543896f);
                l.lineTo(5.21749f, 20.379143f);
                l.cubicTo(5.0317597f, 20.56577f, 4.730952f, 20.56577f, 4.5452213f, 20.379143f);
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
