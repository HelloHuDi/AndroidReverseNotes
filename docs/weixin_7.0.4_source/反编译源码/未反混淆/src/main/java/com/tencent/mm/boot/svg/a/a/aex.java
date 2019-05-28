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

public final class aex extends c {
    private final int height = 64;
    private final int width = 64;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                g = c.a(g, 1.0f, 0.0f, 5.333333f, 0.0f, 1.0f, 5.333333f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = c.a(k, looper);
                a.setColor(-871936);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(32.360928f, 33.960926f);
                l.lineTo(25.066666f, 26.666666f);
                l.lineTo(25.066666f, 10.666667f);
                l.lineTo(28.266666f, 10.666667f);
                l.lineTo(28.266666f, 25.341183f);
                l.lineTo(34.67662f, 31.751137f);
                l.cubicTo(34.125797f, 32.04063f, 33.630104f, 32.437782f, 33.22223f, 32.927273f);
                l.lineTo(32.360928f, 33.960926f);
                l.close();
                l.moveTo(52.44347f, 33.523678f);
                l.lineTo(51.836155f, 32.832275f);
                l.cubicTo(51.246536f, 32.16102f, 50.48835f, 31.675097f, 49.652542f, 31.415672f);
                l.cubicTo(49.96776f, 29.881962f, 50.133335f, 28.29365f, 50.133335f, 26.666666f);
                l.cubicTo(50.133335f, 13.706385f, 39.62695f, 3.2f, 26.666666f, 3.2f);
                l.cubicTo(13.706385f, 3.2f, 3.2f, 13.706385f, 3.2f, 26.666666f);
                l.cubicTo(3.2f, 39.62695f, 13.706385f, 50.133335f, 26.666666f, 50.133335f);
                l.cubicTo(29.255632f, 50.133335f, 31.746675f, 49.71408f, 34.075607f, 48.939762f);
                l.lineTo(36.17955f, 51.586544f);
                l.cubicTo(33.224854f, 52.71513f, 30.017956f, 53.333332f, 26.666666f, 53.333332f);
                l.cubicTo(11.939074f, 53.333332f, 0.0f, 41.39426f, 0.0f, 26.666666f);
                l.cubicTo(0.0f, 11.939074f, 11.939074f, 0.0f, 26.666666f, 0.0f);
                l.cubicTo(41.39426f, 0.0f, 53.333332f, 11.939074f, 53.333332f, 26.666666f);
                l.cubicTo(53.333332f, 29.037308f, 53.02399f, 31.3357f, 52.44347f, 33.523678f);
                l.close();
                l.moveTo(35.680626f, 34.975758f);
                l.cubicTo(35.984615f, 34.61094f, 36.43495f, 34.4f, 36.909824f, 34.4f);
                l.lineTo(48.22984f, 34.4f);
                l.cubicTo(48.69015f, 34.4f, 49.128166f, 34.59825f, 49.431946f, 34.94409f);
                l.lineTo(53.202106f, 39.236256f);
                l.cubicTo(53.714092f, 39.819126f, 53.734158f, 40.68531f, 53.249714f, 41.291267f);
                l.lineTo(43.889675f, 52.999107f);
                l.cubicTo(43.248005f, 53.801727f, 42.026894f, 53.800026f, 41.387466f, 52.995617f);
                l.lineTo(32.080837f, 41.28778f);
                l.cubicTo(31.608892f, 40.69407f, 31.618622f, 39.850586f, 32.104134f, 39.26792f);
                l.lineTo(35.680626f, 34.975758f);
                l.close();
                l.moveTo(35.396164f, 40.315956f);
                l.lineTo(42.643543f, 49.43323f);
                l.lineTo(49.912876f, 40.340515f);
                l.lineTo(47.505653f, 37.6f);
                l.lineTo(37.659264f, 37.6f);
                l.lineTo(35.396164f, 40.315956f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
