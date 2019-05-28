package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aeg extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k = c.a(k, looper);
                k.setColor(-499359);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(79.03704f, 25.0f);
                l.lineTo(29.962963f, 25.0f);
                l.cubicTo(28.879408f, 25.0f, 28.0f, 25.881067f, 28.0f, 26.966667f);
                l.lineTo(28.0f, 82.03333f);
                l.cubicTo(28.0f, 83.118935f, 28.879408f, 84.0f, 29.962963f, 84.0f);
                l.lineTo(79.03704f, 84.0f);
                l.cubicTo(80.12059f, 84.0f, 81.0f, 83.118935f, 81.0f, 82.03333f);
                l.lineTo(81.0f, 26.966667f);
                l.cubicTo(81.0f, 25.880083f, 80.12059f, 25.0f, 79.03704f, 25.0f);
                l.lineTo(79.03704f, 25.0f);
                l.close();
                l.moveTo(69.22222f, 40.388184f);
                l.lineTo(69.22222f, 52.533333f);
                l.cubicTo(69.22222f, 60.679268f, 62.630592f, 67.28333f, 54.5f, 67.28333f);
                l.cubicTo(46.369408f, 67.28333f, 39.77778f, 60.679268f, 39.77778f, 52.533333f);
                l.lineTo(39.77778f, 40.388184f);
                l.cubicTo(38.61963f, 39.83555f, 37.814816f, 38.66145f, 37.814816f, 37.291668f);
                l.cubicTo(37.814816f, 35.3899f, 39.352795f, 33.85f, 41.25f, 33.85f);
                l.cubicTo(43.147205f, 33.85f, 44.685184f, 35.3899f, 44.685184f, 37.291668f);
                l.cubicTo(44.685184f, 38.662434f, 43.88037f, 39.83555f, 42.72222f, 40.388184f);
                l.lineTo(42.72222f, 52.533333f);
                l.cubicTo(42.72222f, 59.049885f, 47.99474f, 64.333336f, 54.5f, 64.333336f);
                l.cubicTo(61.004276f, 64.333336f, 66.27778f, 59.049885f, 66.27778f, 52.533333f);
                l.lineTo(66.27778f, 40.388184f);
                l.cubicTo(65.11963f, 39.83555f, 64.31481f, 38.66145f, 64.31481f, 37.291668f);
                l.cubicTo(64.31481f, 35.3899f, 65.8528f, 33.85f, 67.75f, 33.85f);
                l.cubicTo(69.6472f, 33.85f, 71.18519f, 35.3899f, 71.18519f, 37.291668f);
                l.cubicTo(71.18519f, 38.66145f, 70.37939f, 39.83555f, 69.22222f, 40.388184f);
                l.lineTo(69.22222f, 40.388184f);
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
