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

public final class agy extends c {
    private final int height = 240;
    private final int width = 240;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                Paint a = c.a(k, looper);
                a.setColor(-15028967);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 68.0f, 0.0f, 1.0f, 85.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(13.540069f, 40.015434f);
                l.cubicTo(12.961421f, 39.417805f, 12.934421f, 38.432583f, 13.489049f, 37.804356f);
                l.lineTo(15.936921f, 35.03166f);
                l.cubicTo(16.48739f, 34.408142f, 17.474325f, 34.316227f, 18.125168f, 34.814026f);
                l.lineTo(37.615322f, 49.72111f);
                l.cubicTo(38.273388f, 50.224434f, 39.324657f, 50.21021f, 39.97293f, 49.68157f);
                l.lineTo(89.95811f, 8.920589f);
                l.cubicTo(90.60211f, 8.395429f, 91.602684f, 8.439274f, 92.19417f, 9.019729f);
                l.lineTo(93.4955f, 10.296785f);
                l.cubicTo(94.08643f, 10.876699f, 94.083435f, 11.820237f, 93.50139f, 12.391867f);
                l.lineTo(39.869316f, 65.06429f);
                l.cubicTo(39.28163f, 65.64146f, 38.337345f, 65.62612f, 37.75749f, 65.027245f);
                l.lineTo(13.540069f, 40.015434f);
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
