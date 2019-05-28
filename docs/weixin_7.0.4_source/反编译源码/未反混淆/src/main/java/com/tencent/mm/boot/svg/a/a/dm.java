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

public final class dm extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 23.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.0f, 25.019958f);
                l.cubicTo(9.014991f, 17.016632f, 17.029982f, 9.003326f, 25.054966f, 1.0f);
                l.cubicTo(26.47408f, 2.4370062f, 27.893192f, 3.8740125f, 29.292316f, 5.3209977f);
                l.cubicTo(23.73579f, 10.869439f, 18.179262f, 16.4079f, 12.63273f, 21.95634f);
                l.cubicTo(24.755154f, 21.96632f, 36.877575f, 21.95634f, 49.0f, 21.96632f);
                l.lineTo(49.0f, 28.013721f);
                l.lineTo(12.582761f, 28.013721f);
                l.cubicTo(18.129293f, 33.612057f, 23.725796f, 39.15052f, 29.292316f, 44.728897f);
                l.cubicTo(27.873203f, 46.155926f, 26.444098f, 47.57297f, 25.01499f, 49.0f);
                l.cubicTo(17.009995f, 41.006653f, 9.004997f, 33.013306f, 1.0f, 25.019958f);
                l.lineTo(1.0f, 25.019958f);
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
