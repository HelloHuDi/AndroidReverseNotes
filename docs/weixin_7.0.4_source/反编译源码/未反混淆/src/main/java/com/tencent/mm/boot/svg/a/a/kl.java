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

public final class kl extends c {
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
                a.setColor(-8617594);
                g = c.a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(30.572737f, 32.89709f);
                l.lineTo(32.149662f, 36.971424f);
                l.lineTo(34.77378f, 36.971424f);
                l.lineTo(28.691349f, 21.256136f);
                l.lineTo(28.379143f, 21.256136f);
                l.lineTo(25.755024f, 21.256136f);
                l.lineTo(19.67259f, 36.971424f);
                l.lineTo(22.29671f, 36.971424f);
                l.lineTo(23.873636f, 32.89709f);
                l.lineTo(30.572737f, 32.89709f);
                l.close();
                l.moveTo(29.671635f, 30.5689f);
                l.lineTo(24.774738f, 30.5689f);
                l.lineTo(27.223186f, 24.242798f);
                l.lineTo(29.671635f, 30.5689f);
                l.close();
                l.moveTo(12.226544f, 8.0f);
                l.lineTo(63.14051f, 8.0f);
                l.cubicTo(65.4457f, 8.0f, 67.31442f, 9.868725f, 67.31442f, 12.173913f);
                l.lineTo(67.31442f, 75.54891f);
                l.cubicTo(67.31442f, 77.8541f, 65.4457f, 79.722824f, 63.14051f, 79.722824f);
                l.lineTo(12.226544f, 79.722824f);
                l.cubicTo(9.921356f, 79.722824f, 8.052631f, 77.8541f, 8.052631f, 75.54891f);
                l.lineTo(8.052631f, 12.173913f);
                l.cubicTo(8.052631f, 9.868725f, 9.921356f, 8.0f, 12.226544f, 8.0f);
                l.close();
                l.moveTo(18.827503f, 47.244564f);
                l.lineTo(18.827503f, 51.304348f);
                l.lineTo(56.53955f, 51.304348f);
                l.lineTo(56.53955f, 47.244564f);
                l.lineTo(18.827503f, 47.244564f);
                l.close();
                l.moveTo(18.827503f, 56.717392f);
                l.lineTo(18.827503f, 60.777172f);
                l.lineTo(56.53955f, 60.777172f);
                l.lineTo(56.53955f, 56.717392f);
                l.lineTo(18.827503f, 56.717392f);
                l.close();
                l.moveTo(18.827503f, 64.83696f);
                l.lineTo(18.827503f, 68.896736f);
                l.lineTo(56.53955f, 68.896736f);
                l.lineTo(56.53955f, 64.83696f);
                l.lineTo(18.827503f, 64.83696f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(60.582043f, 5.410628f);
                l.lineTo(7.4720273f, 5.410628f);
                l.cubicTo(6.3194327f, 5.410628f, 5.3850703f, 6.3449903f, 5.3850703f, 7.4975843f);
                l.lineTo(5.3850703f, 73.04348f);
                l.lineTo(4.173913f, 73.04348f);
                l.cubicTo(1.8687245f, 73.04348f, 1.1704826E-15f, 71.17475f, 8.881784E-16f, 68.86957f);
                l.lineTo(0.0f, 4.173913f);
                l.cubicTo(-2.8230417E-16f, 1.8687245f, 1.8687245f, 4.8643484E-15f, 4.173913f, 4.440892E-15f);
                l.lineTo(56.40813f, 0.0f);
                l.cubicTo(58.713318f, -4.5182935E-15f, 60.582043f, 1.8687245f, 60.582043f, 4.173913f);
                l.lineTo(60.582043f, 5.410628f);
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
