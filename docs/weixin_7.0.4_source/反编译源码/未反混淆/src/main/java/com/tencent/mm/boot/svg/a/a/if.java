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

public final class if extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-16896);
                Path l = c.l(looper);
                l.moveTo(115.8f, 60.68889f);
                l.cubicTo(115.8f, 29.181868f, 90.81813f, 4.2f, 59.31111f, 4.2f);
                l.cubicTo(29.181868f, 4.2f, 4.2f, 29.181868f, 4.2f, 60.68889f);
                l.cubicTo(4.2f, 90.81813f, 29.181868f, 115.8f, 59.31111f, 115.8f);
                l.cubicTo(90.81813f, 115.8f, 115.8f, 90.81813f, 115.8f, 60.68889f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(57.790684f, 34.2f);
                l.lineTo(62.209316f, 34.2f);
                l.cubicTo(63.301052f, 34.2f, 64.16696f, 35.09441f, 64.12621f, 36.197716f);
                l.lineTo(62.836727f, 71.10812f);
                l.cubicTo(62.816696f, 71.650375f, 62.35176f, 72.10244f, 61.798832f, 72.10244f);
                l.lineTo(58.201168f, 72.10244f);
                l.cubicTo(57.639423f, 72.10244f, 57.183556f, 71.65727f, 57.163273f, 71.10812f);
                l.lineTo(55.87379f, 36.197716f);
                l.cubicTo(55.833225f, 35.099537f, 56.691257f, 34.2f, 57.790684f, 34.2f);
                l.close();
                l.moveTo(60.0f, 85.8f);
                l.cubicTo(57.680405f, 85.8f, 55.8f, 83.91959f, 55.8f, 81.6f);
                l.cubicTo(55.8f, 79.2804f, 57.680405f, 77.4f, 60.0f, 77.4f);
                l.cubicTo(62.319595f, 77.4f, 64.2f, 79.2804f, 64.2f, 81.6f);
                l.cubicTo(64.2f, 83.91959f, 62.319595f, 85.8f, 60.0f, 85.8f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
