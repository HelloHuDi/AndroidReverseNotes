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

public final class ir extends c {
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
                a.setColor(-14629309);
                g = c.a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(18.307041f, 16.743668f);
                l.cubicTo(20.848019f, 11.149101f, 23.42901f, 5.5745506f, 25.989996f, 0.0f);
                l.cubicTo(28.641016f, 5.5545344f, 31.141977f, 11.189134f, 33.752983f, 16.773693f);
                l.cubicTo(39.83532f, 17.174019f, 45.91766f, 17.574347f, 52.0f, 17.984682f);
                l.cubicTo(47.568295f, 22.03799f, 43.07657f, 26.03125f, 38.66487f, 30.104576f);
                l.cubicTo(40.075413f, 36.399715f, 41.475952f, 42.694855f, 42.87649f, 48.98999f);
                l.cubicTo(37.25433f, 45.867443f, 31.64217f, 42.724876f, 26.010004f, 39.622345f);
                l.cubicTo(20.377838f, 42.734886f, 14.765679f, 45.867443f, 9.143517f, 49.0f);
                l.cubicTo(10.544055f, 42.694855f, 11.954597f, 36.399715f, 13.355137f, 30.104576f);
                l.cubicTo(9.113505f, 26.24142f, 4.921893f, 22.338236f, 0.58022314f, 18.59518f);
                l.cubicTo(0.4401693f, 18.59518f, 0.15005772f, 18.58517f, 0.0f, 18.575163f);
                l.lineTo(0.0f, 18.324959f);
                l.cubicTo(6.03232f, 17.22406f, 12.214698f, 17.354166f, 18.307041f, 16.743668f);
                l.lineTo(18.307041f, 16.743668f);
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
