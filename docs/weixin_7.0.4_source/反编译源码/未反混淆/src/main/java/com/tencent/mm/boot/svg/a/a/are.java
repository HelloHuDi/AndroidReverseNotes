package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class are extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.saveLayerAlpha(null, az.CTRL_INDEX, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(57.64f, 0.0f);
                l.lineTo(62.28f, 0.0f);
                l.cubicTo(76.76f, 0.59f, 90.96f, 6.52f, 101.4f, 16.59f);
                l.cubicTo(112.61f, 27.16f, 119.33f, 42.17f, 120.0f, 57.54f);
                l.lineTo(120.0f, 62.43f);
                l.cubicTo(119.34f, 77.55f, 112.85f, 92.35f, 101.95f, 102.89f);
                l.cubicTo(91.57f, 113.17f, 77.33f, 119.24f, 62.78f, 120.0f);
                l.lineTo(57.65f, 120.0f);
                l.cubicTo(42.48f, 119.36f, 27.64f, 112.85f, 17.09f, 101.92f);
                l.cubicTo(6.78f, 91.48f, 0.68f, 77.16f, 0.0f, 62.53f);
                l.lineTo(0.0f, 57.62f);
                l.cubicTo(0.63f, 42.94f, 6.74f, 28.56f, 17.08f, 18.09f);
                l.cubicTo(27.63f, 7.16f, 42.47f, 0.64f, 57.64f, 0.0f);
                l.lineTo(57.64f, 0.0f);
                l.close();
                l.moveTo(51.51f, 4.65f);
                l.cubicTo(36.05f, 6.93f, 21.8f, 16.1f, 13.25f, 29.18f);
                l.cubicTo(4.8f, 41.83f, 1.96f, 58.0f, 5.48f, 72.79f);
                l.cubicTo(8.55f, 86.14f, 16.78f, 98.19f, 28.04f, 105.97f);
                l.cubicTo(39.28f, 113.88f, 53.5f, 117.33f, 67.12f, 115.54f);
                l.cubicTo(82.63f, 113.66f, 97.09f, 104.84f, 105.96f, 91.99f);
                l.cubicTo(114.35f, 80.09f, 117.7f, 64.82f, 115.18f, 50.48f);
                l.cubicTo(112.74f, 35.87f, 104.15f, 22.44f, 91.97f, 14.03f);
                l.cubicTo(80.35f, 5.86f, 65.54f, 2.46f, 51.51f, 4.65f);
                l.lineTo(51.51f, 4.65f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(42.01f, 32.0f);
                l.cubicTo(57.33f, 41.35f, 72.67f, 50.66f, 87.99f, 60.0f);
                l.cubicTo(72.67f, 69.34f, 57.34f, 78.67f, 42.01f, 87.99f);
                l.cubicTo(42.0f, 69.33f, 41.99f, 50.67f, 42.01f, 32.0f);
                l.lineTo(42.01f, 32.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
