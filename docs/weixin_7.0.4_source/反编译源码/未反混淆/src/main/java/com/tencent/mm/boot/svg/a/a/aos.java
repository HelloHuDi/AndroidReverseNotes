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

public final class aos extends c {
    private final int height = 180;
    private final int width = 180;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(87.2f, 0.0f);
                l.lineTo(92.22f, 0.0f);
                l.cubicTo(113.42f, 0.53f, 134.32f, 8.75f, 150.06f, 22.99f);
                l.cubicTo(168.44f, 39.28f, 179.52f, 63.39f, 180.0f, 87.94f);
                l.lineTo(180.0f, 92.07f);
                l.cubicTo(179.55f, 113.06f, 171.47f, 133.75f, 157.55f, 149.48f);
                l.cubicTo(141.39f, 167.99f, 117.4f, 179.26f, 92.84f, 180.0f);
                l.lineTo(87.55f, 180.0f);
                l.cubicTo(65.97f, 179.42f, 44.72f, 170.82f, 28.92f, 156.09f);
                l.cubicTo(11.34f, 140.02f, 0.77f, 116.72f, 0.0f, 92.92f);
                l.lineTo(0.0f, 87.36f);
                l.cubicTo(0.68f, 63.01f, 11.7f, 39.15f, 29.95f, 22.98f);
                l.cubicTo(45.54f, 8.88f, 66.21f, 0.69f, 87.2f, 0.0f);
                l.lineTo(87.2f, 0.0f);
                l.close();
                l.moveTo(78.51f, 6.8f);
                l.cubicTo(52.12f, 10.22f, 28.04f, 27.17f, 15.74f, 50.74f);
                l.cubicTo(5.37f, 70.12f, 3.19f, 93.65f, 9.69f, 114.64f);
                l.cubicTo(14.98f, 132.03f, 26.14f, 147.55f, 40.91f, 158.15f);
                l.cubicTo(55.33f, 168.63f, 73.18f, 174.25f, 91.01f, 173.98f);
                l.cubicTo(108.18f, 173.82f, 125.27f, 168.21f, 139.16f, 158.1f);
                l.cubicTo(153.28f, 147.95f, 164.1f, 133.29f, 169.62f, 116.8f);
                l.cubicTo(176.01f, 97.92f, 175.37f, 76.76f, 167.8f, 58.32f);
                l.cubicTo(160.56f, 40.44f, 146.93f, 25.24f, 129.94f, 16.11f);
                l.cubicTo(114.38f, 7.61f, 96.07f, 4.36f, 78.51f, 6.8f);
                l.lineTo(78.51f, 6.8f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(66.0f, 49.0f);
                l.cubicTo(88.66f, 62.67f, 111.34f, 76.33f, 134.0f, 90.01f);
                l.cubicTo(111.33f, 103.67f, 88.66f, 117.33f, 66.0f, 131.01f);
                l.lineTo(66.0f, 49.0f);
                l.lineTo(66.0f, 49.0f);
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
