package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aoh extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                k2 = c.a(k, looper);
                k2.setColor(-1);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(125.0608f, 0.0f);
                l.cubicTo(144.336f, 0.0f, 153.9712f, 0.0f, 164.3472f, 3.28f);
                l.cubicTo(175.6752f, 7.4032f, 184.5968f, 16.3248f, 188.72f, 27.6528f);
                l.cubicTo(192.0f, 38.0272f, 192.0f, 47.6656f, 192.0f, 66.9392f);
                l.lineTo(192.0f, 125.0608f);
                l.cubicTo(192.0f, 144.336f, 192.0f, 153.9712f, 188.72f, 164.3472f);
                l.cubicTo(184.5968f, 175.6752f, 175.6752f, 184.5968f, 164.3472f, 188.7184f);
                l.cubicTo(153.9712f, 192.0f, 144.336f, 192.0f, 125.0608f, 192.0f);
                l.lineTo(66.9392f, 192.0f);
                l.cubicTo(47.664f, 192.0f, 38.0272f, 192.0f, 27.6528f, 188.7184f);
                l.cubicTo(16.3248f, 184.5968f, 7.4032f, 175.6752f, 3.28f, 164.3472f);
                l.cubicTo(0.0f, 153.9712f, 0.0f, 144.336f, 0.0f, 125.0608f);
                l.lineTo(0.0f, 66.9392f);
                l.cubicTo(0.0f, 47.6656f, 0.0f, 38.0272f, 3.28f, 27.6528f);
                l.cubicTo(7.4032f, 16.3248f, 16.3248f, 7.4032f, 27.6528f, 3.28f);
                l.cubicTo(38.0272f, 0.0f, 47.664f, 0.0f, 66.9392f, 0.0f);
                l.lineTo(125.0608f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                k2 = c.a(k, looper);
                k2.setColor(419430400);
                canvas.save();
                k = c.a(k2, looper);
                l = c.l(looper);
                l.moveTo(125.0608f, 0.0f);
                l.cubicTo(144.336f, 0.0f, 153.9712f, 0.0f, 164.3472f, 3.28f);
                l.cubicTo(175.6752f, 7.4032f, 184.5968f, 16.3248f, 188.72f, 27.6528f);
                l.cubicTo(192.0f, 38.0272f, 192.0f, 47.6656f, 192.0f, 66.9392f);
                l.lineTo(192.0f, 125.0608f);
                l.cubicTo(192.0f, 144.336f, 192.0f, 153.9712f, 188.72f, 164.3472f);
                l.cubicTo(184.5968f, 175.6752f, 175.6752f, 184.5968f, 164.3472f, 188.7184f);
                l.cubicTo(153.9712f, 192.0f, 144.336f, 192.0f, 125.0608f, 192.0f);
                l.lineTo(66.9392f, 192.0f);
                l.cubicTo(47.664f, 192.0f, 38.0272f, 192.0f, 27.6528f, 188.7184f);
                l.cubicTo(16.3248f, 184.5968f, 7.4032f, 175.6752f, 3.28f, 164.3472f);
                l.cubicTo(0.0f, 153.9712f, 0.0f, 144.336f, 0.0f, 125.0608f);
                l.lineTo(0.0f, 66.9392f);
                l.cubicTo(0.0f, 47.6656f, 0.0f, 38.0272f, 3.28f, 27.6528f);
                l.cubicTo(7.4032f, 16.3248f, 16.3248f, 7.4032f, 27.6528f, 3.28f);
                l.cubicTo(38.0272f, 0.0f, 47.664f, 0.0f, 66.9392f, 0.0f);
                l.lineTo(125.0608f, 0.0f);
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
