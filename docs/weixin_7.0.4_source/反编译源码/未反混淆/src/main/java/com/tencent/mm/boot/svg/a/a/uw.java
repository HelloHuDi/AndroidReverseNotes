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

public final class uw extends c {
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
                k.setColor(-13824);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(21.0f, 54.0f);
                l.cubicTo(21.0f, 72.226f, 35.773f, 87.0f, 53.999f, 87.0f);
                l.cubicTo(72.225f, 87.0f, 87.0f, 72.226f, 87.0f, 54.0f);
                l.cubicTo(87.0f, 35.774f, 72.225f, 21.0f, 53.999f, 21.0f);
                l.cubicTo(35.773f, 21.0f, 21.0f, 35.774f, 21.0f, 54.0f);
                l.close();
                l.moveTo(68.0f, 37.0f);
                l.cubicTo(70.762f, 37.0f, 73.0f, 39.462f, 73.0f, 42.5f);
                l.cubicTo(73.0f, 45.538f, 70.762f, 48.0f, 68.0f, 48.0f);
                l.cubicTo(65.238f, 48.0f, 63.0f, 45.538f, 63.0f, 42.5f);
                l.cubicTo(63.0f, 39.462f, 65.238f, 37.0f, 68.0f, 37.0f);
                l.lineTo(68.0f, 37.0f);
                l.close();
                l.moveTo(41.0f, 37.0f);
                l.cubicTo(43.762f, 37.0f, 46.0f, 39.462f, 46.0f, 42.5f);
                l.cubicTo(46.0f, 45.538f, 43.762f, 48.0f, 41.0f, 48.0f);
                l.cubicTo(38.238f, 48.0f, 36.0f, 45.538f, 36.0f, 42.5f);
                l.cubicTo(36.0f, 39.462f, 38.238f, 37.0f, 41.0f, 37.0f);
                l.lineTo(41.0f, 37.0f);
                l.close();
                l.moveTo(54.0f, 77.0f);
                l.cubicTo(34.667f, 77.0f, 32.0f, 59.0f, 32.0f, 59.0f);
                l.cubicTo(32.0f, 59.0f, 46.361f, 57.0f, 54.0f, 57.0f);
                l.cubicTo(61.639f, 57.0f, 76.0f, 59.0f, 76.0f, 59.0f);
                l.cubicTo(76.0f, 59.0f, 73.333f, 77.0f, 54.0f, 77.0f);
                l.lineTo(54.0f, 77.0f);
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
