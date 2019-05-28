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

public final class awv extends c {
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
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-15028967);
                l = c.l(looper);
                l.moveTo(46.279175f, 21.000214f);
                l.lineTo(46.279175f, 44.5821f);
                l.lineTo(33.04137f, 33.706234f);
                l.lineTo(31.0f, 36.192547f);
                l.lineTo(45.37214f, 47.999035f);
                l.lineTo(31.0f, 59.806595f);
                l.lineTo(33.04137f, 62.292908f);
                l.lineTo(46.279175f, 51.41704f);
                l.lineTo(46.279175f, 75.0f);
                l.lineTo(64.73941f, 59.746555f);
                l.lineTo(50.43911f, 47.999035f);
                l.lineTo(64.73941f, 36.251514f);
                l.lineTo(46.279175f, 21.000214f);
                l.close();
                l.moveTo(49.495617f, 27.828722f);
                l.lineTo(59.68102f, 36.244007f);
                l.lineTo(49.495617f, 44.61212f);
                l.lineTo(49.495617f, 27.828722f);
                l.close();
                l.moveTo(49.495617f, 51.38595f);
                l.lineTo(59.68102f, 59.75299f);
                l.lineTo(49.495617f, 68.16935f);
                l.lineTo(49.495617f, 51.38595f);
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
