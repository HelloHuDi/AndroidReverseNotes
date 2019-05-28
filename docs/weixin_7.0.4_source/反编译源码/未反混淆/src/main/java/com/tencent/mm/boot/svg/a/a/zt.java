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

public final class zt extends c {
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
                l.moveTo(22.5f, 27.0f);
                l.lineTo(22.5f, 19.5f);
                l.cubicTo(22.5f, 12.044156f, 28.544155f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(43.455845f, 6.0f, 49.5f, 12.044156f, 49.5f, 19.5f);
                l.lineTo(49.5f, 27.0f);
                l.lineTo(56.997383f, 27.0f);
                l.cubicTo(58.65568f, 27.0f, 60.0f, 28.342468f, 60.0f, 29.995506f);
                l.lineTo(60.0f, 63.004494f);
                l.cubicTo(60.0f, 64.65887f, 58.666107f, 66.0f, 56.997383f, 66.0f);
                l.lineTo(15.002615f, 66.0f);
                l.cubicTo(13.3443165f, 66.0f, 12.0f, 64.65753f, 12.0f, 63.004494f);
                l.lineTo(12.0f, 29.995506f);
                l.cubicTo(12.0f, 28.341135f, 13.333893f, 27.0f, 15.002615f, 27.0f);
                l.lineTo(22.5f, 27.0f);
                l.close();
                l.moveTo(27.0f, 27.0f);
                l.lineTo(45.0f, 27.0f);
                l.lineTo(45.0f, 19.5f);
                l.cubicTo(45.0f, 14.529437f, 40.970562f, 10.5f, 36.0f, 10.5f);
                l.cubicTo(31.029438f, 10.5f, 27.0f, 14.529437f, 27.0f, 19.5f);
                l.lineTo(27.0f, 27.0f);
                l.close();
                l.moveTo(34.2f, 47.62556f);
                l.lineTo(34.2f, 54.0f);
                l.lineTo(37.8f, 54.0f);
                l.lineTo(37.8f, 47.62556f);
                l.cubicTo(39.389313f, 46.93116f, 40.5f, 45.345287f, 40.5f, 43.5f);
                l.cubicTo(40.5f, 41.014717f, 38.485283f, 39.0f, 36.0f, 39.0f);
                l.cubicTo(33.514717f, 39.0f, 31.5f, 41.014717f, 31.5f, 43.5f);
                l.cubicTo(31.5f, 45.345287f, 32.610683f, 46.93116f, 34.2f, 47.62556f);
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
