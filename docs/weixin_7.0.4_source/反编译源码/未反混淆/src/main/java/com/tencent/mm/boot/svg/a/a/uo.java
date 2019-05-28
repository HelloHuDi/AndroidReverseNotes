package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class uo extends c {
    private final int height = b.CTRL_INDEX;
    private final int width = b.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return b.CTRL_INDEX;
            case 1:
                return b.CTRL_INDEX;
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
                k.setColor(-9207928);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(64.31f, 0.0f);
                l.lineTo(70.36f, 0.0f);
                l.cubicTo(86.13f, 0.75f, 101.58f, 7.05f, 113.16f, 17.81f);
                l.cubicTo(126.28f, 29.71f, 134.19f, 46.96f, 135.0f, 64.63f);
                l.lineTo(135.0f, 70.06f);
                l.cubicTo(134.29f, 87.85f, 126.34f, 105.24f, 113.14f, 117.21f);
                l.cubicTo(101.65f, 127.9f, 86.33f, 134.15f, 70.7f, 135.0f);
                l.lineTo(64.61f, 135.0f);
                l.cubicTo(48.84f, 134.24f, 33.37f, 127.94f, 21.8f, 117.16f);
                l.cubicTo(8.65f, 105.22f, 0.75f, 87.89f, 0.0f, 70.17f);
                l.lineTo(0.0f, 64.67f);
                l.cubicTo(0.8f, 47.0f, 8.69f, 29.74f, 21.81f, 17.84f);
                l.cubicTo(33.31f, 7.13f, 48.65f, 0.86f, 64.31f, 0.0f);
                l.lineTo(64.31f, 0.0f);
                l.close();
                l.moveTo(39.37f, 50.47f);
                l.cubicTo(37.77f, 51.38f, 38.02f, 53.4f, 37.98f, 54.96f);
                l.cubicTo(38.05f, 64.0f, 37.92f, 73.04f, 38.04f, 82.08f);
                l.cubicTo(37.95f, 83.58f, 39.36f, 85.08f, 40.89f, 84.96f);
                l.cubicTo(53.29f, 85.03f, 65.69f, 85.03f, 78.09f, 84.96f);
                l.cubicTo(79.61f, 85.08f, 81.04f, 83.62f, 80.96f, 82.12f);
                l.cubicTo(81.06f, 72.7f, 80.98f, 63.29f, 81.0f, 53.87f);
                l.cubicTo(81.29f, 52.11f, 80.14f, 49.93f, 78.14f, 50.05f);
                l.cubicTo(66.77f, 49.91f, 55.39f, 50.07f, 44.02f, 49.98f);
                l.cubicTo(42.49f, 50.13f, 40.76f, 49.67f, 39.37f, 50.47f);
                l.lineTo(39.37f, 50.47f);
                l.close();
                l.moveTo(84.01f, 64.47f);
                l.cubicTo(84.0f, 66.98f, 83.99f, 69.48f, 84.0f, 71.99f);
                l.cubicTo(89.66f, 76.01f, 95.34f, 80.0f, 101.01f, 84.01f);
                l.cubicTo(100.99f, 73.01f, 101.01f, 62.01f, 101.0f, 51.01f);
                l.cubicTo(95.32f, 55.47f, 89.7f, 60.01f, 84.01f, 64.47f);
                l.lineTo(84.01f, 64.47f);
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
