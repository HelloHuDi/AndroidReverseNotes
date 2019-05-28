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

public final class lg extends c {
    private final int height = 102;
    private final int width = 102;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                l.moveTo(51.0f, 102.0f);
                l.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                l.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                l.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                l.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                l.lineTo(51.0f, 102.0f);
                l.close();
                l.moveTo(51.0f, 98.0f);
                l.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                l.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                l.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                l.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                l.lineTo(51.0f, 98.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(60.046738f, 37.910957f);
                l.cubicTo(69.13362f, 37.910957f, 76.5f, 45.204285f, 76.5f, 54.20548f);
                l.cubicTo(76.5f, 63.204693f, 69.13489f, 70.5f, 60.046738f, 70.5f);
                l.lineTo(29.047552f, 70.5f);
                l.cubicTo(28.745148f, 70.5f, 28.5f, 70.25656f, 28.5f, 69.968216f);
                l.lineTo(28.5f, 65.68932f);
                l.cubicTo(28.5f, 65.39562f, 28.735804f, 65.15753f, 29.047586f, 65.15753f);
                l.lineTo(60.048687f, 65.15753f);
                l.cubicTo(66.152725f, 65.15753f, 71.10674f, 60.25413f, 71.10674f, 54.20548f);
                l.cubicTo(71.10674f, 48.1555f, 66.15588f, 43.253426f, 60.048687f, 43.253426f);
                l.lineTo(40.83506f, 43.253426f);
                l.lineTo(40.83506f, 48.97156f);
                l.cubicTo(40.83506f, 49.56155f, 40.448963f, 49.755066f, 39.972683f, 49.402626f);
                l.lineTo(28.857897f, 41.177834f);
                l.cubicTo(28.379784f, 40.82404f, 28.38162f, 40.253983f, 28.857897f, 39.901543f);
                l.lineTo(39.972683f, 31.676752f);
                l.cubicTo(40.450798f, 31.322954f, 40.83506f, 31.517307f, 40.83506f, 32.107815f);
                l.lineTo(40.83506f, 37.910957f);
                l.lineTo(60.046738f, 37.910957f);
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
