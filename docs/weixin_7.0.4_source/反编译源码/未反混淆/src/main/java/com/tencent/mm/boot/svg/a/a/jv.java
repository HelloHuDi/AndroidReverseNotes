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

public final class jv extends c {
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(69.0f, 73.0f);
                l.cubicTo(69.0f, 75.18871f, 67.16411f, 77.0f, 65.0f, 77.0f);
                l.lineTo(57.0f, 77.0f);
                l.lineTo(57.0f, 57.0f);
                l.lineTo(40.0f, 57.0f);
                l.lineTo(40.0f, 77.0f);
                l.lineTo(32.0f, 77.0f);
                l.cubicTo(29.835434f, 77.0f, 28.0f, 75.18871f, 28.0f, 73.0f);
                l.lineTo(28.0f, 38.0f);
                l.lineTo(49.0f, 18.0f);
                l.lineTo(69.0f, 38.0f);
                l.lineTo(69.0f, 73.0f);
                l.close();
                l.moveTo(52.0f, 9.0f);
                l.lineTo(52.0f, 9.0f);
                l.cubicTo(50.78988f, 8.532246f, 49.708397f, 8.0f, 49.0f, 8.0f);
                l.cubicTo(47.291603f, 8.0f, 46.21012f, 8.532246f, 45.0f, 9.0f);
                l.lineTo(45.0f, 9.0f);
                l.lineTo(8.0f, 47.0f);
                l.lineTo(14.0f, 53.0f);
                l.lineTo(20.0f, 46.0f);
                l.lineTo(20.0f, 73.0f);
                l.cubicTo(20.146534f, 79.55686f, 25.5868f, 85.0f, 32.0f, 85.0f);
                l.lineTo(40.0f, 85.0f);
                l.lineTo(57.0f, 85.0f);
                l.lineTo(65.0f, 85.0f);
                l.cubicTo(71.4132f, 85.0f, 76.85346f, 79.55686f, 77.0f, 73.0f);
                l.lineTo(77.0f, 46.0f);
                l.lineTo(83.0f, 53.0f);
                l.lineTo(89.0f, 47.0f);
                l.lineTo(52.0f, 9.0f);
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
