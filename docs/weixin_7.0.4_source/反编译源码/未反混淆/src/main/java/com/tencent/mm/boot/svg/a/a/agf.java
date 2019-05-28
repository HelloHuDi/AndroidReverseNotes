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

public final class agf extends c {
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
                l.moveTo(36.0f, 14.048469f);
                l.lineTo(36.0f, 22.694517f);
                l.cubicTo(26.54021f, 27.188381f, 20.0f, 36.830418f, 20.0f, 48.0f);
                l.cubicTo(20.0f, 63.463974f, 32.536026f, 76.0f, 48.0f, 76.0f);
                l.cubicTo(63.463974f, 76.0f, 76.0f, 63.463974f, 76.0f, 48.0f);
                l.cubicTo(76.0f, 36.830418f, 69.45979f, 27.188381f, 60.0f, 22.694525f);
                l.lineTo(60.0f, 14.048469f);
                l.cubicTo(73.98231f, 18.990505f, 84.0f, 32.325375f, 84.0f, 48.0f);
                l.cubicTo(84.0f, 67.88225f, 67.88225f, 84.0f, 48.0f, 84.0f);
                l.cubicTo(28.117748f, 84.0f, 12.0f, 67.88225f, 12.0f, 48.0f);
                l.cubicTo(12.0f, 32.325375f, 22.01769f, 18.990505f, 36.0f, 14.048469f);
                l.close();
                l.moveTo(44.0f, 6.0f);
                l.lineTo(52.0f, 6.0f);
                l.lineTo(52.0f, 48.0f);
                l.lineTo(44.0f, 48.0f);
                l.lineTo(44.0f, 6.0f);
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
