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

public final class il extends c {
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
                a.setColor(-15683841);
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
                l.moveTo(62.12374f, 65.15995f);
                l.lineTo(60.59251f, 27.389608f);
                l.cubicTo(60.57021f, 26.839443f, 60.108807f, 26.4f, 59.561615f, 26.4f);
                l.lineTo(55.54317f, 26.4f);
                l.cubicTo(55.00337f, 26.4f, 54.53443f, 26.843063f, 54.51227f, 27.389608f);
                l.lineTo(52.833233f, 68.80597f);
                l.cubicTo(52.807594f, 69.43838f, 53.077152f, 69.998924f, 53.51898f, 70.363365f);
                l.cubicTo(53.700817f, 70.78672f, 54.031994f, 71.146774f, 54.481876f, 71.3614f);
                l.lineTo(81.584015f, 84.290726f);
                l.cubicTo(82.09355f, 84.5338f, 82.71503f, 84.33845f, 82.98967f, 83.862755f);
                l.lineTo(84.3951f, 81.42847f);
                l.cubicTo(84.6709f, 80.95077f, 84.51857f, 80.31419f, 84.05744f, 80.00215f);
                l.lineTo(62.12374f, 65.15995f);
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
