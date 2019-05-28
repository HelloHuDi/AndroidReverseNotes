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

public final class aur extends c {
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
                a.setColor(-12206054);
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(4.24f, 9.3f);
                l.cubicTo(8.92f, 2.94f, 17.39f, -0.19f, 25.1f, 1.41f);
                l.cubicTo(32.66f, 2.78f, 39.15f, 8.72f, 41.17f, 16.14f);
                l.cubicTo(43.04f, 22.59f, 41.49f, 29.57f, 38.39f, 35.38f);
                l.cubicTo(34.3f, 42.96f, 27.97f, 49.1f, 21.0f, 54.04f);
                l.cubicTo(12.64f, 48.07f, 4.94f, 40.33f, 1.47f, 30.46f);
                l.cubicTo(-1.06f, 23.52f, -0.39f, 15.22f, 4.24f, 9.3f);
                l.lineTo(4.24f, 9.3f);
                l.close();
                l.moveTo(17.121176f, 14.014381f);
                l.cubicTo(11.980267f, 16.542173f, 11.574966f, 24.57351f, 16.44923f, 27.602592f);
                l.cubicTo(21.355494f, 31.324953f, 29.25884f, 27.197294f, 28.949532f, 21.032469f);
                l.cubicTo(29.25884f, 15.198284f, 22.102098f, 10.963966f, 17.121176f, 14.014381f);
                l.lineTo(17.121176f, 14.014381f);
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
