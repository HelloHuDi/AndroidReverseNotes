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

public final class aqh extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(59.0f, 65.0f);
                l.lineTo(73.0f, 65.0f);
                l.lineTo(73.0f, 56.0f);
                l.lineTo(78.0f, 56.0f);
                l.lineTo(78.0f, 40.0f);
                l.lineTo(73.0f, 40.0f);
                l.lineTo(73.0f, 31.0f);
                l.lineTo(59.0f, 31.0f);
                l.lineTo(59.0f, 25.0f);
                l.lineTo(38.0f, 25.0f);
                l.lineTo(38.0f, 31.0f);
                l.lineTo(23.0f, 31.0f);
                l.lineTo(23.0f, 40.0f);
                l.lineTo(18.0f, 40.0f);
                l.lineTo(18.0f, 56.0f);
                l.lineTo(23.0f, 56.0f);
                l.lineTo(23.0f, 65.0f);
                l.lineTo(38.0f, 65.0f);
                l.lineTo(38.0f, 71.0f);
                l.lineTo(59.0f, 71.0f);
                l.lineTo(59.0f, 65.0f);
                l.close();
                l.moveTo(18.0f, 28.000444f);
                l.cubicTo(18.0f, 26.343344f, 19.337309f, 25.0f, 20.995937f, 25.0f);
                l.lineTo(75.00406f, 25.0f);
                l.cubicTo(76.658676f, 25.0f, 78.0f, 26.35178f, 78.0f, 28.000444f);
                l.lineTo(78.0f, 67.99956f);
                l.cubicTo(78.0f, 69.656654f, 76.66269f, 71.0f, 75.00406f, 71.0f);
                l.lineTo(20.995937f, 71.0f);
                l.cubicTo(19.341328f, 71.0f, 18.0f, 69.64822f, 18.0f, 67.99956f);
                l.lineTo(18.0f, 28.000444f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(37.75862f, 45.672413f);
                l2.lineTo(36.0f, 49.189655f);
                l2.lineTo(43.91379f, 58.86207f);
                l2.lineTo(61.5f, 37.75862f);
                l2.lineTo(59.74138f, 36.0f);
                l2.lineTo(43.91379f, 50.948277f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
