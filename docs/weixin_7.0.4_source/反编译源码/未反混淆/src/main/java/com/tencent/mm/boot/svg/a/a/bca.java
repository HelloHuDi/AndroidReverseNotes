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

public final class bca extends c {
    private final int height = 67;
    private final int width = 84;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                g = c.a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-9538696);
                Path l = c.l(looper);
                l.moveTo(66.83f, 3.1693f);
                l.cubicTo(66.65f, 2.9883f, 66.452f, 2.8253f, 66.239f, 2.6813f);
                l.cubicTo(65.814f, 2.3943f, 65.331f, 2.1873f, 64.811f, 2.0813f);
                l.cubicTo(64.551f, 2.0283f, 64.282f, 2.0003f, 64.006f, 2.0003f);
                l.lineTo(19.994f, 2.0003f);
                l.cubicTo(19.443f, 2.0003f, 18.918f, 2.1123f, 18.44f, 2.3143f);
                l.cubicTo(17.007f, 2.9213f, 16.0f, 4.3433f, 16.0f, 6.0003f);
                l.lineTo(16.0f, 60.9993f);
                l.cubicTo(16.0f, 63.2163f, 17.788f, 65.0003f, 19.994f, 65.0003f);
                l.lineTo(64.006f, 65.0003f);
                l.cubicTo(66.21f, 65.0003f, 68.0f, 63.2093f, 68.0f, 60.9993f);
                l.lineTo(68.0f, 6.0003f);
                l.cubicTo(68.0f, 4.8923f, 67.553f, 3.8923f, 66.83f, 3.1693f);
                l.close();
                l.moveTo(65.0f, 60.9993f);
                l.cubicTo(65.0f, 61.5513f, 64.554f, 62.0003f, 64.006f, 62.0003f);
                l.lineTo(19.994f, 62.0003f);
                l.cubicTo(19.446f, 62.0003f, 19.0f, 61.5513f, 19.0f, 60.9993f);
                l.lineTo(19.0f, 6.0003f);
                l.cubicTo(19.0f, 5.5093f, 19.329f, 5.1963f, 19.611f, 5.0763f);
                l.cubicTo(19.731f, 5.0253f, 19.86f, 5.0003f, 19.994f, 5.0003f);
                l.lineTo(64.006f, 5.0003f);
                l.cubicTo(64.076f, 5.0003f, 64.145f, 5.0073f, 64.211f, 5.0203f);
                l.cubicTo(64.336f, 5.0463f, 64.453f, 5.0953f, 64.56f, 5.1673f);
                l.cubicTo(64.613f, 5.2033f, 64.663f, 5.2443f, 64.708f, 5.2903f);
                l.cubicTo(64.841f, 5.4233f, 65.0f, 5.6543f, 65.0f, 6.0003f);
                l.lineTo(65.0f, 60.9993f);
                l.close();
                l.moveTo(27.0f, 12.0f);
                l.cubicTo(25.3425f, 12.0f, 24.0f, 13.3425f, 24.0f, 15.0f);
                l.cubicTo(24.0f, 16.6575f, 25.3425f, 18.0f, 27.0f, 18.0f);
                l.cubicTo(28.6575f, 18.0f, 30.0f, 16.6575f, 30.0f, 15.0f);
                l.cubicTo(30.0f, 13.3425f, 28.6575f, 12.0f, 27.0f, 12.0f);
                l.close();
                l.moveTo(24.0f, 42.0f);
                l.lineTo(39.0f, 42.0f);
                l.lineTo(39.0f, 45.0f);
                l.lineTo(24.0f, 45.0f);
                l.lineTo(24.0f, 42.0f);
                l.close();
                l.moveTo(24.0f, 33.0f);
                l.lineTo(39.0f, 33.0f);
                l.lineTo(39.0f, 36.0f);
                l.lineTo(24.0f, 36.0f);
                l.lineTo(24.0f, 33.0f);
                l.close();
                l.moveTo(24.0f, 24.0f);
                l.lineTo(51.0f, 24.0f);
                l.lineTo(51.0f, 27.0f);
                l.lineTo(24.0f, 27.0f);
                l.lineTo(24.0f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
