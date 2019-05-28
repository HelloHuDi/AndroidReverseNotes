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

public final class hb extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-10197008);
                Path l = c.l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(108.0f, 0.0f);
                l.cubicTo(114.62742f, 0.0f, 120.0f, 5.3725824f, 120.0f, 12.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(120.0f, 114.62742f, 114.62742f, 120.0f, 108.0f, 120.0f);
                l.lineTo(12.0f, 120.0f);
                l.cubicTo(5.3725824f, 120.0f, 0.0f, 114.62742f, 0.0f, 108.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(50.71693f, 17.040428f);
                l.cubicTo(46.65288f, 13.881245f, 41.546135f, 12.0f, 36.0f, 12.0f);
                l.cubicTo(22.745167f, 12.0f, 12.0f, 22.745167f, 12.0f, 36.0f);
                l.cubicTo(12.0f, 49.254833f, 22.745167f, 60.0f, 36.0f, 60.0f);
                l.cubicTo(49.254833f, 60.0f, 60.0f, 49.254833f, 60.0f, 36.0f);
                l.cubicTo(60.0f, 30.453865f, 58.118755f, 25.34712f, 54.95957f, 21.283068f);
                l.lineTo(50.672245f, 25.570396f);
                l.cubicTo(52.767628f, 28.512854f, 54.0f, 32.112507f, 54.0f, 36.0f);
                l.cubicTo(54.0f, 45.941124f, 45.941124f, 54.0f, 36.0f, 54.0f);
                l.cubicTo(26.058874f, 54.0f, 18.0f, 45.941124f, 18.0f, 36.0f);
                l.cubicTo(18.0f, 26.058874f, 26.058874f, 18.0f, 36.0f, 18.0f);
                l.cubicTo(39.887493f, 18.0f, 43.48715f, 19.232372f, 46.429604f, 21.327757f);
                l.lineTo(50.71693f, 17.040428f);
                l.close();
                l.moveTo(42.0959f, 25.661457f);
                l.cubicTo(40.30936f, 24.605787f, 38.225426f, 24.0f, 36.0f, 24.0f);
                l.cubicTo(29.372583f, 24.0f, 24.0f, 29.372583f, 24.0f, 36.0f);
                l.cubicTo(24.0f, 42.62742f, 29.372583f, 48.0f, 36.0f, 48.0f);
                l.cubicTo(42.62742f, 48.0f, 48.0f, 42.62742f, 48.0f, 36.0f);
                l.cubicTo(48.0f, 33.774574f, 47.39421f, 31.690638f, 46.338543f, 29.904099f);
                l.lineTo(41.796772f, 34.44587f);
                l.cubicTo(41.92933f, 34.94155f, 42.0f, 35.46252f, 42.0f, 36.0f);
                l.cubicTo(42.0f, 39.31371f, 39.31371f, 42.0f, 36.0f, 42.0f);
                l.cubicTo(32.68629f, 42.0f, 30.0f, 39.31371f, 30.0f, 36.0f);
                l.cubicTo(30.0f, 32.68629f, 32.68629f, 30.0f, 36.0f, 30.0f);
                l.cubicTo(36.53748f, 30.0f, 37.05845f, 30.070671f, 37.55413f, 30.20323f);
                l.lineTo(42.0959f, 25.661457f);
                l.close();
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
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
