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

public final class ad extends c {
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
                l.moveTo(31.508831f, 53.4f);
                l.lineTo(61.5f, 53.4f);
                l.cubicTo(61.997055f, 53.4f, 62.4f, 52.997055f, 62.4f, 52.5f);
                l.lineTo(62.4f, 16.5f);
                l.cubicTo(62.4f, 16.002943f, 61.997055f, 15.6f, 61.5f, 15.6f);
                l.lineTo(10.5f, 15.6f);
                l.cubicTo(10.002944f, 15.6f, 9.6f, 16.002943f, 9.6f, 16.5f);
                l.lineTo(9.6f, 52.5f);
                l.cubicTo(9.6f, 52.997055f, 10.002944f, 53.4f, 10.5f, 53.4f);
                l.lineTo(24.6f, 53.4f);
                l.lineTo(24.6f, 60.30883f);
                l.lineTo(31.508831f, 53.4f);
                l.close();
                l.moveTo(26.12132f, 63.87868f);
                l.cubicTo(24.949747f, 65.050255f, 23.050253f, 65.050255f, 21.87868f, 63.87868f);
                l.cubicTo(21.31607f, 63.31607f, 21.0f, 62.55301f, 21.0f, 61.75736f);
                l.lineTo(21.0f, 57.0f);
                l.lineTo(10.5f, 57.0f);
                l.cubicTo(8.014719f, 57.0f, 6.0f, 54.985283f, 6.0f, 52.5f);
                l.lineTo(6.0f, 16.5f);
                l.cubicTo(6.0f, 14.014719f, 8.014719f, 12.0f, 10.5f, 12.0f);
                l.lineTo(61.5f, 12.0f);
                l.cubicTo(63.985283f, 12.0f, 66.0f, 14.014719f, 66.0f, 16.5f);
                l.lineTo(66.0f, 52.5f);
                l.cubicTo(66.0f, 54.985283f, 63.985283f, 57.0f, 61.5f, 57.0f);
                l.lineTo(33.0f, 57.0f);
                l.lineTo(26.12132f, 63.87868f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
