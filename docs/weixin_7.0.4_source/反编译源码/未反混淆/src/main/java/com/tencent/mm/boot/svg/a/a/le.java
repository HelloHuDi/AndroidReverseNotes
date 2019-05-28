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

public final class le extends c {
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
                l.close();
                l.moveTo(51.0f, 98.0f);
                l.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                l.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                l.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                l.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                a3 = c.a(a3, 1.0f, 0.0f, 12.65625f, 0.0f, 1.0f, 21.515625f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(1.8785756f, 23.757034f);
                l.cubicTo(1.2973921f, 23.163979f, 1.223493f, 22.150276f, 1.7250522f, 21.477392f);
                l.lineTo(3.0639734f, 19.681114f);
                l.cubicTo(3.5603683f, 19.015158f, 4.4945054f, 18.877115f, 5.1620426f, 19.381565f);
                l.lineTo(18.21077f, 29.242313f);
                l.cubicTo(18.873106f, 29.742832f, 19.922352f, 29.727772f, 20.574799f, 29.191858f);
                l.lineTo(54.486485f, 1.3371443f);
                l.cubicTo(55.12977f, 0.8087597f, 56.12762f, 0.8442794f, 56.730663f, 1.4314854f);
                l.lineTo(57.70836f, 2.3835058f);
                l.cubicTo(58.304504f, 2.9639935f, 58.30409f, 3.9039125f, 57.71406f, 4.4764366f);
                l.lineTo(20.482594f, 40.603558f);
                l.cubicTo(19.889599f, 41.178963f, 18.940239f, 41.167206f, 18.356556f, 40.5716f);
                l.lineTo(1.8785756f, 23.757034f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
