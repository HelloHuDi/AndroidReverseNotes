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

public final class zf extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(44.197224f, 12.0f);
                l.cubicTo(44.698753f, 12.0f, 45.167103f, 12.250651f, 45.4453f, 12.66795f);
                l.lineTo(51.0f, 21.0f);
                l.lineTo(63.0f, 21.0f);
                l.cubicTo(64.65685f, 21.0f, 66.0f, 22.343145f, 66.0f, 24.0f);
                l.lineTo(66.0f, 57.0f);
                l.cubicTo(66.0f, 58.656853f, 64.65685f, 60.0f, 63.0f, 60.0f);
                l.lineTo(9.0f, 60.0f);
                l.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                l.lineTo(6.0f, 24.0f);
                l.cubicTo(6.0f, 22.343145f, 7.343146f, 21.0f, 9.0f, 21.0f);
                l.lineTo(21.0f, 21.0f);
                l.lineTo(26.5547f, 12.66795f);
                l.cubicTo(26.8329f, 12.250651f, 27.301247f, 12.0f, 27.802776f, 12.0f);
                l.lineTo(44.197224f, 12.0f);
                l.close();
                l.moveTo(36.0f, 49.5f);
                l.cubicTo(41.79899f, 49.5f, 46.5f, 44.79899f, 46.5f, 39.0f);
                l.cubicTo(46.5f, 33.20101f, 41.79899f, 28.5f, 36.0f, 28.5f);
                l.cubicTo(30.20101f, 28.5f, 25.5f, 33.20101f, 25.5f, 39.0f);
                l.cubicTo(25.5f, 44.79899f, 30.20101f, 49.5f, 36.0f, 49.5f);
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
