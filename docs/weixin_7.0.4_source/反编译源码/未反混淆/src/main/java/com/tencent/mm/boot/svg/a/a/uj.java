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

public final class uj extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(63.94f, 0.0f);
                l.lineTo(70.81f, 0.0f);
                l.cubicTo(86.67f, 0.91f, 102.18f, 7.35f, 113.71f, 18.32f);
                l.cubicTo(126.37f, 30.04f, 133.96f, 46.78f, 135.0f, 63.96f);
                l.lineTo(135.0f, 70.81f);
                l.cubicTo(134.04f, 88.09f, 126.4f, 104.93f, 113.68f, 116.71f);
                l.cubicTo(102.22f, 127.61f, 86.83f, 134.01f, 71.08f, 135.0f);
                l.lineTo(64.17f, 135.0f);
                l.cubicTo(48.32f, 134.09f, 32.82f, 127.65f, 21.3f, 116.69f);
                l.cubicTo(8.63f, 104.98f, 1.05f, 88.23f, 0.0f, 71.06f);
                l.lineTo(0.0f, 64.21f);
                l.cubicTo(0.96f, 46.94f, 8.58f, 30.08f, 21.3f, 18.31f);
                l.cubicTo(32.77f, 7.4f, 48.18f, 0.99f, 63.94f, 0.0f);
                l.lineTo(63.94f, 0.0f);
                l.close();
                l.moveTo(57.48f, 3.78f);
                l.cubicTo(40.34f, 6.39f, 24.51f, 16.32f, 14.64f, 30.56f);
                l.cubicTo(5.98f, 42.81f, 1.91f, 58.16f, 3.25f, 73.09f);
                l.cubicTo(4.37f, 86.66f, 9.99f, 99.8f, 19.01f, 110.01f);
                l.cubicTo(29.36f, 121.91f, 44.22f, 129.77f, 59.9f, 131.54f);
                l.cubicTo(73.73f, 133.21f, 88.08f, 130.26f, 100.07f, 123.17f);
                l.cubicTo(112.84f, 115.73f, 122.91f, 103.76f, 128.0f, 89.88f);
                l.cubicTo(133.43f, 75.31f, 133.31f, 58.76f, 127.67f, 44.26f);
                l.cubicTo(121.81f, 28.94f, 109.83f, 16.09f, 94.97f, 9.14f);
                l.cubicTo(83.39f, 3.63f, 70.14f, 1.8f, 57.48f, 3.78f);
                l.lineTo(57.48f, 3.78f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(39.32f, 45.3f);
                l.cubicTo(40.83f, 44.79f, 42.47f, 45.06f, 44.03f, 44.98f);
                l.cubicTo(60.06f, 45.04f, 76.09f, 44.96f, 92.11f, 45.02f);
                l.cubicTo(93.76f, 44.78f, 95.27f, 46.26f, 94.99f, 47.92f);
                l.cubicTo(95.01f, 60.63f, 95.01f, 73.34f, 94.99f, 86.06f);
                l.cubicTo(95.26f, 87.75f, 93.75f, 89.25f, 92.06f, 88.98f);
                l.cubicTo(75.02f, 89.01f, 57.98f, 89.01f, 40.94f, 88.98f);
                l.cubicTo(39.28f, 89.24f, 37.73f, 87.77f, 38.02f, 86.09f);
                l.cubicTo(37.97f, 73.72f, 38.03f, 61.34f, 37.99f, 48.96f);
                l.cubicTo(37.98f, 47.67f, 37.9f, 45.94f, 39.32f, 45.3f);
                l.lineTo(39.32f, 45.3f);
                l.close();
                l.moveTo(43.0f, 50.0f);
                l.lineTo(43.0f, 73.62f);
                l.cubicTo(46.44f, 68.93f, 50.54f, 64.63f, 55.48f, 61.5f);
                l.cubicTo(57.29f, 60.32f, 59.61f, 59.41f, 61.69f, 60.53f);
                l.cubicTo(68.61f, 63.77f, 71.39f, 71.39f, 76.27f, 76.76f);
                l.cubicTo(75.33f, 74.74f, 74.33f, 72.75f, 73.33f, 70.77f);
                l.cubicTo(75.67f, 69.26f, 77.98f, 66.88f, 80.96f, 67.06f);
                l.cubicTo(85.06f, 68.1f, 87.56f, 71.89f, 90.01f, 75.03f);
                l.cubicTo(89.98f, 66.69f, 90.01f, 58.34f, 90.0f, 50.0f);
                l.lineTo(43.0f, 50.0f);
                l.lineTo(43.0f, 50.0f);
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
